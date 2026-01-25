package com.horob1.vocagolite.presentation.screen.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horob1.vocagolite.domain.model.AppLanguage
import com.horob1.vocagolite.domain.model.AppTheme
import com.horob1.vocagolite.domain.usecase.setting.GetAppLanguageUseCase
import com.horob1.vocagolite.domain.usecase.setting.GetAppThemeUseCase
import com.horob1.vocagolite.domain.usecase.setting.SetAppLanguageUseCase
import com.horob1.vocagolite.domain.usecase.setting.SetAppThemeUseCase
import com.horob1.vocagolite.domain.usecase.setting.SetFirstTimeLaunchUseCase
import com.horob1.vocagolite.presentation.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class OnBoardingViewModel(
    private val getAppLanguageUseCase: GetAppLanguageUseCase,
    private val getAppThemeUseCase: GetAppThemeUseCase,
    private val setFirstTimeLaunchUseCase: SetFirstTimeLaunchUseCase,
    private val setAppThemeUseCase: SetAppThemeUseCase,
    private val setAppLanguageUseCase: SetAppLanguageUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<OnBoardingUiState>>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    init {
        loadSettings()
    }

    private fun loadSettings() {
        combine(
            getAppLanguageUseCase(),
            getAppThemeUseCase()
        ) { appLanguage, appTheme ->
            OnBoardingUiState(
                appLanguage = appLanguage,
                appTheme = appTheme
            )
        }
            .onStart { _uiState.value = UiState.Loading }
            .onEach { settings -> _uiState.value = UiState.Success(settings) }
            .launchIn(viewModelScope)
    }

    fun setAppTheme(theme: AppTheme) {
        viewModelScope.launch {
            setAppThemeUseCase(theme)
        }
    }

    fun setAppLanguage(language: AppLanguage) {
        viewModelScope.launch {
            setAppLanguageUseCase(language)
        }
    }

    fun completeOnBoarding() {
        viewModelScope.launch {
            setFirstTimeLaunchUseCase(false)
        }
    }
}