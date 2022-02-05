package com.lls.jetnotes.ui.screen.listNotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lls.jetnotes.entities.FlowWrapper
import entities.Notes
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import usecases.notes.NotesUseCaseContract

@InternalCoroutinesApi
class ListNotesScreenViewModel(private val notesUseCase: NotesUseCaseContract) : ViewModel() {

    private val _notesFlow: MutableStateFlow<FlowWrapper<List<Notes>>> = MutableStateFlow(FlowWrapper.Loading)

    val notesFlow get() = _notesFlow.asStateFlow()

    init {
        viewModelScope.launch {
            getNotes().collect { collectedNotes ->
                _notesFlow.value = FlowWrapper.Success(collectedNotes)
            }
        }
    }

    private fun getNotes() = notesUseCase.getAllNotes()

}