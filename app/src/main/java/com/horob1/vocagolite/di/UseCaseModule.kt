package com.horob1.vocagolite.di

import com.horob1.vocagolite.domain.usecase.setting.GetAppLanguageUseCase
import com.horob1.vocagolite.domain.usecase.setting.GetAppThemeUseCase
import com.horob1.vocagolite.domain.usecase.setting.GetFirstTimeLaunchUseCase
import com.horob1.vocagolite.domain.usecase.setting.GetUseDynamicColorUseCase
import com.horob1.vocagolite.domain.usecase.setting.SetAppLanguageUseCase
import com.horob1.vocagolite.domain.usecase.setting.SetAppThemeUseCase
import com.horob1.vocagolite.domain.usecase.setting.SetFirstTimeLaunchUseCase
import com.horob1.vocagolite.domain.usecase.setting.SetUseDynamicColorUseCase
import org.koin.dsl.module

val useCaseModule = module {
    // Setting
    single { GetAppThemeUseCase(get()) }
    single { GetUseDynamicColorUseCase(get()) }
    single { GetAppLanguageUseCase(get()) }
    single { GetFirstTimeLaunchUseCase(get()) }

    single { SetAppThemeUseCase(get()) }
    single { SetAppLanguageUseCase(get()) }
    single { SetFirstTimeLaunchUseCase(get()) }
    single { SetUseDynamicColorUseCase(get()) }

}