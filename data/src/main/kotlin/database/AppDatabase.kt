package database

import androidx.room.Database
import androidx.room.RoomDatabase
import database.datasource.NotesDataSource
import database.entities.NotesEntity

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