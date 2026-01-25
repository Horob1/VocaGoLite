package com.horob1.vocagolite.presentation.screen.onboarding

import com.horob1.vocagolite.domain.model.AppLanguage
import com.horob1.vocagolite.domain.model.AppTheme

/**
 * UI State for OnBoarding screen settings
 */
data class OnBoardingUiState(
    val appLanguage: AppLanguage = AppLanguage.defaultLanguage,
    val appTheme: AppTheme = AppTheme.defaultTheme
)

/**
 * Dialog state for language change confirmation
 */
data class LanguageDialogState(
    val isVisible: Boolean = false,
    val pendingLanguage: AppLanguage? = null
)
