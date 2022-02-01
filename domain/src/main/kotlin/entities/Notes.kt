package entities

import java.io.Serializable

data class Notes(
    val id: Int = 0,
    val noteText: String
) : Serializable

