package com.example.test.notes

import com.example.test.base.BaseUseCaseTest
import com.example.test.notes.NotesMockProvider.getNoteIdMock
import com.example.test.notes.NotesMockProvider.getNoteMock
import entities.Notes
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import usecases.notes.NotesUseCase

@ExperimentalCoroutinesApi
class NotesUseCaseTest : BaseUseCaseTest() {

    private lateinit var notesUseCase: NotesUseCase
    private lateinit var fakeNotesRepository: FakeNotesRepository

    @Before
    fun setup() {
        fakeNotesRepository = FakeNotesRepository()
        notesUseCase = NotesUseCase(fakeNotesRepository)
        fakeNotesRepository.clearNotes()
    }

    @Test
    fun `should have at least one record in database`() = runBlockingTest {
        notesUseCase.insertNote(getNoteMock())
        val dbNotes = notesUseCase.getAllNotes().firstOrNull() ?: listOf()
        assert(dbNotes.isNotEmpty())
    }

    @Test
    fun `should have at least one record in database that matches given id`() = runBlockingTest {

        val expectedId = 77

        (1..100).forEachIndexed { index, i ->
            notesUseCase.insertNote(Notes(index, "$i"))
        }

        val dbNotes = notesUseCase.getNoteById(expectedId).firstOrNull() ?: listOf()

        assert(dbNotes.firstOrNull { it.id == expectedId } != null)
    }

    @Test
    fun `should NOT have any note in database`() = runBlockingTest {
        val dbNotes = notesUseCase.getAllNotes().firstOrNull() ?: listOf()
        assert(dbNotes.isEmpty())
    }

    @Test
    fun `should NOT have any note in database matching given id`() = runBlockingTest {
        val dbNotes = notesUseCase.getNoteById(getNoteIdMock()).firstOrNull() ?: listOf()
        assert(dbNotes.isEmpty())
    }

    @Test
    fun `should delete given note`() = runBlockingTest {

        val note1 = Notes(1, "note mock 1")
        val note2 = Notes(2, "note mock 2")
        val note3 = Notes(3, "note mock 3")

        notesUseCase.insertNote(note1)
        notesUseCase.insertNote(note2)
        notesUseCase.insertNote(note3)

        notesUseCase.deleteNote(note2)

        val dbNotes = notesUseCase.getAllNotes().firstOrNull() ?: listOf()

        assert(dbNotes.containsAll(listOf(note2)).not())
    }

}