package com.horob1.vocagolite.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavScreen {
    @Serializable
    data object OnBoarding : NavScreen()

    @Serializable
    data object Main : NavScreen()

    @Serializable
    data object Home : NavScreen()

    @Serializable
    data object Setting : NavScreen()

    @Serializable
    data object About : NavScreen()

    @Serializable
    data object Explore : NavScreen()
}