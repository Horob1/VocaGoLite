package com.horob1.vocagolite.presentation.screen.onboarding.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.horob1.vocagolite.R
import com.horob1.vocagolite.domain.model.AppLanguage
import com.horob1.vocagolite.presentation.ui.theme.VocaGoLiteTheme
import com.horob1.vocagolite.presentation.ui.theme.dimens
import kotlin.math.absoluteValue

/**
 * Choose Language page with animations
 */
@Composable
fun ChooseLanguagePage(
    currentLanguage: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit,
    pageOffset: Float,
    isCurrentPage: Boolean
) {
    val dimens = MaterialTheme.dimens
    val languages = remember {
        listOf(
            AppLanguage.SystemLanguage,
            AppLanguage.English,
            AppLanguage.Vietnamese
        )
    }

    // Simple animation - only fade in, no complex movements
    val contentAlpha = remember { Animatable(0.7f) }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            contentAlpha.animateTo(1f, tween(durationMillis = 200))
        } else {
            contentAlpha.snapTo(0.7f)
        }
    }

    val pageAlpha = 1f - (pageOffset.absoluteValue * 0.4f).coerceIn(0f, 0.4f)

    // Dynamic image based on language with animation
    val languageImage = when (currentLanguage) {
        AppLanguage.English -> R.drawable.capy_uk
        AppLanguage.Vietnamese -> R.drawable.capy_vi
        else -> R.drawable.capy_world
    }

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
        // Top - Image Card (no scale animation, just static display)
        Box(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.35f)
        ) {
            AnimatedLanguageImage(
                languageImage = languageImage,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(dimens.spaceXL))

        Text(
            text = stringResource(R.string.onboarding_title_4),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.graphicsLayer {
                alpha = contentAlpha.value
            }
        )

        Spacer(modifier = Modifier.height(dimens.spaceLG))

        Column(
            verticalArrangement = Arrangement.spacedBy(dimens.spaceMD),
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    alpha = contentAlpha.value
                }
        ) {
            languages.forEach { language ->
                LanguageOptionCard(
                    language = language,
                    isSelected = language == currentLanguage,
                    onClick = { onLanguageSelected(language) }
                )
            }
        }
    }
}

/**
 * Animated language image with crossfade
 */
@Composable
private fun AnimatedLanguageImage(
    languageImage: Int,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Card(
        modifier = modifier
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
        AnimatedContent(
            targetState = languageImage,
            transitionSpec = {
                (fadeIn(tween(300)) + scaleIn(initialScale = 0.92f, animationSpec = tween(300)))
                    .togetherWith(
                        fadeOut(tween(300)) + scaleOut(
                            targetScale = 1.08f,
                            animationSpec = tween(300)
                        )
                    )
            },
            label = "languageImage"
        ) { image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/**
 * Language option card
 */
@Composable
fun LanguageOptionCard(
    language: AppLanguage,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.surface,
        animationSpec = tween(200),
        label = "bgColor"
    )

    val borderColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
        animationSpec = tween(200),
        label = "borderColor"
    )

    val flag = when (language) {
        AppLanguage.English -> "🇬🇧"
        AppLanguage.Vietnamese -> "🇻🇳"
        else -> "🌐"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimens.cornerMD))
            .border(
                width = if (isSelected) dimens.borderMedium else dimens.borderThin,
                color = borderColor,
                shape = RoundedCornerShape(dimens.cornerMD)
            )
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(dimens.cornerMD)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.paddingLG, vertical = dimens.paddingLG),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimens.spaceMD),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Flag icon in box like theme
                Box(
                    modifier = Modifier
                        .size(dimens.iconXL)
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                            else MaterialTheme.colorScheme.surfaceVariant,
                            RoundedCornerShape(dimens.cornerSM)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = flag, style = MaterialTheme.typography.titleLarge)
                }
                Text(
                    text = language.displayName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                )
            }

            // Animated check icon
            androidx.compose.animation.AnimatedVisibility(
                visible = isSelected,
                enter = scaleIn(spring(stiffness = Spring.StiffnessMedium)) + fadeIn(),
                exit = scaleOut() + fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .size(dimens.iconMD)
                        .background(MaterialTheme.colorScheme.primary, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(dimens.iconSM)
                    )
                }
            }
        }
    }
}

// ==================== Previews ====================

@Preview(showBackground = true)
@Composable
private fun LanguageOptionCardSelectedPreview() {
    VocaGoLiteTheme {
        LanguageOptionCard(
            language = AppLanguage.English,
            isSelected = true,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LanguageOptionCardUnselectedPreview() {
    VocaGoLiteTheme {
        LanguageOptionCard(
            language = AppLanguage.Vietnamese,
            isSelected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
private fun ChooseLanguagePagePreview() {
    VocaGoLiteTheme {
        ChooseLanguagePage(
            currentLanguage = AppLanguage.English,
            onLanguageSelected = {},
            pageOffset = 0f,
            isCurrentPage = true
        )
    }
}
