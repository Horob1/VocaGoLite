package com.horob1.vocagolite.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.horob1.vocagolite.domain.model.AppTheme
import com.horob1.vocagolite.domain.usecase.setting.GetAppThemeUseCase
import com.horob1.vocagolite.domain.usecase.setting.GetFirstTimeLaunchUseCase
import com.horob1.vocagolite.domain.usecase.setting.GetUseDynamicColorUseCase
import com.horob1.vocagolite.presentation.navigation.NavScreen
import com.horob1.vocagolite.presentation.navigation.SetupNavGraph
import com.horob1.vocagolite.presentation.ui.theme.VocaGoLiteTheme
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {
    // State
    private var isReady = false

    // UseCase
    private val getAppThemeUseCase: GetAppThemeUseCase by inject()
    private val getFirstTimeLaunchUseCase: GetFirstTimeLaunchUseCase by inject()
    private val getUseDynamicColorUseCase: GetUseDynamicColorUseCase by inject()


    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { !isReady }

        enableEdgeToEdge()

        setContent {
            VocaGoLiteApp()
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    private fun VocaGoLiteApp() {
        val appTheme by getAppThemeUseCase()
            .collectAsStateWithLifecycle(initialValue = null)

        val useDynamicColor by getUseDynamicColorUseCase()
            .collectAsStateWithLifecycle(initialValue = null)

        val isFirstTimeLaunch by getFirstTimeLaunchUseCase()
            .collectAsStateWithLifecycle(initialValue = null)

        // Chỉ set ready khi TẤT CẢ states đã load (khác null)
        LaunchedEffect(appTheme, useDynamicColor, isFirstTimeLaunch) {
            if (appTheme != null && useDynamicColor != null && isFirstTimeLaunch != null) {
                isReady = true
            }
        }

        // Chỉ render UI khi đã có data
        if (appTheme != null && useDynamicColor != null && isFirstTimeLaunch != null) {
            VocaGoLiteTheme(
                appTheme = appTheme ?: AppTheme.defaultTheme,
                dynamicColor = useDynamicColor ?: false
            ) {
                val startDestination = if (isFirstTimeLaunch == true) {
                    NavScreen.OnBoarding
                } else {
                    NavScreen.Main
                }

                SetupNavGraph(
                    startDestination = startDestination,
                    navController = rememberNavController()
                )
            }
        }
    }
}