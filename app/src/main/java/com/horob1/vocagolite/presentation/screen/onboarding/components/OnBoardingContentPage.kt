package com.horob1.vocagolite.presentation.screen.onboarding.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.horob1.vocagolite.presentation.screen.onboarding.OnBoardingPageData
import com.horob1.vocagolite.presentation.ui.theme.VocaGoLiteTheme
import com.horob1.vocagolite.presentation.ui.theme.dimens
import kotlin.math.absoluteValue

/**
 * OnBoarding intro page content with animations
 */
@Composable
fun OnBoardingContentPage(
    pageData: OnBoardingPageData,
    pageOffset: Float,
    isCurrentPage: Boolean
) {
    val dimens = MaterialTheme.dimens

    // Simple fade in only, no complex animations
    val fadeAlpha = remember { Animatable(0.7f) }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            fadeAlpha.animateTo(1f, tween(durationMillis = 200))
        } else {
            fadeAlpha.snapTo(0.7f)
        }
    }

    val pageAlpha = 1f - (pageOffset.absoluteValue * 0.5f).coerceIn(0f, 0.5f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimens.paddingScreen)
            .padding(top = dimens.spaceLG)
            .graphicsLayer {
                alpha = pageAlpha
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image (static, no scale/parallax animation)
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.5f)
                .graphicsLayer {
                    alpha = fadeAlpha.value
                }
        ) {
            OnBoardingImageCard(image = pageData.image)
        }

        Spacer(modifier = Modifier.height(dimens.spaceXL))

        // Text content (simple fade only)
        Column(
            modifier = Modifier
                .graphicsLayer {
                    alpha = fadeAlpha.value
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Text(
                    text = stringResource(pageData.title),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(dimens.spaceMD))

                Text(
                    text = stringResource(pageData.description),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = dimens.paddingLG)
                )
            }
        }
}

/**
 * Image card with gradient overlay
 */
@Composable
fun OnBoardingImageCard(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Card(
        modifier = modifier
            .fillMaxSize()
            .shadow(
                elevation = dimens.cardElevationHigh,
                shape = RoundedCornerShape(dimens.cornerXL),
                spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
            ),
        shape = RoundedCornerShape(dimens.cornerXL),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Subtle gradient overlay at bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.background.copy(alpha = 0f),
                                MaterialTheme.colorScheme.background.copy(alpha = 0.3f)
                            )
                        )
                    )
            )
        }
    }
}

// ==================== Previews ====================

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
private fun OnBoardingContentPagePreview() {
    VocaGoLiteTheme {
        OnBoardingContentPage(
            pageData = OnBoardingPageData.Welcome,
            pageOffset = 0f,
            isCurrentPage = true
        )
    }
}
