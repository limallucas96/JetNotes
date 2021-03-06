object Compose {

    const val version = "1.0.0"

    const val ui = "androidx.compose.ui:ui:$version"
    const val material = "androidx.compose.material:material:$version"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"

    private const val viewModelVersion = "1.0.0-alpha07"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$viewModelVersion"

    private const val activityVersion = "1.3.1"
    const val activity = "androidx.activity:activity-compose:$activityVersion"

    private const val constraintVersion = "1.0.0-beta02"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:$constraintVersion"

    object Testing {

        const val junit = "androidx.compose.ui:ui-test-junit4:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"

    }
}