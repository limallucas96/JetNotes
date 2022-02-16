package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lls.jetnotes.ui.theme.JetNotesTheme
import entities.NotesColor

@ExperimentalMaterialApi
@Composable
@Preview
fun BaseDialogComposePreview() {
    JetNotesTheme {
        BaseDialogCompose(
            title = "Title",
            body = "Body",
            confirmText = "ConfirmText",
            dismissText = "DismissText",
            onConfirm = {},
            onDismiss = {}
        )
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun BaseDialogComposePreviewDark() {
    JetNotesTheme(darkTheme = true) {
        BaseDialogCompose(
            title = "Title",
            body = "Body",
            confirmText = "ConfirmText",
            dismissText = "DismissText",
            onConfirm = {},
            onDismiss = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterialApi
@Composable
fun BaseDialogCompose(
    title: String,
    body: String,
    confirmText: String,
    dismissText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {

    AlertDialog(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        backgroundColor = MaterialTheme.colors.background,
        onDismissRequest = { onDismiss.invoke() },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start
            )
        },
        text = {
            Text(
                text = body,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Start
            )
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = confirmText.uppercase(),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onConfirm.invoke() }
                )
                Text(
                    text = dismissText.uppercase(),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onDismiss.invoke() }
                )
            }
        }
    )
}