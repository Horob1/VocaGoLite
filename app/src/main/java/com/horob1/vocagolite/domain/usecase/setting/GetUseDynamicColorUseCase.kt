package com.horob1.vocagolite.domain.usecase.setting

import com.horob1.vocagolite.domain.repository.SettingRepository
import kotlinx.coroutines.flow.Flow

class GetUseDynamicColorUseCase(
    private val settingRepository: SettingRepository
) {
    operator fun invoke(): Flow<Boolean> = settingRepository.useDynamicColor
}
