package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lls.jetnotes.ui.extensions.parse
import com.lls.jetnotes.ui.theme.JetNotesTheme
import de.charlex.compose.RevealDirection
import de.charlex.compose.RevealSwipe

@ExperimentalMaterialApi
@Preview
@Composable
fun NoteCardComposePreview() {
    JetNotesTheme {
        NoteCardCompose("Note Preview", {}, {})
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun NoteCardComposePreviewDark() {
    JetNotesTheme(darkTheme = true) {
        NoteCardCompose("Note Preview", {}, {})
    }
}

@ExperimentalMaterialApi
@Composable
fun NoteCardCompose(
    note: String, onNoteClicked: () -> Unit,
    onDeleteClicked: () -> Unit
) {
    Surface(
        Modifier.absolutePadding(top = 8.dp, bottom = 4.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable { onNoteClicked.invoke() },
            shape = MaterialTheme.shapes.medium,
            elevation = 5.dp,
            backgroundColor = Color.parse("#D14960")
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier
                            .absolutePadding(bottom = 32.dp)
                            .align(Alignment.TopStart),
                        text = note,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface,
                    )

                    Text(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        text = "02/08/2020",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onSurface,
                    )
                }
            }
        }
    }
}