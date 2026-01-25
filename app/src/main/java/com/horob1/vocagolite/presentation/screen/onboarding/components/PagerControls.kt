package com.horob1.vocagolite.presentation.screen.onboarding.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.horob1.vocagolite.R
import com.horob1.vocagolite.presentation.ui.theme.VocaGoLiteTheme
import com.horob1.vocagolite.presentation.ui.theme.dimens

/**
 * Animated Pager Indicator with pill shape
 */
@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val isSelected = index == currentPage

            val color by animateColorAsState(
                targetValue = if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.outline.copy(alpha = 0.4f),
                animationSpec = tween(250),
                label = "indicatorColor"
            )

            val width by animateDpAsState(
                targetValue = if (isSelected) dimens.spaceXL else dimens.spaceSM,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                ),
                label = "indicatorWidth"
            )

            val height by animateDpAsState(
                targetValue = if (isSelected) dimens.spaceSM else dimens.spaceXS + dimens.spaceXXS,
                animationSpec = spring(stiffness = Spring.StiffnessMedium),
                label = "indicatorHeight"
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = dimens.spaceXS)
                    .width(width)
                    .height(height)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

/**
 * Page Controller with navigation buttons
 * @param showIndicator If true, shows the pager indicator in the center (for landscape mode)
 */
@Composable
fun PageController(
    currentPage: Int,
    pageCount: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onComplete: () -> Unit,
    modifier: Modifier = Modifier,
    showIndicator: Boolean = false
) {
    val dimens = MaterialTheme.dimens
    val isFirstPage = currentPage == 0
    val isLastPage = currentPage == pageCount - 1

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Previous Button with animation
        AnimatedVisibility(
            visible = !isFirstPage,
            enter = fadeIn(tween(200)),
            exit = fadeOut(tween(200))
        ) {
            Button(
                onClick = onPrevious,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                modifier = Modifier
                    .height(dimens.buttonHeightLG)
                    .width(dimens.buttonWidthLG + dimens.spaceLG)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(dimens.iconMD)
                )
                Spacer(modifier = Modifier.width(dimens.spaceXS))
                Text(
                    text = stringResource(R.string.btn_prev),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        // Spacer or Indicator in center
        if (isFirstPage && !showIndicator) {
            Spacer(modifier = Modifier.weight(1f))
        } else if (showIndicator) {
            // Show indicator in center for landscape
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                PagerIndicator(
                    pageCount = pageCount,
                    currentPage = currentPage
                )
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }

        // Next / Complete Button
        Button(
            onClick = if (isLastPage) onComplete else onNext,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .height(dimens.buttonHeightLG)
                .width(dimens.buttonWidthLG + dimens.spaceLG)
        ) {
            if (isLastPage) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(dimens.iconMD)
                )
                Spacer(modifier = Modifier.width(dimens.spaceXS))
            }
            Text(
                text = stringResource(
                    if (isLastPage) R.string.btn_get_started
                    else R.string.btn_next
                ),
                style = MaterialTheme.typography.labelLarge
            )
            if (!isLastPage) {
                Spacer(modifier = Modifier.width(dimens.spaceXS))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(dimens.iconMD)
                )
            }
        }
    }
}

// ==================== Previews ====================

@Preview(showBackground = true)
@Composable
private fun PagerIndicatorPreview() {
    VocaGoLiteTheme {
        PagerIndicator(
            pageCount = 5,
            currentPage = 2
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PageControllerFirstPagePreview() {
    VocaGoLiteTheme {
        PageController(
            currentPage = 0,
            pageCount = 5,
            onPrevious = {},
            onNext = {},
            onComplete = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PageControllerMiddlePagePreview() {
    VocaGoLiteTheme {
        PageController(
            currentPage = 2,
            pageCount = 5,
            onPrevious = {},
            onNext = {},
            onComplete = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PageControllerLastPagePreview() {
    VocaGoLiteTheme {
        PageController(
            currentPage = 4,
            pageCount = 5,
            onPrevious = {},
            onNext = {},
            onComplete = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
private fun PageControllerLandscapeWithIndicatorPreview() {
    VocaGoLiteTheme {
        PageController(
            currentPage = 2,
            pageCount = 5,
            onPrevious = {},
            onNext = {},
            onComplete = {},
            showIndicator = true
        )
    }
}

