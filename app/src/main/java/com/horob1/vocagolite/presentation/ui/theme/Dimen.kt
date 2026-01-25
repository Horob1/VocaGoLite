package com.horob1.vocagolite.presentation.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimen(
    // ==================== Spacing ====================
    val spaceNone: Dp = 0.dp,
    val spaceXXS: Dp = 2.dp,
    val spaceXS: Dp = 4.dp,
    val spaceSM: Dp = 8.dp,
    val spaceMD: Dp = 12.dp,
    val spaceLG: Dp = 16.dp,
    val spaceXL: Dp = 24.dp,
    val spaceXXL: Dp = 32.dp,
    val spaceXXXL: Dp = 48.dp,
    val spaceHuge: Dp = 64.dp,

    // ==================== Padding ====================
    val paddingXS: Dp = 4.dp,
    val paddingSM: Dp = 8.dp,
    val paddingMD: Dp = 12.dp,
    val paddingLG: Dp = 16.dp,
    val paddingXL: Dp = 20.dp,
    val paddingXXL: Dp = 24.dp,
    val paddingScreen: Dp = 16.dp,

    // ==================== Icon Sizes ====================
    val iconXXS: Dp = 12.dp,
    val iconXS: Dp = 16.dp,
    val iconSM: Dp = 20.dp,
    val iconMD: Dp = 24.dp,
    val iconLG: Dp = 32.dp,
    val iconXL: Dp = 40.dp,
    val iconXXL: Dp = 48.dp,
    val iconHuge: Dp = 64.dp,
    val iconGiant: Dp = 96.dp,

    // ==================== Logo Sizes ====================
    val logoSM: Dp = 32.dp,
    val logoMD: Dp = 48.dp,
    val logoLG: Dp = 64.dp,
    val logoXL: Dp = 96.dp,
    val logoXXL: Dp = 128.dp,

    // ==================== Button Heights ====================
    val buttonHeightXS: Dp = 28.dp,
    val buttonHeightSM: Dp = 36.dp,
    val buttonHeightMD: Dp = 44.dp,
    val buttonHeightLG: Dp = 52.dp,
    val buttonHeightXL: Dp = 60.dp,

    // ==================== Button Widths ====================
    val buttonWidthSM: Dp = 80.dp,
    val buttonWidthMD: Dp = 120.dp,
    val buttonWidthLG: Dp = 160.dp,
    val buttonWidthXL: Dp = 200.dp,
    val buttonWidthFull: Dp = Dp.Unspecified,

    // ==================== FAB Sizes ====================
    val fabSizeSM: Dp = 40.dp,
    val fabSizeMD: Dp = 56.dp,
    val fabSizeLG: Dp = 72.dp,

    // ==================== Corner Radius ====================
    val cornerNone: Dp = 0.dp,
    val cornerXS: Dp = 4.dp,
    val cornerSM: Dp = 8.dp,
    val cornerMD: Dp = 12.dp,
    val cornerLG: Dp = 16.dp,
    val cornerXL: Dp = 24.dp,
    val cornerXXL: Dp = 32.dp,
    val cornerFull: Dp = 999.dp,

    // ==================== Card & Container ====================
    val cardElevation: Dp = 4.dp,
    val cardElevationHigh: Dp = 8.dp,
    val cardMinHeight: Dp = 80.dp,
    val cardMaxWidth: Dp = 400.dp,
    val containerMinHeight: Dp = 48.dp,

    // ==================== Divider & Border ====================
    val dividerThickness: Dp = 1.dp,
    val borderThin: Dp = 1.dp,
    val borderMedium: Dp = 2.dp,
    val borderThick: Dp = 4.dp,

    // ==================== Avatar Sizes ====================
    val avatarXS: Dp = 24.dp,
    val avatarSM: Dp = 32.dp,
    val avatarMD: Dp = 40.dp,
    val avatarLG: Dp = 56.dp,
    val avatarXL: Dp = 72.dp,
    val avatarXXL: Dp = 96.dp,

    // ==================== Input Fields ====================
    val inputHeight: Dp = 56.dp,
    val inputHeightSM: Dp = 44.dp,
    val inputHeightLG: Dp = 64.dp,
    val inputMinWidth: Dp = 200.dp,

    // ==================== Bottom Bar & App Bar ====================
    val topAppBarHeight: Dp = 56.dp,
    val topAppBarHeightLarge: Dp = 64.dp,
    val bottomBarHeight: Dp = 80.dp,
    val bottomBarItemSize: Dp = 56.dp,

    // ==================== Image Sizes ====================
    val thumbnailSM: Dp = 48.dp,
    val thumbnailMD: Dp = 80.dp,
    val thumbnailLG: Dp = 120.dp,
    val imageBannerHeight: Dp = 200.dp,
    val imageCardHeight: Dp = 160.dp,

    // ==================== Progress & Indicator ====================
    val progressHeight: Dp = 4.dp,
    val progressHeightLG: Dp = 8.dp,
    val indicatorSize: Dp = 48.dp,
    val indicatorSizeSM: Dp = 24.dp,

    // ==================== Chip & Badge ====================
    val chipHeight: Dp = 32.dp,
    val chipHeightSM: Dp = 24.dp,
    val badgeSize: Dp = 20.dp,
    val badgeSizeSM: Dp = 16.dp,

    // ==================== Sheet & Dialog ====================
    val sheetPeekHeight: Dp = 56.dp,
    val dialogMinWidth: Dp = 280.dp,
    val dialogMaxWidth: Dp = 560.dp,
    val dialogPadding: Dp = 24.dp,

    // ==================== Touch Targets ====================
    val touchTargetMin: Dp = 48.dp,
    val touchTargetSM: Dp = 40.dp,
)

// ==================== Compact Small (Small phones) ====================
val CompactSmallDimens = Dimen(
    // Spacing
    spaceXXS = 1.dp,
    spaceXS = 2.dp,
    spaceSM = 4.dp,
    spaceMD = 8.dp,
    spaceLG = 12.dp,
    spaceXL = 16.dp,
    spaceXXL = 24.dp,
    spaceXXXL = 32.dp,
    spaceHuge = 48.dp,

    // Padding
    paddingXS = 2.dp,
    paddingSM = 4.dp,
    paddingMD = 8.dp,
    paddingLG = 12.dp,
    paddingXL = 16.dp,
    paddingXXL = 20.dp,
    paddingScreen = 12.dp,

    // Icon sizes
    iconXXS = 10.dp,
    iconXS = 14.dp,
    iconSM = 18.dp,
    iconMD = 20.dp,
    iconLG = 28.dp,
    iconXL = 36.dp,
    iconXXL = 44.dp,
    iconHuge = 56.dp,
    iconGiant = 80.dp,

    // Logo sizes
    logoSM = 28.dp,
    logoMD = 40.dp,
    logoLG = 56.dp,
    logoXL = 80.dp,
    logoXXL = 112.dp,

    // Button heights
    buttonHeightXS = 24.dp,
    buttonHeightSM = 32.dp,
    buttonHeightMD = 40.dp,
    buttonHeightLG = 46.dp,
    buttonHeightXL = 52.dp,

    // Button widths
    buttonWidthSM = 64.dp,
    buttonWidthMD = 100.dp,
    buttonWidthLG = 140.dp,
    buttonWidthXL = 180.dp,

    // FAB sizes
    fabSizeSM = 36.dp,
    fabSizeMD = 48.dp,
    fabSizeLG = 64.dp,

    // Corner radius
    cornerXS = 3.dp,
    cornerSM = 6.dp,
    cornerMD = 10.dp,
    cornerLG = 14.dp,
    cornerXL = 20.dp,
    cornerXXL = 28.dp,

    // Avatar sizes
    avatarXS = 20.dp,
    avatarSM = 28.dp,
    avatarMD = 36.dp,
    avatarLG = 48.dp,
    avatarXL = 64.dp,
    avatarXXL = 80.dp,

    // Input fields
    inputHeight = 48.dp,
    inputHeightSM = 40.dp,
    inputHeightLG = 56.dp,
    inputMinWidth = 160.dp,

    // Bottom bar & App bar
    topAppBarHeight = 48.dp,
    topAppBarHeightLarge = 56.dp,
    bottomBarHeight = 64.dp,
    bottomBarItemSize = 48.dp,

    // Image sizes
    thumbnailSM = 40.dp,
    thumbnailMD = 64.dp,
    thumbnailLG = 100.dp,
    imageBannerHeight = 160.dp,
    imageCardHeight = 120.dp,

    // Chip & Badge
    chipHeight = 28.dp,
    chipHeightSM = 20.dp,
    badgeSize = 18.dp,
    badgeSizeSM = 14.dp,

    // Dialog
    dialogMinWidth = 240.dp,
    dialogMaxWidth = 320.dp,
    dialogPadding = 16.dp,

    // Touch targets
    touchTargetMin = 44.dp,
    touchTargetSM = 36.dp,
)

// ==================== Compact Medium (Normal phones) ====================
val CompactMediumDimens = Dimen(
    // Spacing
    spaceXXS = 2.dp,
    spaceXS = 4.dp,
    spaceSM = 6.dp,
    spaceMD = 10.dp,
    spaceLG = 14.dp,
    spaceXL = 20.dp,
    spaceXXL = 28.dp,
    spaceXXXL = 40.dp,
    spaceHuge = 56.dp,

    // Padding
    paddingXS = 4.dp,
    paddingSM = 6.dp,
    paddingMD = 10.dp,
    paddingLG = 14.dp,
    paddingXL = 18.dp,
    paddingXXL = 22.dp,
    paddingScreen = 14.dp,

    // Icon sizes
    iconXXS = 11.dp,
    iconXS = 15.dp,
    iconSM = 19.dp,
    iconMD = 22.dp,
    iconLG = 30.dp,
    iconXL = 38.dp,
    iconXXL = 46.dp,
    iconHuge = 60.dp,
    iconGiant = 88.dp,

    // Logo sizes
    logoSM = 30.dp,
    logoMD = 44.dp,
    logoLG = 60.dp,
    logoXL = 88.dp,
    logoXXL = 120.dp,

    // Button heights
    buttonHeightXS = 26.dp,
    buttonHeightSM = 34.dp,
    buttonHeightMD = 42.dp,
    buttonHeightLG = 50.dp,
    buttonHeightXL = 56.dp,

    // Button widths
    buttonWidthSM = 72.dp,
    buttonWidthMD = 110.dp,
    buttonWidthLG = 150.dp,
    buttonWidthXL = 190.dp,

    // FAB sizes
    fabSizeSM = 38.dp,
    fabSizeMD = 52.dp,
    fabSizeLG = 68.dp,

    // Corner radius
    cornerXS = 4.dp,
    cornerSM = 7.dp,
    cornerMD = 11.dp,
    cornerLG = 15.dp,
    cornerXL = 22.dp,
    cornerXXL = 30.dp,

    // Avatar sizes
    avatarXS = 22.dp,
    avatarSM = 30.dp,
    avatarMD = 38.dp,
    avatarLG = 52.dp,
    avatarXL = 68.dp,
    avatarXXL = 88.dp,

    // Input fields
    inputHeight = 52.dp,
    inputHeightSM = 42.dp,
    inputHeightLG = 60.dp,
    inputMinWidth = 180.dp,

    // Bottom bar & App bar
    topAppBarHeight = 52.dp,
    topAppBarHeightLarge = 60.dp,
    bottomBarHeight = 72.dp,
    bottomBarItemSize = 52.dp,

    // Image sizes
    thumbnailSM = 44.dp,
    thumbnailMD = 72.dp,
    thumbnailLG = 110.dp,
    imageBannerHeight = 180.dp,
    imageCardHeight = 140.dp,

    // Chip & Badge
    chipHeight = 30.dp,
    chipHeightSM = 22.dp,
    badgeSize = 19.dp,
    badgeSizeSM = 15.dp,

    // Dialog
    dialogMinWidth = 260.dp,
    dialogMaxWidth = 400.dp,
    dialogPadding = 20.dp,

    // Touch targets
    touchTargetMin = 46.dp,
    touchTargetSM = 38.dp,
)

// ==================== Compact (Large phones) ====================
val CompactDimens = Dimen(
    // Default values are already set in Dimen data class
)

// ==================== Medium (Small tablets, Foldables) ====================
val MediumDimens = Dimen(
    // Spacing
    spaceXXS = 2.dp,
    spaceXS = 4.dp,
    spaceSM = 10.dp,
    spaceMD = 14.dp,
    spaceLG = 20.dp,
    spaceXL = 28.dp,
    spaceXXL = 40.dp,
    spaceXXXL = 56.dp,
    spaceHuge = 72.dp,

    // Padding
    paddingXS = 6.dp,
    paddingSM = 10.dp,
    paddingMD = 14.dp,
    paddingLG = 20.dp,
    paddingXL = 24.dp,
    paddingXXL = 28.dp,
    paddingScreen = 20.dp,

    // Icon sizes
    iconXXS = 14.dp,
    iconXS = 18.dp,
    iconSM = 22.dp,
    iconMD = 28.dp,
    iconLG = 36.dp,
    iconXL = 44.dp,
    iconXXL = 56.dp,
    iconHuge = 72.dp,
    iconGiant = 112.dp,

    // Logo sizes
    logoSM = 36.dp,
    logoMD = 56.dp,
    logoLG = 72.dp,
    logoXL = 112.dp,
    logoXXL = 144.dp,

    // Button heights
    buttonHeightXS = 32.dp,
    buttonHeightSM = 40.dp,
    buttonHeightMD = 48.dp,
    buttonHeightLG = 56.dp,
    buttonHeightXL = 64.dp,

    // Button widths
    buttonWidthSM = 96.dp,
    buttonWidthMD = 140.dp,
    buttonWidthLG = 180.dp,
    buttonWidthXL = 220.dp,

    // FAB sizes
    fabSizeSM = 44.dp,
    fabSizeMD = 60.dp,
    fabSizeLG = 80.dp,

    // Corner radius
    cornerXS = 4.dp,
    cornerSM = 10.dp,
    cornerMD = 14.dp,
    cornerLG = 20.dp,
    cornerXL = 28.dp,
    cornerXXL = 36.dp,

    // Avatar sizes
    avatarXS = 28.dp,
    avatarSM = 36.dp,
    avatarMD = 48.dp,
    avatarLG = 64.dp,
    avatarXL = 80.dp,
    avatarXXL = 112.dp,

    // Input fields
    inputHeight = 60.dp,
    inputHeightSM = 48.dp,
    inputHeightLG = 72.dp,
    inputMinWidth = 240.dp,

    // Bottom bar & App bar
    topAppBarHeight = 60.dp,
    topAppBarHeightLarge = 72.dp,
    bottomBarHeight = 88.dp,
    bottomBarItemSize = 64.dp,

    // Image sizes
    thumbnailSM = 56.dp,
    thumbnailMD = 96.dp,
    thumbnailLG = 140.dp,
    imageBannerHeight = 240.dp,
    imageCardHeight = 180.dp,

    // Chip & Badge
    chipHeight = 36.dp,
    chipHeightSM = 28.dp,
    badgeSize = 22.dp,
    badgeSizeSM = 18.dp,

    // Dialog
    dialogMinWidth = 320.dp,
    dialogMaxWidth = 520.dp,
    dialogPadding = 28.dp,

    // Touch targets
    touchTargetMin = 52.dp,
    touchTargetSM = 44.dp,
)

// ==================== Expanded (Tablets, Desktop) ====================
val ExpandedDimens = Dimen(
    // Spacing
    spaceXXS = 3.dp,
    spaceXS = 6.dp,
    spaceSM = 12.dp,
    spaceMD = 18.dp,
    spaceLG = 24.dp,
    spaceXL = 36.dp,
    spaceXXL = 48.dp,
    spaceXXXL = 64.dp,
    spaceHuge = 96.dp,

    // Padding
    paddingXS = 8.dp,
    paddingSM = 12.dp,
    paddingMD = 18.dp,
    paddingLG = 24.dp,
    paddingXL = 32.dp,
    paddingXXL = 40.dp,
    paddingScreen = 32.dp,

    // Icon sizes
    iconXXS = 16.dp,
    iconXS = 20.dp,
    iconSM = 26.dp,
    iconMD = 32.dp,
    iconLG = 44.dp,
    iconXL = 52.dp,
    iconXXL = 64.dp,
    iconHuge = 88.dp,
    iconGiant = 128.dp,

    // Logo sizes
    logoSM = 44.dp,
    logoMD = 64.dp,
    logoLG = 88.dp,
    logoXL = 128.dp,
    logoXXL = 176.dp,

    // Button heights
    buttonHeightXS = 36.dp,
    buttonHeightSM = 44.dp,
    buttonHeightMD = 56.dp,
    buttonHeightLG = 64.dp,
    buttonHeightXL = 72.dp,

    // Button widths
    buttonWidthSM = 112.dp,
    buttonWidthMD = 160.dp,
    buttonWidthLG = 200.dp,
    buttonWidthXL = 260.dp,

    // FAB sizes
    fabSizeSM = 52.dp,
    fabSizeMD = 72.dp,
    fabSizeLG = 96.dp,

    // Corner radius
    cornerXS = 6.dp,
    cornerSM = 12.dp,
    cornerMD = 18.dp,
    cornerLG = 24.dp,
    cornerXL = 32.dp,
    cornerXXL = 44.dp,

    // Avatar sizes
    avatarXS = 32.dp,
    avatarSM = 44.dp,
    avatarMD = 56.dp,
    avatarLG = 72.dp,
    avatarXL = 96.dp,
    avatarXXL = 128.dp,

    // Input fields
    inputHeight = 64.dp,
    inputHeightSM = 52.dp,
    inputHeightLG = 76.dp,
    inputMinWidth = 280.dp,

    // Bottom bar & App bar
    topAppBarHeight = 64.dp,
    topAppBarHeightLarge = 80.dp,
    bottomBarHeight = 96.dp,
    bottomBarItemSize = 72.dp,

    // Image sizes
    thumbnailSM = 64.dp,
    thumbnailMD = 112.dp,
    thumbnailLG = 160.dp,
    imageBannerHeight = 280.dp,
    imageCardHeight = 220.dp,

    // Chip & Badge
    chipHeight = 40.dp,
    chipHeightSM = 32.dp,
    badgeSize = 24.dp,
    badgeSizeSM = 20.dp,

    // Dialog
    dialogMinWidth = 360.dp,
    dialogMaxWidth = 600.dp,
    dialogPadding = 32.dp,

    // Touch targets
    touchTargetMin = 56.dp,
    touchTargetSM = 48.dp,
)