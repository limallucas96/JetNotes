package database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_entity")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val noteText: String
)