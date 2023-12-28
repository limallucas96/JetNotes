package com.lls.jetnotes.ui.screen.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import entities.Notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import usecases.notes.NotesUseCaseContract
import javax.inject.Inject

@HiltViewModel
class CreateNoteScreenViewModel @Inject constructor(
    private val notesUseCase: NotesUseCaseContract
) : ViewModel() {

    private var _notesTextFlow = MutableStateFlow(Notes(noteText = ""))
    private var _noteId: Int? = null

    val notesTextFlow: StateFlow<Notes>
        get() = _notesTextFlow


    fun saveNoteOrUpdateNote(noteText: String) {
        if (noteText.trim().isNotEmpty()) {
            viewModelScope.launch {
                val currentNote = _notesTextFlow.value
                val notes = Notes(
                    id = _noteId ?: 0,
                    noteText = noteText,
                    noteColor = currentNote.noteColor,
                    noteSize = noteText.length
                )
                notesUseCase.insertNote(notes)
            }
        }
    }

    fun getNoteById(noteId: Int) {
        _noteId = noteId
        viewModelScope.launch {
            notesUseCase.getNoteById(noteId).collect { notes ->
                notes.firstOrNull()?.let { note ->
                    _notesTextFlow.value = note
                }
            }
        }
    }

    fun updateColor(colorHex: String) {
        _notesTextFlow.value.noteColor = colorHex
    }

    fun deleteNote() {
        viewModelScope.launch {
            notesUseCase.deleteNote(_notesTextFlow.value)
        }
    }

}