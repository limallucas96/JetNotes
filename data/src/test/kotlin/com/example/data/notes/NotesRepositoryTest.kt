package com.example.data.notes

import com.example.test.base.BaseUseCaseTest
import com.example.data.notes.NotesMockProvider.getNoteIdMock
import com.example.data.notes.NotesMockProvider.getNoteMock
import entities.Notes
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import repository.local.NotesRepository

@ExperimentalCoroutinesApi
class NotesRepositoryTest : BaseUseCaseTest() {

    private lateinit var notesRepository: NotesRepository
    private lateinit var fakeNotesDataSource: FakeNotesDataSource

    @Before
    fun setup() {
        fakeNotesDataSource = FakeNotesDataSource()
        notesRepository = NotesRepository(fakeNotesDataSource)
        fakeNotesDataSource.clearNotes()
    }

    @Test
    fun `should have at least one record in database`() = runBlockingTest {
        notesRepository.insertNote(getNoteMock())
        val dbNotes = notesRepository.getAllNotes().firstOrNull() ?: listOf()
        assert(dbNotes.isNotEmpty())
    }

    @Test
    fun `should have at least one record in database that matches given id`() = runBlockingTest {

        val expectedId = 77

        (1..100).forEachIndexed { index, i ->
            notesRepository.insertNote(Notes(index, "$i"))
        }

        val dbNotes = notesRepository.getNoteById(expectedId).firstOrNull() ?: listOf()

        assert(dbNotes.firstOrNull { it.id == expectedId } != null)
    }

    @Test
    fun `should NOT have any note in database`() = runBlockingTest {
        val dbNotes = notesRepository.getAllNotes().firstOrNull() ?: listOf()
        assert(dbNotes.isEmpty())
    }

    @Test
    fun `should NOT have any note in database matching given id`() = runBlockingTest {
        val dbNotes = notesRepository.getNoteById(getNoteIdMock()).firstOrNull() ?: listOf()
        assert(dbNotes.isEmpty())
    }

    @Test
    fun `should delete given note`() = runBlockingTest {

        val note1 = Notes(1, "note mock 1")
        val note2 = Notes(2, "note mock 2")
        val note3 = Notes(3, "note mock 3")

        notesRepository.insertNote(note1)
        notesRepository.insertNote(note2)
        notesRepository.insertNote(note3)

        notesRepository.deleteNote(note2)

        val dbNotes = notesRepository.getAllNotes().firstOrNull() ?: listOf()

        assert(dbNotes.containsAll(listOf(note2)).not())
    }
}

