import org.gradle.api.JavaVersion

object ProjectConfig {

    const val appId = "com.lls.jetnotes"
    const val compileSdk = 34
    const val minSdk = 23
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.1"
    val jvtTarget = JavaVersion.VERSION_17.toString()
    val javaVersion = JavaVersion.VERSION_17

}