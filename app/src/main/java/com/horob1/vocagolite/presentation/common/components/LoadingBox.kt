package com.horob1.vocagolite.presentation.common.components

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.horob1.vocagolite.R
import com.horob1.vocagolite.presentation.ui.theme.dimens

/**
 * A reusable loading overlay with animated GIF and progress indicator.
 *
 * @param modifier Modifier for the container
 * @param imageSize Size of the loading image in dp
 * @param showBlurBackground Whether to show blurred background overlay
 * @param backgroundColor Background color with alpha
 * @param progressStrokeWidth Stroke width of the circular progress indicator
 */
@Preview
@Composable
fun LoadingBox(
    modifier: Modifier = Modifier,
    imageSize: Dp = 160.dp,
    showBlurBackground: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.background.copy(alpha = 0.7f),
    progressStrokeWidth: Dp = 6.dp
) {
    val context = LocalContext.current
    val dimens = MaterialTheme.dimens
    val scale = remember { Animatable(0f) }
    val primaryColor = MaterialTheme.colorScheme.primary
    val bgColor = MaterialTheme.colorScheme.background

    LaunchedEffect(Unit) {
        scale.animateTo(1f, tween(400))
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Background overlay with optional blur and gradient
        if (showBlurBackground) {
            val gradientBrush = Brush.radialGradient(
                colors = listOf(
                    primaryColor.copy(alpha = 0.15f),
                    bgColor.copy(alpha = 0.85f),
                    backgroundColor
                )
            )

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .graphicsLayer {
                            renderEffect = RenderEffect
                                .createBlurEffect(8f, 8f, Shader.TileMode.CLAMP)
                                .asComposeRenderEffect()
                        }
                        .background(gradientBrush)
                )
            } else {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(gradientBrush)
                )
            }
        }

        // Loading content
        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale.value
                    scaleY = scale.value
                    shape = CircleShape
                    clip = true
                }
                .size(imageSize),
            contentAlignment = Alignment.Center
        ) {
            // GIF Image
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(R.drawable.loading)
                    .decoderFactory(GifDecoder.Factory())
                    .size(Size(imageSize.value.toInt(), imageSize.value.toInt()))
                    .build(),
                contentDescription = "Loading...",
                modifier = Modifier
                    .size(imageSize)
                    .clip(CircleShape)
                    .border(
                        width = dimens.borderMedium,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                primaryColor,
                                primaryColor.copy(alpha = 0.6f),
                                primaryColor
                            )
                        ),
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )

            // Progress indicator around the image
            CircularProgressIndicator(
                modifier = Modifier
                    .size(imageSize + progressStrokeWidth * 2)
                    .align(Alignment.Center),
                strokeWidth = progressStrokeWidth,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

/**
 * A simple loading indicator without background overlay.
 * Useful for inline loading states.
 */
@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    strokeWidth: Dp = 4.dp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(size),
            strokeWidth = strokeWidth,
            color = color
        )
    }
}
