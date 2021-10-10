package local.datasource

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import local.entities.NotesEntity

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