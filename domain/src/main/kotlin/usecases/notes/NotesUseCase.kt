package usecases.notes

import entities.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import repository.NotesRepositoryContract
import javax.inject.Inject

class NotesUseCase @Inject constructor(
    private val notesRepository: NotesRepositoryContract
) : NotesUseCaseContract {

    override suspend fun insertNote(note: Notes) {
        withContext(Dispatchers.IO) {
            notesRepository.insertNote(note)
        }
    }

    override fun getNoteById(noteId: Int): Flow<List<Notes>> {
        return notesRepository.getNoteById(noteId)
    }

    override fun getAllNotes(): Flow<List<Notes>> {
        return notesRepository.getAllNotes()
    }

    override suspend fun deleteNote(note: Notes) {
        withContext(Dispatchers.IO) {
            notesRepository.deleteNote(note)
        }
    }

}