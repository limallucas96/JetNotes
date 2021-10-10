package local

import androidx.room.Database
import androidx.room.RoomDatabase
import local.datasource.NotesDataSource
import local.entities.NotesEntity

@Database(
    entities = [
        (NotesEntity::class),
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getNotesDataSource(): NotesDataSource
}