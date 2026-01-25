package com.horob1.vocagolite.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ----------------------------
// Font Families
// ----------------------------


// ----------------------------
// Helper function for scale
// ----------------------------
fun typographyScale(
    displaySize: Float,
    headlineSize: Float,
    titleSize: Float,
    bodySize: Float,
    labelSize: Float
) = Typography(
    // ==================== Display Styles ====================
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = displaySize.sp,
        lineHeight = (displaySize * 1.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = (displaySize * 0.85).sp,
        lineHeight = (displaySize * 1.2).sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = (displaySize * 0.7).sp,
        lineHeight = (displaySize * 1.15).sp
    ),

    // ==================== Headline Styles ====================
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = headlineSize.sp,
        lineHeight = (headlineSize * 1.2).sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = (headlineSize * 0.85).sp,
        lineHeight = (headlineSize * 1.15).sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = (headlineSize * 0.7).sp,
        lineHeight = (headlineSize * 1.1).sp
    ),

    // ==================== Title Styles ====================
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = titleSize.sp,
        lineHeight = (titleSize * 1.4).sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = (titleSize * 0.9).sp,
        lineHeight = (titleSize * 1.35).sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = (titleSize * 0.8).sp,
        lineHeight = (titleSize * 1.3).sp
    ),

    // ==================== Body Styles ====================
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = bodySize.sp,
        lineHeight = (bodySize * 1.5).sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = (bodySize * 0.9).sp,
        lineHeight = (bodySize * 1.45).sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = (bodySize * 0.8).sp,
        lineHeight = (bodySize * 1.4).sp
    ),

    // ==================== Label Styles ====================
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = labelSize.sp,
        lineHeight = (labelSize * 1.35).sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = (labelSize * 0.9).sp,
        lineHeight = (labelSize * 1.3).sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = (labelSize * 0.8).sp,
        lineHeight = (labelSize * 1.25).sp
    )
)

// ----------------------------
// Responsive Typography Sets
// ----------------------------
val CompactSmallTypography = typographyScale(
    displaySize = 22f,
    headlineSize = 16f,
    titleSize = 10f,
    bodySize = 10f,
    labelSize = 10f
)

val CompactMediumTypography = typographyScale(
    displaySize = 32f,
    headlineSize = 24f,
    titleSize = 14f,
    bodySize = 14f,
    labelSize = 12f
)

val CompactTypography = typographyScale(
    displaySize = 28f,
    headlineSize = 22f,
    titleSize = 14f,
    bodySize = 13f,
    labelSize = 12f
)

val MediumTypography = typographyScale(
    displaySize = 38f,
    headlineSize = 30f,
    titleSize = 16f,
    bodySize = 15f,
    labelSize = 14f
)

val ExpandedTypography = typographyScale(
    displaySize = 42f,
    headlineSize = 34f,
    titleSize = 18f,
    bodySize = 16f,
    labelSize = 15f
)

// Default Typography (for backward compatibility)
val Typography = CompactTypography
