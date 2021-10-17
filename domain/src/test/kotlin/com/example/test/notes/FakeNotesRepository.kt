package com.example.test.notes

import entities.Notes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import repository.NotesRepositoryContract

class FakeNotesRepository : NotesRepositoryContract {

    private val _fakeNotes = mutableListOf<Notes>()

    fun clearNotes() {
        _fakeNotes.clear()
    }

    override suspend fun insertNote(note: Notes) {
        _fakeNotes.add(note)
    }

    override fun getNoteById(noteId: Int): Flow<List<Notes>> {
        return flow { emit(_fakeNotes.filter { it.id == noteId }) }
    }

    override fun getAllNotes(): Flow<List<Notes>> {
        return flow { emit(_fakeNotes) }
    }

    override suspend fun deleteNote(note: Notes) {
        _fakeNotes.remove(note)
    }
}