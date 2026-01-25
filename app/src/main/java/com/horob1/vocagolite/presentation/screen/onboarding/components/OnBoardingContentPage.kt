package com.horob1.vocagolite.presentation.screen.onboarding.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
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
    isLandscape: Boolean,
    isCurrentPage: Boolean
) {
    val dimens = MaterialTheme.dimens

    // Animation values
    val imageScale = remember { Animatable(0.8f) }
    val imageAlpha = remember { Animatable(0f) }
    val textOffsetY = remember { Animatable(50f) }
    val textAlpha = remember { Animatable(0f) }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            // Animate image
            imageScale.animateTo(
                targetValue = 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            imageAlpha.animateTo(1f, spring(stiffness = Spring.StiffnessLow))
        }
    }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            // Animate text with delay
            kotlinx.coroutines.delay(150)
            textOffsetY.animateTo(0f, spring(stiffness = Spring.StiffnessLow))
        }
    }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            kotlinx.coroutines.delay(150)
            textAlpha.animateTo(1f, spring(stiffness = Spring.StiffnessLow))
        }
    }

    val parallaxOffset = (pageOffset * 100).toInt()
    val contentAlpha = 1f - (pageOffset.absoluteValue * 0.5f).coerceIn(0f, 0.5f)

    if (isLandscape) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimens.paddingXXL, vertical = dimens.paddingSM)
                .alpha(contentAlpha),
            horizontalArrangement = Arrangement.spacedBy(dimens.spaceXL),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image with parallax and scale animation
            Box(
                modifier = Modifier
                    .weight(0.45f)
                    .fillMaxHeight(0.85f)
                    .offset { IntOffset(-parallaxOffset / 2, 0) }
                    .scale(if (isCurrentPage) imageScale.value else 0.9f)
                    .alpha(if (isCurrentPage) imageAlpha.value else 0.7f)
            ) {
                OnBoardingImageCard(image = pageData.image)
            }

            // Text content with slide animation
            Column(
                modifier = Modifier
                    .weight(0.55f)
                    .verticalScroll(rememberScrollState())
                    .offset { IntOffset(0, if (isCurrentPage) textOffsetY.value.toInt() else 30) }
                    .alpha(if (isCurrentPage) textAlpha.value else 0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimens.paddingScreen)
                .padding(top = dimens.spaceLG)
                .alpha(contentAlpha),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image with parallax and scale animation
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.5f)
                    .offset { IntOffset(0, -parallaxOffset / 3) }
                    .scale(if (isCurrentPage) imageScale.value else 0.9f)
                    .alpha(if (isCurrentPage) imageAlpha.value else 0.7f)
            ) {
                OnBoardingImageCard(image = pageData.image)
            }

            Spacer(modifier = Modifier.height(dimens.spaceXL))

            // Text content with slide animation
            Column(
                modifier = Modifier
                    .offset { IntOffset(0, if (isCurrentPage) textOffsetY.value.toInt() else 30) }
                    .alpha(if (isCurrentPage) textAlpha.value else 0.7f),
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
            isLandscape = false,
            isCurrentPage = true
        )
    }
}

@Preview(showBackground = true, widthDp = 700, heightDp = 400)
@Composable
private fun OnBoardingContentPageLandscapePreview() {
    VocaGoLiteTheme {
        OnBoardingContentPage(
            pageData = OnBoardingPageData.LearnVocabulary,
            pageOffset = 0f,
            isLandscape = true,
            isCurrentPage = true
        )
    }
}
