package com.horob1.vocagolite.presentation.screen.main

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainBottomBar(
    navController: NavHostController
) {
    val items = rememberSaveable {
        MainBottomBarItem.items
    }

    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination

    rememberCoroutineScope()


    NavigationBar {
        items.forEach { item ->

            val scale = remember { Animatable(1f) }
            val rotation = remember { Animatable(0f) }

            val selected = currentDestination?.route == item.route::class.qualifiedName

            LaunchedEffect(selected) {
                if (selected) {
                    scale.animateTo(
                        targetValue = 1.15f,
                        animationSpec = tween(durationMillis = 200)
                    )
                    rotation.animateTo(
                        targetValue = 360f,
                        animationSpec = tween(durationMillis = 300)
                    )
                    rotation.snapTo(0f) // reset về vị trí cũ
                } else {
                    scale.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(durationMillis = 200)
                    )
                }
            }

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = scale.value
                                scaleY = scale.value
                                rotationZ = rotation.value
                            },
                        tint = if (selected)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onBackground,
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = item.title))
                },
            )
        }
    }
}