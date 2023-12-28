object Room {

    private const val roomVersion = "2.4.0-alpha03"
    const val runtime = "androidx.room:room-runtime:$roomVersion"
    const val compiler = "androidx.room:room-compiler:$roomVersion"
    const val ktx = "androidx.room:room-ktx:$roomVersion"

    object Testing {

        private const val coreVersion = "2.4.1"
        const val core = "androidx.room:room-testing:$coreVersion"

    }

}