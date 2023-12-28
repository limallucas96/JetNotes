package com.lls.jetnotes.ui.screen.createNote

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lls.jetnotes.ui.theme.JetNotesTheme
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.composeKit.*
import entities.NotesColor

@Preview(showBackground = true)
@Composable
fun DefaultPreviewCreateNoteScreen() {
    JetNotesTheme {
        CreateNoteScreen(NavController(LocalContext.current), 1)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateNoteScreen(navController: NavController, noteId: Int? = 1, viewModel: CreateNoteScreenViewModel = hiltViewModel()) {

    val viewModelState by viewModel.notesTextFlow.collectAsState()

    val textState: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue()) }

    var showCustomDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    noteId?.let { safeNoteId ->
        viewModel.getNoteById(safeNoteId)
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
                        body = stringResource(id = R.string.character, textState.value.text.length)
                    )
                }
                Row(
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    ShortCutCompose(
                        icon = R.drawable.ic_color_picker,
                        tintColor = viewModel.notesTextFlow.value.noteColor,
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