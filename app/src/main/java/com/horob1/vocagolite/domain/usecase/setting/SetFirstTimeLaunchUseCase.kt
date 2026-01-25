package com.horob1.vocagolite.domain.usecase.setting

import com.horob1.vocagolite.domain.repository.SettingRepository

class SetFirstTimeLaunchUseCase(
    private val settingRepository: SettingRepository
) {
    suspend operator fun invoke(firstTimeLaunch: Boolean) =
        settingRepository.setFirstTimeLaunchApp(firstTimeLaunch)
}
