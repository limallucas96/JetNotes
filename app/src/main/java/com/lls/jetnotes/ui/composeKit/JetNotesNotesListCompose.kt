package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lls.jetnotes.ui.theme.JetNotesTheme
import entities.Notes

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun NotesListComposePreview() {
    JetNotesTheme {
        NotesListCompose(listOf()) {}
    }
}

@ExperimentalMaterialApi
@Composable
fun NotesListCompose(
    notes: List<Notes>,
    onNoteClicked: (Notes) -> Unit
) {
    if (notes.isEmpty()) {
        EmptyStateCompose()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(notes, key = { it }) { note ->
                NoteCardCompose(
                    note = note,
                    onNoteClicked = { onNoteClicked.invoke(note) }
                )
            }
        }
    }
}