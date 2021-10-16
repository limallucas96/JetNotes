package com.example.jetnotes.ui.screen.listNotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import entities.Notes
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import usecases.notes.NotesUseCaseContract

@InternalCoroutinesApi
class ListNotesScreenViewModel(private val notesUseCase: NotesUseCaseContract) : ViewModel() {

    private val _notesFlow = MutableStateFlow(listOf<Notes>())

    val notesFlow: StateFlow<List<Notes>>
        get() = _notesFlow

    init {
        viewModelScope.launch {
            getNotes().collect { collectedNotes ->
                _notesFlow.value = collectedNotes
            }
        }
    }

    private fun getNotes() = notesUseCase.getAllNotes()

    fun deleteNote(notesEntity: Notes) {
        viewModelScope.launch {
            notesUseCase.deleteNote(notesEntity)
        }
    }

}