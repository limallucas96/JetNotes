object Koin {

    const val version = "3.1.2"
    const val koin = "koin"

    const val android = "io.insert-koin:koin-android:$version"
    const val core = "io.insert-koin:koin-core:$version"
    const val compose = "io.insert-koin:koin-androidx-compose:$version"

    object Testing {
        const val test = "io.insert-koin:koin-test:$version"
        const val junit = "io.insert-koin:koin-test-junit4:$version"
    }

}