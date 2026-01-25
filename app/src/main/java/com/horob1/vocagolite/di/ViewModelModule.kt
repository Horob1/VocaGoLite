package com.horob1.vocagolite.di

import com.horob1.vocagolite.presentation.screen.onboarding.OnBoardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<OnBoardingViewModel> {
        OnBoardingViewModel(
            get(),
            get(),
            get(),
            get(),
            get(),
        )
    }
}