package local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_entity")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val noteText: String
) : Serializable