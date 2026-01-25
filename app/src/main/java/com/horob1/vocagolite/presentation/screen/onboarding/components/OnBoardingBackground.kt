package com.horob1.vocagolite.presentation.screen.onboarding.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.horob1.vocagolite.presentation.ui.theme.VocaGoLiteTheme

/**
 * Animated background with gradient and floating bubbles
 */
@Composable
fun OnBoardingBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val tertiaryColor = MaterialTheme.colorScheme.tertiary
    val backgroundColor = MaterialTheme.colorScheme.background

    // Infinite animation for bubbles
    val infiniteTransition = rememberInfiniteTransition(label = "bubbles")

    val bubble1Offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 30f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bubble1"
    )

    val bubble2Offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -25f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bubble2"
    )

    val bubble3Offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(
            animation = tween(3500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bubble3"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        backgroundColor,
                        primaryColor.copy(alpha = 0.05f),
                        secondaryColor.copy(alpha = 0.08f),
                        backgroundColor
                    )
                )
            )
    ) {
        // Floating bubbles
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // Bubble 1 - Top right
            drawCircle(
                color = primaryColor.copy(alpha = 0.08f),
                radius = 120f,
                center = Offset(width * 0.85f, height * 0.15f + bubble1Offset)
            )

            // Bubble 2 - Bottom left
            drawCircle(
                color = secondaryColor.copy(alpha = 0.06f),
                radius = 180f,
                center = Offset(width * 0.1f, height * 0.75f + bubble2Offset)
            )

            // Bubble 3 - Center right
            drawCircle(
                color = tertiaryColor.copy(alpha = 0.05f),
                radius = 100f,
                center = Offset(width * 0.9f, height * 0.5f + bubble3Offset)
            )

            // Small bubble - Top left
            drawCircle(
                color = primaryColor.copy(alpha = 0.04f),
                radius = 60f,
                center = Offset(width * 0.15f, height * 0.2f - bubble1Offset * 0.5f)
            )

            // Small bubble - Bottom right
            drawCircle(
                color = secondaryColor.copy(alpha = 0.05f),
                radius = 80f,
                center = Offset(width * 0.8f, height * 0.85f - bubble2Offset * 0.7f)
            )
        }

        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun OnBoardingBackgroundPreview() {
    VocaGoLiteTheme {
        OnBoardingBackground {
            // Empty content for preview
        }
    }
}
