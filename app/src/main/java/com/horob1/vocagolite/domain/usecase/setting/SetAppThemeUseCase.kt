package com.horob1.vocagolite.domain.usecase.setting

import com.horob1.vocagolite.domain.model.AppTheme
import com.horob1.vocagolite.domain.repository.SettingRepository

class SetAppThemeUseCase(
    private val settingRepository: SettingRepository
) {
    suspend operator fun invoke(theme: AppTheme) = settingRepository.setAppTheme(theme)
}
