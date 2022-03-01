import java.text.SimpleDateFormat
import java.util.*

object ProjectConfig {

    const val appId = "com.llds.jetnotes"
    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 30
    const val versionCode = 2
    const val jvtTarget = "1.8"
    const val debugApplicationIdSuffix = ".debug"

    val versionName = "$versionCode.${getDateTimestamp()}"

    private fun getDateTimestamp(): String {
        val df = SimpleDateFormat("yyyyMMdd.HHmm", Locale.US)
        df.timeZone = TimeZone.getTimeZone("America/Sao_Paulo")
        return df.format(Date())
    }
}