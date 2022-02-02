package entities

import extensions.DATE_ABBREVIATION_FORMAT
import extensions.format
import java.io.Serializable
import java.util.*

data class Notes(
    val id: Int = 0,
    val noteText: String,
    var noteColor: String = NotesColor.DEFAULT.hex,
    val noteSize: Int = 0,
    val createDate: String? = Date().format(String.DATE_ABBREVIATION_FORMAT)
) : Serializable

enum class NotesColor(val hex: String) {
    DARK_TERRA_COTTA("#D14960"),
    MEAT_BROWN("#E8BD43"),
    BOOGER_BUSTER("#E7E063"),
    IGUANA_GREEN("#7DC481"),
    PURPLE_NAVY("#415787"),
    CYBER_GRAPE("#583B73"),
    DEFAULT("#121212");

    companion object {
        fun getColors(): List<NotesColor> {
            val colors = values().toMutableList()
            colors.removeLast()
            return colors
        }

        fun fromHex(hexColor: String) = values().firstOrNull { it.hex.equals(hexColor, true) } ?: DEFAULT

    }
}
