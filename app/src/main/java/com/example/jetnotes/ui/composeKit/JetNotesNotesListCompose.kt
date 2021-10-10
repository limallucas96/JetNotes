package com.example.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnotes.ui.theme.JetNotesTheme
import local.entities.NotesEntity

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun NotesListComposePreview() {
    JetNotesTheme {
        NotesListCompose(listOf(), {}, {})
    }
}

@ExperimentalMaterialApi
@Composable
fun NotesListCompose(
    notes: List<NotesEntity>,
    onNoteClicked: (NotesEntity) -> Unit,
    onDeleteClicked: (NotesEntity) -> Unit
) {
    if (notes.isEmpty()) {
        EmptyStateCompose()
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(notes, key = { it }) { note ->
                NoteCardCompose(
                    note = note.noteText,
                    onNoteClicked = { onNoteClicked.invoke(note) },
                    onDeleteClicked = { onDeleteClicked.invoke(note) }
                )
            }
        }
    }
}