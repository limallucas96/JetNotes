package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lls.jetnotes.entities.FlowWrapper
import com.lls.jetnotes.ui.theme.JetNotesTheme
import entities.Notes
import kotlinx.coroutines.flow.flowOf

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun NotesListComposePreview() {
    JetNotesTheme {
        NotesListCompose(FlowWrapper.None) {}
    }
}

@ExperimentalMaterialApi
@Composable
fun NotesListCompose(
    flowOfNotes: FlowWrapper<List<Notes>>,
    onNoteClicked: (Notes) -> Unit
) {

    when (flowOfNotes) {
        is FlowWrapper.Loading -> run { }
        is FlowWrapper.Success -> {
            val notes = flowOfNotes.value
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
        else -> run {}
    }
}