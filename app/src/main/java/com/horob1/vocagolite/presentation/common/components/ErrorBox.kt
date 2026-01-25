package com.horob1.vocagolite.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.horob1.vocagolite.R
import com.horob1.vocagolite.presentation.ui.theme.dimens

/**
 * A reusable error box with image, message and retry button.
 *
 * @param modifier Modifier for the container
 * @param message Error message to display
 * @param title Optional error title
 * @param image Drawable resource for error illustration
 * @param imageSize Size of the error image
 * @param showRetryButton Whether to show retry button
 * @param retryButtonText Text for retry button
 * @param onRetry Callback when retry button is clicked
 * @param showBackground Whether to show background overlay
 * @param backgroundColor Background color
 */
@Composable
fun ErrorBox(
    modifier: Modifier = Modifier,
    message: String,
    title: String? = null,
    @DrawableRes image: Int = R.drawable.error_banner,
    imageSize: Dp? = null,
    showRetryButton: Boolean = true,
    retryButtonText: String = stringResource(R.string.btn_retry),
    onRetry: (() -> Unit)? = null,
    showBackground: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.background.copy(alpha = 0.9f)
) {
    val dimens = MaterialTheme.dimens

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Background overlay
        if (showBackground) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(backgroundColor)
            )
        }

        // Error content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.paddingXXL),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Error image
            Image(
                painter = painterResource(id = image),
                contentDescription = "Error",
                modifier = Modifier
                    .then(
                        if (imageSize != null) Modifier.size(imageSize)
                        else Modifier
                            .fillMaxWidth(0.6f)
                            .height(dimens.imageBannerHeight)
                    )
                    .clip(RoundedCornerShape(dimens.cornerLG)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(dimens.spaceXL))

            // Title
            if (title != null) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(dimens.spaceMD))
            }

            // Message
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

            // Retry button
            if (showRetryButton && onRetry != null) {
                Spacer(modifier = Modifier.height(dimens.spaceXL))

                Button(
                    onClick = onRetry,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.height(dimens.buttonHeightMD)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(dimens.iconSM)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = dimens.spaceXS))
                    Text(text = retryButtonText)
                }
            }
        }
    }
}

/**
 * A compact inline error message.
 * Useful for showing errors within forms or lists.
 */
@Composable
fun ErrorMessage(
    message: String,
    modifier: Modifier = Modifier,
    showIcon: Boolean = true
) {
    val dimens = MaterialTheme.dimens

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.errorContainer,
                RoundedCornerShape(dimens.cornerSM)
            )
            .padding(dimens.paddingMD),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (showIcon) "⚠️ $message" else message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onErrorContainer,
            textAlign = TextAlign.Center
        )
    }
}
