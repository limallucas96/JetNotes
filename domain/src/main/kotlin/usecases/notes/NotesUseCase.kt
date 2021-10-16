package usecases.notes

import entities.Notes
import kotlinx.coroutines.flow.Flow
import repository.NotesRepositoryContract

class NotesUseCase(private val notesRepository: NotesRepositoryContract) : NotesUseCaseContract {

    override suspend fun insertNote(note: Notes) {
        notesRepository.insertNote(note)
    }

    override fun getNoteById(noteId: Int): Flow<List<Notes>> {
        return notesRepository.getNoteById(noteId)
    }

    override fun getAllNotes(): Flow<List<Notes>> {
        return notesRepository.getAllNotes()
    }

    override suspend fun deleteNote(note: Notes) {
        notesRepository.deleteNote(note)
    }

}