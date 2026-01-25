package com.horob1.vocagolite.presentation.screen.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.horob1.vocagolite.R
import com.horob1.vocagolite.presentation.ui.theme.VocaGoLiteTheme
import com.horob1.vocagolite.presentation.ui.theme.dimens

/**
 * Dialog for confirming language change
 */
@Composable
fun ChangeLanguageDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(dimens.cornerLG),
            tonalElevation = 8.dp,
            modifier = Modifier.wrapContentSize()
        ) {
            Column {
                // Image header
                Image(
                    painter = painterResource(id = R.drawable.screen_may_be_flick),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = dimens.cornerLG,
                                topEnd = dimens.cornerLG
                            )
                        )
                )

                // Content
                Column(
                    modifier = Modifier.padding(dimens.paddingXXL),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.dialog_change_language_title),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(dimens.spaceMD))

                    Text(
                        text = stringResource(R.string.dialog_change_language_message),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(dimens.spaceXL))

                    // Buttons
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(dimens.spaceMD),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(stringResource(R.string.btn_cancel))
                        }

                        Button(
                            onClick = onConfirm,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(stringResource(R.string.btn_continue))
                        }
                    }
                }
            }
        }
    }
}

// ==================== Previews ====================

@Preview(showBackground = true)
@Composable
private fun ChangeLanguageDialogPreview() {
    VocaGoLiteTheme {
        ChangeLanguageDialog(
            onDismiss = {},
            onConfirm = {}
        )
    }
}
