package com.example.jetnotes.ui.screen.createNote

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.jetnotes.ui.composeKit.*
import com.example.jetnotes.ui.theme.JetNotesTheme
import org.koin.androidx.compose.getViewModel

@Preview(showBackground = true)
@Composable
fun DefaultPreviewCreateNoteScreen() {
    JetNotesTheme {
        CreateNoteScreen(NavController(LocalContext.current))
    }
}

@Composable
fun CreateNoteScreen(navController: NavController) {

    val viewModel = getViewModel<CreateNoteScreenViewModel>()

    val viewModelState by viewModel.notesTextFlow.collectAsState()

    val textState: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue()) }

    navController.previousBackStackEntry?.arguments?.getInt("NOTE_ID")?.let { noteId ->
        viewModel.getNoteById(noteId)
        textState.value = TextFieldValue(viewModelState)
    }

    MyApp {
        Column {
            AppToolbarCompose(
                secondaryAction = {
                    viewModel.saveNoteOrUpdateNote(textState.value.text)
                    navController.popBackStack()
                }
            )
            NewNoteTextField(textState)
        }
    }
}