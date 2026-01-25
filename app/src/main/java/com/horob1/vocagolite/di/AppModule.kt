package com.horob1.vocagolite.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    infrastructureModule,
    localModule,
    remoteModule,
    repoModule,
    useCaseModule,
    viewModelModule
)