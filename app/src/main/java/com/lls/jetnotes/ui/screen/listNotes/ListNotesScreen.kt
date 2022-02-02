package com.lls.jetnotes.ui.screen.listNotes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.composeKit.MyApp
import com.lls.jetnotes.ui.composeKit.NotesListCompose
import com.lls.jetnotes.ui.extensions.parse
import com.lls.jetnotes.ui.theme.JetNotesTheme
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.compose.getViewModel

@InternalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun DefaultPreviewListNotesScreen() {
    JetNotesTheme {
        ListNotesScreen {}
    }
}

@OptIn(ExperimentalMaterialApi::class)
@InternalCoroutinesApi
@Composable
fun ListNotesScreen(onCreateNewNote: (id: Int?) -> Unit = {}) {
    val viewModel = getViewModel<ListNotesScreenViewModel>()

    val viewState by viewModel.notesFlow.collectAsState()

    MyApp {
        Scaffold(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { onCreateNewNote.invoke(null) },
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_plus), contentDescription = "")
                }
            },
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.notes),
                    style = MaterialTheme.typography.h5
                )
                NotesListCompose(notes = viewState,
                    onNoteClicked = { onCreateNewNote.invoke(it.id) })
            }
        }
    }
}