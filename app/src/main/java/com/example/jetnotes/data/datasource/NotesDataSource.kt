package com.example.jetnotes.data.datasource

import androidx.room.*
import com.example.jetnotes.data.entities.NotesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDataSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NotesEntity)

    @Query("SELECT * FROM notes_entity WHERE id = :noteId")
    fun getNoteById(noteId: Int): Flow<List<NotesEntity>>

    @Query("SELECT * FROM notes_entity")
    fun getAllNotes(): Flow<List<NotesEntity>>

    @Delete
    suspend fun deleteNote(note: NotesEntity)

}