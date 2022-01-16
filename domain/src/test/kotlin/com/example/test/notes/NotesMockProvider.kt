package com.example.test.notes

import entities.Notes

object NotesMockProvider {

    fun getNoteIdMock() = 1

    fun getNoteMock()= Notes(getNoteIdMock(), "mock note")

}