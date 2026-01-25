package com.horob1.vocagolite.presentation.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val BlueSky = Color(0xFF4478a9)
val NightSky = Color(0xFF333333)
val BorderColor = Color(0x40000000)

// === LIGHT THEME (Refined Earth Tone) ===
val LightColorScheme = lightColorScheme(
    primary = Color(0xFF9E6B3F),
    primaryContainer = Color(0xFFE8D7C6),
    secondary = Color(0xFFC89B3C),
    secondaryContainer = Color(0xFFF3E6C8),
    tertiary = Color(0xFFB87A4B),
    background = Color(0xFFF8F6F3),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFF3A2A18),
    onBackground = Color(0xFF2E1E14),
    onSurface = Color(0xFF2E1E14),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF),
    outline = Color(0xFFB8A38B),
)

// === DARK THEME (Warm Dark / Coffee) ===
val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD4A373),
    primaryContainer = Color(0xFF5C3B1F),
    secondary = Color(0xFFE6C28A),
    secondaryContainer = Color(0xFF6A4A2F),
    tertiary = Color(0xFFD9A066),
    background = Color(0xFF12100E),
    surface = Color(0xFF1C1916),
    onPrimary = Color(0xFF2B1A0E),
    onSecondary = Color(0xFF2B1A0E),
    onBackground = Color(0xFFF2ECE4),
    onSurface = Color(0xFFF2ECE4),
    error = Color(0xFFCF6679),
    onError = Color(0xFF1A120C),
    outline = Color(0xFF8E7C6A),
)

// ==================== Custom App Colors ====================
@Immutable
data class AppColors(
    // Status Colors
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,

    val warning: Color,
    val onWarning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,

    val info: Color,
    val onInfo: Color,
    val infoContainer: Color,
    val onInfoContainer: Color,

    // Text Colors
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textDisabled: Color,
    val textLink: Color,

    // Divider & Border
    val divider: Color,
    val border: Color,
    val borderFocused: Color,

    // Overlay & Scrim
    val overlay: Color,
    val scrim: Color,

    // Card & Container Variants
    val cardBackground: Color,
    val cardBackgroundElevated: Color,

    // Shimmer / Skeleton Loading
    val shimmerBase: Color,
    val shimmerHighlight: Color,

    // Rating & Stars
    val ratingStar: Color,
    val ratingStarEmpty: Color,

    // Progress
    val progressTrack: Color,
    val progressIndicator: Color,

    // Tag / Badge
    val tagBackground: Color,
    val tagText: Color,

    // Correct / Incorrect (for quiz/learning app)
    val correct: Color,
    val onCorrect: Color,
    val incorrect: Color,
    val onIncorrect: Color,

    // Streak / Achievement
    val streak: Color,
    val achievement: Color,
)

val LightAppColors = AppColors(
    // Status Colors
    success = Color(0xFF4CAF50),
    onSuccess = Color(0xFFFFFFFF),
    successContainer = Color(0xFFE8F5E9),
    onSuccessContainer = Color(0xFF1B5E20),

    warning = Color(0xFFFFC107),
    onWarning = Color(0xFF1A1A1A),
    warningContainer = Color(0xFFFFF8E1),
    onWarningContainer = Color(0xFF5D4037),

    info = Color(0xFF2196F3),
    onInfo = Color(0xFFFFFFFF),
    infoContainer = Color(0xFFE3F2FD),
    onInfoContainer = Color(0xFF0D47A1),

    // Text Colors
    textPrimary = Color(0xFF2E1E14),
    textSecondary = Color(0xFF5D4037),
    textTertiary = Color(0xFF8D7B6B),
    textDisabled = Color(0xFFBDAA9A),
    textLink = Color(0xFF9E6B3F),

    // Divider & Border
    divider = Color(0xFFE0D5C9),
    border = Color(0xFFD7C9B8),
    borderFocused = Color(0xFF9E6B3F),

    // Overlay & Scrim
    overlay = Color(0x1A000000),
    scrim = Color(0x80000000),

    // Card & Container
    cardBackground = Color(0xFFFFFFFF),
    cardBackgroundElevated = Color(0xFFFAF8F5),

    // Shimmer
    shimmerBase = Color(0xFFE8E0D5),
    shimmerHighlight = Color(0xFFF5F0E8),

    // Rating
    ratingStar = Color(0xFFFFC107),
    ratingStarEmpty = Color(0xFFD7C9B8),

    // Progress
    progressTrack = Color(0xFFE8D7C6),
    progressIndicator = Color(0xFF9E6B3F),

    // Tag
    tagBackground = Color(0xFFF3E6C8),
    tagText = Color(0xFF5D4037),

    // Correct / Incorrect
    correct = Color(0xFF4CAF50),
    onCorrect = Color(0xFFFFFFFF),
    incorrect = Color(0xFFE53935),
    onIncorrect = Color(0xFFFFFFFF),

    // Streak / Achievement
    streak = Color(0xFFFF9800),
    achievement = Color(0xFFFFC107),
)

val DarkAppColors = AppColors(
    // Status Colors
    success = Color(0xFF81C784),
    onSuccess = Color(0xFF1A1A1A),
    successContainer = Color(0xFF2E5A30),
    onSuccessContainer = Color(0xFFC8E6C9),

    warning = Color(0xFFFFD54F),
    onWarning = Color(0xFF1A1A1A),
    warningContainer = Color(0xFF5D4A1F),
    onWarningContainer = Color(0xFFFFF8E1),

    info = Color(0xFF64B5F6),
    onInfo = Color(0xFF1A1A1A),
    infoContainer = Color(0xFF1E3A5F),
    onInfoContainer = Color(0xFFBBDEFB),

    // Text Colors
    textPrimary = Color(0xFFF2ECE4),
    textSecondary = Color(0xFFD4C8BA),
    textTertiary = Color(0xFFA89888),
    textDisabled = Color(0xFF6B5F53),
    textLink = Color(0xFFD4A373),

    // Divider & Border
    divider = Color(0xFF3D3530),
    border = Color(0xFF4A4038),
    borderFocused = Color(0xFFD4A373),

    // Overlay & Scrim
    overlay = Color(0x33FFFFFF),
    scrim = Color(0xCC000000),

    // Card & Container
    cardBackground = Color(0xFF1C1916),
    cardBackgroundElevated = Color(0xFF252220),

    // Shimmer
    shimmerBase = Color(0xFF2A2522),
    shimmerHighlight = Color(0xFF3D3530),

    // Rating
    ratingStar = Color(0xFFFFD54F),
    ratingStarEmpty = Color(0xFF4A4038),

    // Progress
    progressTrack = Color(0xFF3D3530),
    progressIndicator = Color(0xFFD4A373),

    // Tag
    tagBackground = Color(0xFF3D3530),
    tagText = Color(0xFFD4C8BA),

    // Correct / Incorrect
    correct = Color(0xFF81C784),
    onCorrect = Color(0xFF1A1A1A),
    incorrect = Color(0xFFEF5350),
    onIncorrect = Color(0xFF1A1A1A),

    // Streak / Achievement
    streak = Color(0xFFFFB74D),
    achievement = Color(0xFFFFD54F),
)

