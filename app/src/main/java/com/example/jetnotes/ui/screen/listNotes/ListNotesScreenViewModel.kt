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

    private val _notesFlow = MutableStateFlow(listOf<String>())
    val notesFlow: StateFlow<List<String>>
        get() = _notesFlow

    init {
        viewModelScope.launch {
            if(notesDataSource.getAllNotes().first().isEmpty()) {
                notesDataSource.insertNote(NotesEntity(noteText = "Db note 1"))
                notesDataSource.insertNote(NotesEntity(noteText = "Db note 2"))
                notesDataSource.insertNote(NotesEntity(noteText = "Db note 3"))
                notesDataSource.insertNote(NotesEntity(noteText = "Db note 4"))
                notesDataSource.insertNote(NotesEntity(noteText = "Db note 5"))
            }

            delay(DELAY_TIME)
            getNotes().collect { collectedNotes ->
                _notesFlow.value = collectedNotes.map { it.noteText }
            }
        }
    }

    private fun getNotes() = notesDataSource.getAllNotes()

    fun addNote() {
        viewModelScope.launch {
            notesDataSource.insertNote(NotesEntity(noteText = "Db note ${Random(1000)}"))
        }
    }

    companion object {
        private const val DELAY_TIME = 3000L

    }

}