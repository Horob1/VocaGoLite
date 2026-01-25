package com.horob1.vocagolite.domain.model

sealed class AppLanguage(
    val languageCode: String,
    val languageName: String,
    val displayName: String,
) {
    data object English : AppLanguage(
        languageCode = "en",
        languageName = "English",
        displayName = "English"
    )

    data object Vietnamese : AppLanguage(
        languageCode = "vi",
        languageName = "Vietnamese",
        displayName = "Tiếng Việt"
    )

    data object SystemLanguage : AppLanguage(
        languageCode = "sys",
        languageName = "System Language",
        displayName = "System Language/ Theo Hệ Thống"
    )

    companion object {
        val defaultLanguage = English
        val allLanguages = listOf(English, Vietnamese, SystemLanguage)
        fun fromString(language: String): AppLanguage {
            return when (language) {
                English.languageCode -> English
                Vietnamese.languageCode -> Vietnamese
                SystemLanguage.languageCode -> SystemLanguage
                else -> defaultLanguage
            }
        }
    }
}