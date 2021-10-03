package com.example.jetnotes.ui.screen.listNotes

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnotes.ui.composeKit.NotesListCompose
import com.example.jetnotes.ui.composeKit.AppToolbarCompose
import com.example.jetnotes.ui.composeKit.MyApp
import com.example.jetnotes.ui.theme.JetNotesTheme
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.compose.getViewModel
import kotlin.coroutines.coroutineContext

@InternalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun DefaultPreviewListNotesScreen() {
    JetNotesTheme {
        ListNotesScreen {}
    }
}

@InternalCoroutinesApi
@Composable
fun ListNotesScreen(onCreateNewNote: () -> Unit = {}) {
    val context = LocalContext.current
    val viewModel = getViewModel<ListNotesScreenViewModel>()

    val viewState by viewModel.notesFlow.collectAsState()

    MyApp {
        Box(
            Modifier.fillMaxWidth()
        ) {
            Column {
                AppToolbarCompose(primaryAction = { onCreateNewNote.invoke() })
                NotesListCompose(notes = viewState) {
                    Toast.makeText(context, "a", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}