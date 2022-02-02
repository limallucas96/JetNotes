package com.lls.jetnotes.ui.screen.createNote

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lls.jetnotes.ui.theme.JetNotesTheme
import org.koin.androidx.compose.getViewModel
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.composeKit.*
import com.lls.jetnotes.ui.extensions.parse
import entities.NotesColor

@Preview(showBackground = true)
@Composable
fun DefaultPreviewCreateNoteScreen() {
    JetNotesTheme {
        CreateNoteScreen(NavController(LocalContext.current))
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateNoteScreen(navController: NavController) {

    val viewModel = getViewModel<CreateNoteScreenViewModel>()

    val viewModelState by viewModel.notesTextFlow.collectAsState()

    val textState: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue()) }

    var showCustomDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    navController.previousBackStackEntry?.arguments?.getInt("NOTE_ID")?.let { noteId ->
        viewModel.getNoteById(noteId)
        textState.value = TextFieldValue(viewModelState.noteText)
    }

    MyApp {

        if (showCustomDialog) {
            ColorPickerDialogCompose(
                onColorPicked = {
                    viewModel.updateColor(it)
                    showCustomDialog = false
                },
                clearColor = {
                    viewModel.updateColor(NotesColor.DEFAULT.hex)
                    showCustomDialog = false
                },
                onDismiss = { showCustomDialog = false }
            )
        }

        if (showDeleteDialog) {
            BaseDialogCompose(
                title = stringResource(id = R.string.dialog_delete_note_title),
                body = stringResource(id = R.string.dialog_delete_note_body),
                confirmText = stringResource(id = R.string.yes),
                dismissText = stringResource(id = R.string.no_cancel),
                onConfirm = {
                    viewModel.deleteNote()
                    showDeleteDialog = false
                    navController.popBackStack()
                },
                onDismiss = { showDeleteDialog = false }
            )
        }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    ShortCutCompose(
                        icon = R.drawable.ic_chevron_left,
                        onClick = { navController.popBackStack() }
                    )

                    TitleBodyCompose(
                        modifier = Modifier.padding(start = 6.dp),
                        title = viewModel.notesTextFlow.value.createDate.orEmpty(),
                        body = stringResource(id = R.string.character, viewModel.notesTextFlow.value.noteSize)
                    )
                }
                Row(
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    ShortCutCompose(
                        icon = R.drawable.ic_color_picker,
                        tintColor = Color.parse(viewModel.notesTextFlow.value.noteColor),
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = { showCustomDialog = true }
                    )
                    ShortCutCompose(
                        icon = R.drawable.ic_delete_outline,
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = { showDeleteDialog = true }
                    )
                    ShortCutCompose(
                        icon = R.drawable.ic_check,
                        onClick = {
                            viewModel.saveNoteOrUpdateNote(textState.value.text)
                            navController.popBackStack()
                        }
                    )
                }
            }

            NewNoteTextField(
                modifier = Modifier.padding(top = 16.dp),
                textState = textState
            )
        }
    }
}