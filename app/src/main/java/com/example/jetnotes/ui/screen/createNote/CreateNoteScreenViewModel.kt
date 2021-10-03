package com.example.jetnotes.ui.screen.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnotes.data.datasource.NotesDataSource
import com.example.jetnotes.data.entities.NotesEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CreateNoteScreenViewModel(private val notesDataSource: NotesDataSource) : ViewModel() {

    private var _notesTextFlow = MutableStateFlow(String())
    private var _noteId: Int? = null

    val notesTextFlow: StateFlow<String>
        get() = _notesTextFlow


    fun saveNoteOrUpdateNote(noteText: String) {
        if (noteText.trim().isNotEmpty()) {
            viewModelScope.launch {
                val notesEntity = _noteId?.let {
                    NotesEntity(id = it, noteText = noteText)
                } ?: NotesEntity(noteText = noteText)
                notesDataSource.insertNote(notesEntity)
            }
        }
    }

    fun getNoteById(noteId: Int) {
        _noteId = noteId
        viewModelScope.launch {
            notesDataSource.getNoteById(noteId).collect { notes ->
                notes.firstOrNull()?.noteText?.let { noteText ->
                    _notesTextFlow.value = noteText
                }
            }
        }
    }

}