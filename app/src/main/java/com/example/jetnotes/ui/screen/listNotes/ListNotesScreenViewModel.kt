package com.example.jetnotes.ui.screen.listNotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import local.datasource.NotesDataSource
import local.entities.NotesEntity

@InternalCoroutinesApi
class ListNotesScreenViewModel(private val notesDataSource: NotesDataSource) : ViewModel() {

    private val _notesFlow = MutableStateFlow(listOf<NotesEntity>())

    val notesFlow: StateFlow<List<NotesEntity>>
        get() = _notesFlow

    init {
        viewModelScope.launch {
            getNotes().collect { collectedNotes ->
                _notesFlow.value = collectedNotes
            }
        }
    }

    private fun getNotes() = notesDataSource.getAllNotes()

    fun deleteNote(notesEntity: NotesEntity) {
        viewModelScope.launch {
            notesDataSource.deleteNote(notesEntity)
        }
    }

}