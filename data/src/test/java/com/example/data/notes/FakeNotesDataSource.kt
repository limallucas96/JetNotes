package com.example.data.notes

import database.datasource.NotesDataSource
import database.entities.NotesEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNotesDataSource : NotesDataSource {

    private val _fakeNotes = mutableListOf<NotesEntity>()

    fun clearNotes() {
        _fakeNotes.clear()
    }

    override suspend fun insertNote(note: NotesEntity): Long {
        _fakeNotes.add(note)
        return 1L
    }

    override fun getNoteById(noteId: Int): Flow<List<NotesEntity>> {
        return flow { emit(_fakeNotes.filter { it.id == noteId }) }
    }

    override fun getAllNotes(): Flow<List<NotesEntity>> {
        return flow { emit(_fakeNotes) }
    }

    override suspend fun deleteNote(note: NotesEntity) {
        _fakeNotes.remove(note)
    }
}