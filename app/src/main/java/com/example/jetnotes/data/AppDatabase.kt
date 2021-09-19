package com.example.jetnotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetnotes.data.datasource.NotesDataSource
import com.example.jetnotes.data.entities.NotesEntity

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