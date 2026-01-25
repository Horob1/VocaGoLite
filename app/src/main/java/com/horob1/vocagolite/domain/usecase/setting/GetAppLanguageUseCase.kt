package com.horob1.vocagolite.domain.usecase.setting

import com.horob1.vocagolite.domain.model.AppLanguage
import com.horob1.vocagolite.domain.repository.SettingRepository
import kotlinx.coroutines.flow.Flow

class GetAppLanguageUseCase(
    private val settingRepository: SettingRepository
) {
    operator fun invoke(): Flow<AppLanguage> = settingRepository.appLanguage
}
