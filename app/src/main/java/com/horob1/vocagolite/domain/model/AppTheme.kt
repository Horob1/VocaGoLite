package com.horob1.vocagolite.domain.model

sealed class AppTheme(val themeName: String) {
    data object LightTheme : AppTheme("LIGHT_THEME")
    data object DarkTheme : AppTheme("DARK_THEME")
    data object SystemTheme : AppTheme("SYSTEM_THEME")

    companion object {
        val defaultTheme = SystemTheme
        val defaultName = defaultTheme.themeName
        val allThemes = listOf(LightTheme, DarkTheme, SystemTheme)

        fun fromString(theme: String): AppTheme {
            return when (theme) {
                LightTheme.themeName -> LightTheme
                DarkTheme.themeName -> DarkTheme
                SystemTheme.themeName -> SystemTheme
                else -> defaultTheme
            }
        }
    }
}