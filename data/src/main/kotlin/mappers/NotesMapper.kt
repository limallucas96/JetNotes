package mappers

import database.entities.NotesEntity
import entities.Notes
import entities.NotesColor

// FROM DATA
fun List<NotesEntity>.toNotesList() = map {
    Notes(
        id = it.id,
        noteText = it.noteText,
        noteColor = it.color ?: NotesColor.DEFAULT.hex,
        noteSize = it.noteText.length,
        createDate = it.date
    )
}

// FROM DOMAIN

fun Notes.toNotesEntity() = NotesEntity(id, noteText, noteColor, createDate)