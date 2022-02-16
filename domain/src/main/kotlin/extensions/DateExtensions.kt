package extensions

import extensions.Locale.DEFAULT_LOCALE
import java.text.SimpleDateFormat
import java.util.*

object Locale {
    private const val LOCALE_LANGUAGE = "en"
    private const val LOCALE_COUNTRY = "US"
    val DEFAULT_LOCALE = Locale(LOCALE_LANGUAGE, LOCALE_COUNTRY)
}

val String.Companion.DATE_ABBREVIATION_FORMAT: String
    get() = "MMM dd, yyyy"

fun Date?.format(format: String): String? {
    return try {
        this?.run { SimpleDateFormat(format, DEFAULT_LOCALE).format(this) }
    } catch (ex: Exception) {
        null
    }
}

fun String?.parse(format: String): Date? {
    return try {
        this?.run { SimpleDateFormat(format, DEFAULT_LOCALE).parse(this) }
    } catch (ex : Exception) {
        null
    }
}