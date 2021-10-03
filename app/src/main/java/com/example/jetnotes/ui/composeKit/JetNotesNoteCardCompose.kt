package com.example.jetnotes.ui.composeKit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnotes.ui.theme.JetNotesTheme

@Preview(showBackground = true)
@Composable
fun NoteCardComposePreview() {
    JetNotesTheme {
        NoteCardCompose("Note Preview", {})
    }
}

@Composable
fun NoteCardCompose(note: String, onNoteClicked: () -> Unit) {
    Card(
        modifier =
        Modifier
            .absolutePadding(top = 8.dp, bottom = 4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onNoteClicked.invoke() },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .absolutePadding(bottom = 32.dp)
                        .align(Alignment.TopStart),
                    text = note,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 12.sp
                )

                Text(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    text = "02/08/2020",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 12.sp
                )
            }
        }
    }
}