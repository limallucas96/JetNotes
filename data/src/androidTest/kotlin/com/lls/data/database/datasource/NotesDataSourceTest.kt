package com.lls.data.database.datasource

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.lls.data.database.mocks.DataSourceMockProvider.FAKE_DATA_BASE_NAME
import database.AppDatabase
import database.datasource.NotesDataSource
import entities.Notes
import entities.NotesColor
import extensions.DATE_ABBREVIATION_FORMAT
import extensions.format
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import mappers.toNotesEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class NotesDataSourceTest {

    private lateinit var database: AppDatabase

    private lateinit var notesDatasource: NotesDataSource

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room
            .databaseBuilder(context, AppDatabase::class.java, FAKE_DATA_BASE_NAME)
            .fallbackToDestructiveMigration().build()
        notesDatasource = database.getNotesDataSource()
        database.clearAllTables()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun notesDataSource_DatabaseShouldBeEmpty() = runBlocking {
        val notesDb = notesDatasource.getAllNotes().firstOrNull() ?: listOf()
        assert(notesDb.isEmpty())
    }

    @Test
    fun notesDataSource_WriteAndReadTest() = runBlocking {

        val note = Notes(
            noteText = "Note",
            noteColor = NotesColor.DEFAULT.hex,
            noteSize = 3,
            createDate = Date().format(String.DATE_ABBREVIATION_FORMAT)
        )

        notesDatasource.insertNote(note.toNotesEntity())
        val notesDb = notesDatasource.getAllNotes().firstOrNull() ?: listOf()

        assert(notesDb.isNotEmpty())
    }

    @Test
    fun notesDataSource_GetNoteByIdTest() = runBlocking {

        val noteId = 5
        val expectedSize = 10
        val noteForIndex5 = "My index 5 note test"

        (1..10).forEach {
            val noteText = if (it == noteId) noteForIndex5 else "Other notes"
            val note = Notes(id = it, noteText = noteText)
            notesDatasource.insertNote(note.toNotesEntity())
        }

        val notesDb = notesDatasource.getAllNotes().firstOrNull() ?: listOf()
        val noteById = notesDatasource.getNoteById(noteId).firstOrNull()?.firstOrNull()

        assert(notesDb.isNotEmpty())
        assert(notesDb.size == expectedSize)
        assert(noteById?.noteText == noteForIndex5)
    }

    @Test
    fun notesDataSource_DeleteNoteTest() = runBlocking {

        val noteId = 5
        val previousExpectedSize = 10
        val updatedExpectedSize = 9
        val noteToDelete = Notes(id = 1001, "note to delete").toNotesEntity()

        (1..10).forEach {
            val note = Notes(id = it, noteText = "Other notes")
            notesDatasource.insertNote(if (it == noteId) noteToDelete else note.toNotesEntity())
        }

        val previousNotesDb = notesDatasource.getAllNotes().firstOrNull() ?: listOf()
        notesDatasource.deleteNote(noteToDelete)
        val updatedNotesDb = notesDatasource.getAllNotes().firstOrNull() ?: listOf()

        assert(previousNotesDb.isNotEmpty())
        assert(previousNotesDb.size == previousExpectedSize)
        assert(previousNotesDb.contains(noteToDelete))
        assert(updatedNotesDb.size == updatedExpectedSize)
        assert(updatedNotesDb.contains(noteToDelete).not())
    }

}