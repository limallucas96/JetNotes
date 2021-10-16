package com.example.data.notes

import com.example.data.base.BaseDataTest
import com.example.data.notes.NotesEntityMock.getNonEmptyNoteListMock
import com.example.data.notes.NotesEntityMock.getNoteIdMock
import com.example.data.notes.NotesEntityMock.getNoteMock
import com.example.data.notes.NotesEntityMock.getNotesEntityMock
import com.example.data.notes.NotesEntityMock.getSuccessMock
import database.datasource.NotesDataSource
import database.entities.NotesEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import repository.local.NotesRepository

@ExperimentalCoroutinesApi
class NotesRepositoryTest : BaseDataTest() {

    private lateinit var notesRepository: NotesRepository
    private lateinit var notesDataSource: NotesDataSource

    @Before
    fun setup() {
        notesDataSource = mock()
        notesRepository = NotesRepository(notesDataSource)
    }

    /** TODO

     1. Test void methods
     2. Test replace methods
     3.

     */

    @Test
    fun `should insert one note`() = runBlockingTest {
        whenever(notesDataSource.insertNote(getNotesEntityMock())).thenReturn(getSuccessMock())
        val dbNote = notesRepository.insertNote(getNoteMock())
        assert(dbNote == getSuccessMock())
    }

    @Test
    fun `should have at least one record in database`() = runBlockingTest {
        whenever(notesDataSource.getAllNotes()).thenReturn(getNonEmptyNoteListMock())
        val dbNotes = notesRepository.getAllNotes()
        assert(dbNotes.first().isNotEmpty())
    }

    @Test
    fun `should have at least one record in database that matches given id`() = runBlockingTest {
        val noteIdMock = getNoteIdMock()
        whenever(notesDataSource.getNoteById(noteIdMock)).thenReturn(getNonEmptyNoteListMock())
        val dbNotes = notesRepository.getNoteById(noteIdMock)
        assert(dbNotes.first().firstOrNull { it.id == noteIdMock } != null)
    }

    @Test
    fun `should NOT have any note in database`() = runBlockingTest {
        whenever(notesDataSource.getAllNotes()).thenReturn(flowOf())
        val dbNotes = notesRepository.getAllNotes()
        assert(dbNotes.toSet().isEmpty())
    }

    @Test
    fun `should NOT have any note in database matching given id`() = runBlockingTest {
        whenever(notesDataSource.getAllNotes()).thenReturn(flowOf())
        val dbNotes = notesRepository.getAllNotes()
        assert(dbNotes.toSet().isEmpty())
    }
}

