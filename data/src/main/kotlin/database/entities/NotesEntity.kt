package database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import database.DbConstants.TABLE_NAME_NOTES

@Entity(tableName = TABLE_NAME_NOTES)
data class NotesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val noteText: String,
    val color: String? = null,
    val date: String? = null
)