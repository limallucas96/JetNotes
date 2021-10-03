package com.example.jetnotes.ui.composeKit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnotes.ui.theme.JetNotesTheme

@Preview(showBackground = true)
@Composable
fun NotesListComposePreview() {
    JetNotesTheme {
        NotesListCompose(listOf()) {}
    }
}

@Composable
fun NotesListCompose(notes: List<String>, onNoteClicked: () -> Unit) {
    if(notes.isEmpty()) {
        EmptyStateCompose()
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(notes, key = { it }) { note ->
                NoteCardCompose(note = note) { onNoteClicked.invoke() }
            }
        }
    }
}