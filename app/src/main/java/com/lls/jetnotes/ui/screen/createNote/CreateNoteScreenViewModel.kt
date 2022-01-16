package com.lls.jetnotes.ui.screen.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import entities.Notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import usecases.notes.NotesUseCaseContract

class CreateNoteScreenViewModel(private val notesUseCase: NotesUseCaseContract) : ViewModel() {

    private var _notesTextFlow = MutableStateFlow(String())
    private var _noteId: Int? = null

    val notesTextFlow: StateFlow<String>
        get() = _notesTextFlow


    fun saveNoteOrUpdateNote(noteText: String) {
        if (noteText.trim().isNotEmpty()) {
            viewModelScope.launch {
                val notes = _noteId?.let {
                    Notes(id = it, noteText = noteText)
                } ?: Notes(noteText = noteText)
                notesUseCase.insertNote(notes)
            }
        }
    }

    fun getNoteById(noteId: Int) {
        _noteId = noteId
        viewModelScope.launch {
            notesUseCase.getNoteById(noteId).collect { notes ->
                notes.firstOrNull()?.noteText?.let { noteText ->
                    _notesTextFlow.value = noteText
                }
            }
        }
    }

}