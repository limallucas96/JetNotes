package com.example.data.notes

import database.entities.NotesEntity
import entities.Notes
import kotlinx.coroutines.flow.flowOf

object NotesEntityMock {

    fun getSuccessMock() = 1L

    fun getErrorMock() = 0L

    fun getNoteIdMock() = 1

    fun getNoteMock()= Notes(getNoteIdMock(), "mock note")

    fun getNotesEntityMock() = NotesEntity(getNoteIdMock(), "mock note")

    fun getNonEmptyNoteListMock() = flowOf(listOf(getNotesEntityMock(), getNotesEntityMock()))

}