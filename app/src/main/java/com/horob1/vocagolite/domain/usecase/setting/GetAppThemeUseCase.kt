package com.horob1.vocagolite.domain.usecase.setting

import com.horob1.vocagolite.domain.model.AppTheme
import com.horob1.vocagolite.domain.repository.SettingRepository
import kotlinx.coroutines.flow.Flow

class GetAppThemeUseCase(
    private val settingRepository: SettingRepository
) {
    operator fun invoke(): Flow<AppTheme> = settingRepository.appTheme
}
