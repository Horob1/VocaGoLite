package com.horob1.vocagolite.presentation.screen.onboarding.components

import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.outlined.Contrast
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.horob1.vocagolite.R
import com.horob1.vocagolite.domain.model.AppTheme
import com.horob1.vocagolite.presentation.ui.theme.VocaGoLiteTheme
import com.horob1.vocagolite.presentation.ui.theme.dimens
import kotlin.math.absoluteValue

/**
 * Theme option data class
 */
data class ThemeOption(
    val theme: AppTheme,
    val icon: ImageVector,
    @StringRes val labelRes: Int
)

/**
 * Choose Theme page with animations
 */
@Composable
fun ChooseThemePage(
    currentTheme: AppTheme,
    onThemeSelected: (AppTheme) -> Unit,
    pageOffset: Float,
    isLandscape: Boolean,
    isCurrentPage: Boolean
) {
    val dimens = MaterialTheme.dimens
    val themes = remember {
        listOf(
            ThemeOption(AppTheme.SystemTheme, Icons.Outlined.Contrast, R.string.theme_system),
            ThemeOption(AppTheme.LightTheme, Icons.Default.LightMode, R.string.theme_light),
            ThemeOption(AppTheme.DarkTheme, Icons.Default.DarkMode, R.string.theme_dark)
        )
    }

    // Animation values
    val imageScale = remember { Animatable(0.8f) }
    val contentAlpha = remember { Animatable(0f) }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            imageScale.animateTo(
                1f,
                spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }

    LaunchedEffect(isCurrentPage) {
        if (isCurrentPage) {
            kotlinx.coroutines.delay(100)
            contentAlpha.animateTo(1f, spring(stiffness = Spring.StiffnessLow))
        }
    }

    val parallaxOffset = (pageOffset * 80).toInt()
    val pageAlpha = 1f - (pageOffset.absoluteValue * 0.4f).coerceIn(0f, 0.4f)

    if (isLandscape) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimens.paddingXXL, vertical = dimens.paddingSM)
                .alpha(pageAlpha),
            horizontalArrangement = Arrangement.spacedBy(dimens.spaceXL),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left side - Image with Title overlay
            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(0.85f)
                    .offset { IntOffset(-parallaxOffset / 2, 0) }
                    .scale(if (isCurrentPage) imageScale.value else 0.9f)
                    .clip(RoundedCornerShape(dimens.cornerXL))
            ) {
                ThemeImageCard(modifier = Modifier.fillMaxSize())

                // Title overlay on image with matching rounded corners
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .clip(
                            RoundedCornerShape(
                                bottomStart = dimens.cornerXL,
                                bottomEnd = dimens.cornerXL
                            )
                        )
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
                                )
                            )
                        )
                        .padding(dimens.paddingLG)
                ) {
                    Text(
                        text = stringResource(R.string.onboarding_title_5),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // Right side - Only buttons with scroll
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .verticalScroll(rememberScrollState())
                    .alpha(if (isCurrentPage) contentAlpha.value else 0.7f),
                verticalArrangement = Arrangement.spacedBy(dimens.spaceMD)
            ) {
                themes.forEach { themeOption ->
                    ThemeOptionCard(
                        themeOption = themeOption,
                        isSelected = themeOption.theme == currentTheme,
                        onClick = { onThemeSelected(themeOption.theme) }
                    )
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimens.paddingScreen)
                .padding(top = dimens.spaceLG)
                .alpha(pageAlpha),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top - Image Card
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(0.35f)
                    .offset { IntOffset(0, -parallaxOffset / 3) }
                    .scale(if (isCurrentPage) imageScale.value else 0.9f)
            ) {
                ThemeImageCard(modifier = Modifier.fillMaxSize())
            }

            Spacer(modifier = Modifier.height(dimens.spaceXL))

            Text(
                text = stringResource(R.string.onboarding_title_5),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.alpha(if (isCurrentPage) contentAlpha.value else 0.7f)
            )

            Spacer(modifier = Modifier.height(dimens.spaceLG))

            Column(
                verticalArrangement = Arrangement.spacedBy(dimens.spaceMD),
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(if (isCurrentPage) contentAlpha.value else 0.7f)
            ) {
                themes.forEach { themeOption ->
                    ThemeOptionCard(
                        themeOption = themeOption,
                        isSelected = themeOption.theme == currentTheme,
                        onClick = { onThemeSelected(themeOption.theme) }
                    )
                }
            }
        }
    }
}

/**
 * Theme image card with gradient
 */
@Composable
private fun ThemeImageCard(modifier: Modifier = Modifier) {
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
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Gradient overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                                MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)
                            )
                        )
                    )
            )
        }
    }
}

/**
 * Theme option card
 */
@Composable
fun ThemeOptionCard(
    themeOption: ThemeOption,
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

    val iconColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
        animationSpec = tween(200),
        label = "iconColor"
    )

    val iconBgColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
        else MaterialTheme.colorScheme.surfaceVariant,
        animationSpec = tween(200),
        label = "iconBgColor"
    )

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
                // Icon background
                Box(
                    modifier = Modifier
                        .size(dimens.iconXL)
                        .background(iconBgColor, RoundedCornerShape(dimens.cornerSM)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = themeOption.icon,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(dimens.iconMD)
                    )
                }

                Text(
                    text = stringResource(themeOption.labelRes),
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
private fun ThemeOptionCardSelectedPreview() {
    VocaGoLiteTheme {
        ThemeOptionCard(
            themeOption = ThemeOption(
                AppTheme.LightTheme,
                Icons.Default.LightMode,
                R.string.theme_light
            ),
            isSelected = true,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ThemeOptionCardUnselectedPreview() {
    VocaGoLiteTheme {
        ThemeOptionCard(
            themeOption = ThemeOption(
                AppTheme.DarkTheme,
                Icons.Default.DarkMode,
                R.string.theme_dark
            ),
            isSelected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
private fun ChooseThemePagePreview() {
    VocaGoLiteTheme {
        ChooseThemePage(
            currentTheme = AppTheme.LightTheme,
            onThemeSelected = {},
            pageOffset = 0f,
            isLandscape = false,
            isCurrentPage = true
        )
    }
}
