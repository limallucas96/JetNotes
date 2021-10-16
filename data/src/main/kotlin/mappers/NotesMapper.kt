package mappers

import database.entities.NotesEntity
import entities.Notes

// FROM DATA
fun List<NotesEntity>.toNotesList() = map { Notes(it.id, it.noteText) }

// FROM DOMAIN

fun Notes.toNotesEntity() = NotesEntity(id, noteText)