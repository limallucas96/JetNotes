package com.example.jetnotes.ui.screen.createNote

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnotes.ui.composeKit.*
import com.example.jetnotes.ui.theme.JetNotesTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreviewCreateNoteScreen() {
    JetNotesTheme {
        CreateNoteScreen {}
    }
}

@Composable
fun CreateNoteScreen(onSaveClicked: () -> Unit) {
    MyApp {
        Column {
            AppToolbarCompose(
                secondaryAction = {
                    //TODO: save note
                    onSaveClicked.invoke()
                }
            )
            NewNoteTextField()
        }
    }
}