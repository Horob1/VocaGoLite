package com.horob1.vocagolite.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.horob1.vocagolite.presentation.screen.main.MainBottomBar
import com.horob1.vocagolite.presentation.screen.onboarding.OnBoardingScreen
import com.horob1.vocagolite.presentation.screen.onboarding.OnBoardingViewModel
import org.koin.compose.viewmodel.koinViewModel

@Suppress("ParamsComparedByRef")
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: NavScreen,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn() },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut() },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) + fadeIn() },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) + fadeOut() }
    ) {
        composable<NavScreen.OnBoarding> {
            val viewModel = koinViewModel<OnBoardingViewModel>()
            OnBoardingScreen(
                viewModel = viewModel,
                onCompleteOnBoarding = {
                    navController.navigate(NavScreen.Main)
                }
            )
        }

        composable<NavScreen.Main> {
            SetupMainNavGraph(
                rootNavController = navController
            )
        }

    }

}

@Suppress("ParamsComparedByRef")
@Composable
fun SetupMainNavGraph(
    rootNavController: NavHostController
) {
    val mainNavGraph = rememberNavController()
    Scaffold(
        bottomBar = { MainBottomBar(navController = mainNavGraph) }
    ) { innerPadding ->
        NavHost(
            navController = mainNavGraph,
            startDestination = NavScreen.Home,
            enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn() },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut() },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) + fadeIn() },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) + fadeOut() },
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<NavScreen.Home> {
            }
            composable<NavScreen.Explore> {
            }
            composable<NavScreen.Setting> {
            }
            composable<NavScreen.About> {
            }
        }
    }

}