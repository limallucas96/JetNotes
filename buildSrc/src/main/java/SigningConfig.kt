object SigningConfig {

    private const val BASE_PATH = "keys/"
    const val release = "release"
    const val debug = "debug"

    object Release {
        const val keyAlias = "release-keystore"
        const val keyPassword = "123@Jetnotes"
        const val storeFile = "${BASE_PATH}release.keystore.jks"
        const val  storePassword = "123@Jetnotes"
    }

    object Debug {
        const val  keyAlias = "debug-keystore"
        const val  keyPassword = "android"
        const val  storeFile = "${BASE_PATH}debug.keystore.jks"
        const val  storePassword = "android"
    }

}