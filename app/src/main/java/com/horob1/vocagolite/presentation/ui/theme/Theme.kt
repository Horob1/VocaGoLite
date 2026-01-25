package com.horob1.vocagolite.presentation.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.horob1.vocagolite.domain.model.AppTheme
import com.horob1.vocagolite.presentation.MainActivity

@Suppress("ParamsComparedByRef")
@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun VocaGoLiteTheme(
    appTheme: AppTheme = AppTheme.SystemTheme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    activity: Activity = LocalContext.current as MainActivity,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val isDarkTheme = when (appTheme) {
        AppTheme.LightTheme -> false
        AppTheme.DarkTheme -> true
        else -> darkTheme
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        isDarkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val appColors = if (isDarkTheme) DarkAppColors else LightAppColors


    val window = calculateWindowSizeClass(activity = activity)
    val config = LocalConfiguration.current

    var typography = CompactTypography
    var appDimens = CompactDimens

    when (window.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            if (config.screenWidthDp <= 360) {
                appDimens = CompactSmallDimens
                typography = CompactSmallTypography
            } else if (config.screenWidthDp < 599) {
                appDimens = CompactMediumDimens
                typography = CompactMediumTypography
            } else {
                appDimens = CompactDimens
                typography = CompactTypography
            }
        }

        WindowWidthSizeClass.Medium -> {
            appDimens = MediumDimens
            typography = MediumTypography
        }

        WindowWidthSizeClass.Expanded -> {
            appDimens = ExpandedDimens
            typography = ExpandedTypography
        }

        else -> {
            appDimens = ExpandedDimens
            typography = ExpandedTypography
        }
    }

    ProvideAppUtils(appDimens = appDimens, appColors = appColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}


@Composable
fun ProvideAppUtils(
    appDimens: Dimen,
    appColors: AppColors,
    content: @Composable () -> Unit,
) {
    val rememberedDimens = remember { appDimens }
    val rememberedColors = remember { appColors }
    CompositionLocalProvider(
        LocalAppDimens provides rememberedDimens,
        LocalAppColors provides rememberedColors
    ) {
        content()
    }
}

val LocalAppDimens = compositionLocalOf {
    CompactDimens
}

val LocalAppColors = compositionLocalOf {
    LightAppColors
}

val ScreenOrientation
    @Composable
    get() = LocalConfiguration.current.orientation

val MaterialTheme.dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalAppDimens.current

val MaterialTheme.appColors
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current
