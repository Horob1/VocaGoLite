package com.horob1.vocagolite.domain.usecase.setting

import com.horob1.vocagolite.domain.repository.SettingRepository

class SetUseDynamicColorUseCase(
    private val settingRepository: SettingRepository
) {
    suspend operator fun invoke(useDynamicColor: Boolean) =
        settingRepository.setUseDynamicColor(useDynamicColor)
}
