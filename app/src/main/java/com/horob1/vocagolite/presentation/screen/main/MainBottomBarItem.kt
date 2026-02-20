package com.horob1.vocagolite.presentation.screen.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.horob1.vocagolite.R
import com.horob1.vocagolite.presentation.navigation.NavScreen

sealed class MainBottomBarItem(
    val route: NavScreen,
    @StringRes val title: Int,
    val icon: ImageVector,
) {
    data object Home : MainBottomBarItem(
        route = NavScreen.Home,
        title = R.string.main_home,
        icon = Icons.Default.Home
    )

    data object Explore : MainBottomBarItem(
        route = NavScreen.Explore,
        title = R.string.main_explore,
        icon = Icons.Default.Explore,
    )

    data object Setting : MainBottomBarItem(
        route = NavScreen.Setting,
        title = R.string.main_setting,
        icon = Icons.Default.Settings,
    )

    data object About : MainBottomBarItem(
        route = NavScreen.About,
        title = R.string.main_about,
        icon = Icons.Default.Info,
    )

    companion object {
        val items = listOf(Home, Explore, Setting, About)
    }
}