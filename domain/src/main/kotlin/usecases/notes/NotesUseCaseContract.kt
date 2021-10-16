package usecases.notes

import entities.Notes
import kotlinx.coroutines.flow.Flow

interface NotesUseCaseContract {

    suspend fun insertNote(note: Notes)

    fun getNoteById(noteId: Int): Flow<List<Notes>>

    fun getAllNotes(): Flow<List<Notes>>

    suspend fun deleteNote(note: Notes)

}