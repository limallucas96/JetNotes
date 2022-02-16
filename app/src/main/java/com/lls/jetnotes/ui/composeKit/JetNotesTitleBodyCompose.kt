package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lls.jetnotes.ui.theme.JetNotesTheme

@ExperimentalMaterialApi
@Composable
@Preview
fun TileBodyComposePreview() {
    JetNotesTheme {
        TitleBodyCompose(
            title = "title",
            body = "body"
        )
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun TileBodyComposePreviewDark() {
    JetNotesTheme(darkTheme = true) {
        TitleBodyCompose(
            title = "title",
            body = "body"
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun TitleBodyCompose(
    modifier: Modifier = Modifier,
    title: String,
    body: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = body,
            style = MaterialTheme.typography.caption)
    }
}