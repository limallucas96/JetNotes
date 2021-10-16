package repository

import entities.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepositoryContract {

    suspend fun insertNote(note: Notes) : Long

    fun getNoteById(noteId: Int): Flow<List<Notes>>

    fun getAllNotes(): Flow<List<Notes>>

    suspend fun deleteNote(note: Notes)

}