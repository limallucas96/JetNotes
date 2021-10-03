package com.example.jetnotes.ui.screen.listNotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnotes.data.datasource.NotesDataSource
import com.example.jetnotes.data.entities.NotesEntity
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

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

}