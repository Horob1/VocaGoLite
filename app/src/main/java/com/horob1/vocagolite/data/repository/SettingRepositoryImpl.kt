package com.horob1.vocagolite.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.horob1.vocagolite.domain.model.AppLanguage
import com.horob1.vocagolite.domain.model.AppTheme
import com.horob1.vocagolite.domain.repository.SettingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingRepositoryImpl(
    private val context: Context
) : SettingRepository {

    companion object {
        private val APP_THEME_KEY = stringPreferencesKey("app_theme")
        private val USE_DYNAMIC_COLOR_KEY = booleanPreferencesKey("use_dynamic_color")
        private val APP_LANGUAGE_KEY = stringPreferencesKey("app_language")
        private val FIRST_TIME_LAUNCH_KEY = booleanPreferencesKey("first_time_launch")
    }

    override val appTheme: Flow<AppTheme>
        get() = context.dataStore.data.map { preferences ->
            val themeName = preferences[APP_THEME_KEY] ?: AppTheme.defaultName
            AppTheme.fromString(themeName)
        }

    override val useDynamicColor: Flow<Boolean>
        get() = context.dataStore.data.map { preferences ->
            preferences[USE_DYNAMIC_COLOR_KEY] ?: true
        }

    override val appLanguage: Flow<AppLanguage>
        get() = context.dataStore.data.map { preferences ->
            val languageCode =
                preferences[APP_LANGUAGE_KEY] ?: AppLanguage.defaultLanguage.languageCode
            AppLanguage.fromString(languageCode)
        }

    override val firstTimeLaunchApp: Flow<Boolean>
        get() = context.dataStore.data.map { preferences ->
            preferences[FIRST_TIME_LAUNCH_KEY] ?: true
        }

    override suspend fun setAppTheme(theme: AppTheme) {
        context.dataStore.edit { preferences ->
            preferences[APP_THEME_KEY] = theme.themeName
        }
    }

    override suspend fun setUseDynamicColor(useDynamicColor: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[USE_DYNAMIC_COLOR_KEY] = useDynamicColor
        }
    }

    override suspend fun setAppLanguage(language: AppLanguage) {
        context.dataStore.edit { preferences ->
            preferences[APP_LANGUAGE_KEY] = language.languageCode
        }
    }

    override suspend fun setFirstTimeLaunchApp(firstTimeLaunchApp: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[FIRST_TIME_LAUNCH_KEY] = firstTimeLaunchApp
        }
    }
}
