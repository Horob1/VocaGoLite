package com.horob1.vocagolite.di

import com.horob1.vocagolite.data.repository.SettingRepositoryImpl
import com.horob1.vocagolite.domain.repository.SettingRepository
import org.koin.dsl.module

val repoModule = module {
    single<SettingRepository> {
        SettingRepositoryImpl(get())
    }
}

