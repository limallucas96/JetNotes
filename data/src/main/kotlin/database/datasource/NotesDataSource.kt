package database.datasource

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import database.entities.NotesEntity

@Dao
interface NotesDataSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NotesEntity)

    @Query("SELECT * FROM notes_entity WHERE id = :noteId")
    fun getNoteById(noteId: Int): Flow<List<NotesEntity>>

    @Query("SELECT * FROM notes_entity")
    fun getAllNotes(): Flow<List<NotesEntity>>

    @Delete
    fun deleteNote(note: NotesEntity)

}