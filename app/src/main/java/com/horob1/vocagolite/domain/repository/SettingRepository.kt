package com.horob1.vocagolite.domain.repository

import com.horob1.vocagolite.domain.model.AppLanguage
import com.horob1.vocagolite.domain.model.AppTheme
import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    val appTheme: Flow<AppTheme>
    val useDynamicColor: Flow<Boolean>
    val appLanguage: Flow<AppLanguage>
    val firstTimeLaunchApp: Flow<Boolean>

    suspend fun setAppTheme(theme: AppTheme)
    suspend fun setUseDynamicColor(useDynamicColor: Boolean)
    suspend fun setAppLanguage(language: AppLanguage)
    suspend fun setFirstTimeLaunchApp(firstTimeLaunchApp: Boolean)
}