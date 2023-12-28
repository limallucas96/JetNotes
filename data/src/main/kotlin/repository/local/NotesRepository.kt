package repository.local

import database.datasource.NotesDataSource
import entities.Notes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import mappers.toNotesEntity
import mappers.toNotesList
import repository.NotesRepositoryContract

class NotesRepository(private val notesDataSource: NotesDataSource) : NotesRepositoryContract {

    override suspend fun insertNote(note: Notes) {
        notesDataSource.insertNote(note.toNotesEntity())
    }

    override fun getNoteById(noteId: Int): Flow<List<Notes>> {
        return notesDataSource.getNoteById(noteId).map { it.toNotesList() }
    }

    override fun getAllNotes(): Flow<List<Notes>> {
        return notesDataSource.getAllNotes().map { it.toNotesList() }
    }

    override suspend fun deleteNote(note: Notes) {
        notesDataSource.deleteNote(note.toNotesEntity())
    }
}