package com.horob1.vocagolite.domain.usecase.setting

import com.horob1.vocagolite.domain.model.AppLanguage
import com.horob1.vocagolite.domain.repository.SettingRepository

class SetAppLanguageUseCase(
    private val settingRepository: SettingRepository
) {
    suspend operator fun invoke(language: AppLanguage) = settingRepository.setAppLanguage(language)
}
