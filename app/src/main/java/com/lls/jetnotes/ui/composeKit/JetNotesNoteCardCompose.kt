package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lls.jetnotes.ui.extensions.parse
import com.lls.jetnotes.ui.theme.JetNotesTheme
import entities.Notes

@ExperimentalMaterialApi
@Preview
@Composable
fun NoteCardComposePreview() {
    JetNotesTheme {
        NoteCardCompose(Notes(noteText = "")) {}
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun NoteCardComposePreviewDark() {
    JetNotesTheme(darkTheme = true) {
        NoteCardCompose(Notes(noteText = "")) {}
    }
}

@ExperimentalMaterialApi
@Composable
fun NoteCardCompose(
    note: Notes, onNoteClicked: () -> Unit
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
            backgroundColor = Color.parse(note.noteColor)
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
                        text = note.noteText,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface,
                    )

                    Text(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        text = note.createDate.orEmpty(),
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onSurface,
                    )
                }
            }
        }
    }
}