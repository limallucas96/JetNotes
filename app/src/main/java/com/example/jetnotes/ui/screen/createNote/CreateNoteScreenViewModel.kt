package com.example.jetnotes.ui.screen.createNote

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.flowOf

class CreateNoteScreenViewModel : ViewModel() {

    private val noteText = flowOf(String())


}