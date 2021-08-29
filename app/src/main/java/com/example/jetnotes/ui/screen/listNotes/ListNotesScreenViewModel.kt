package com.example.jetnotes.ui.screen.listNotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class ListNotesScreenViewModel : ViewModel() {

    private var notes = mutableListOf("Note 1", "Note 2", "Note 3", "Note 4", "Note 5", "Note 6")

    private val _notesFlow = MutableStateFlow(listOf<String>())
    val notesFlow: StateFlow<List<String>>
        get() = _notesFlow

    init {
        viewModelScope.launch {
            delay(DELAY_TIME)
            getNotes().collect { collectedNotes ->
                _notesFlow.value = collectedNotes
            }
        }
    }

    private fun getNotes(): Flow<List<String>> {
        return flowOf(notes)
    }

    fun addNote() {
        viewModelScope.launch {
            delay(10000L)
            notes.add("new note ${notes.size}")
        }
    }

    companion object {
        private const val DELAY_TIME = 3000L

    }

}