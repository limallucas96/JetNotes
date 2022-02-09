object AndroidX {

    private const val coreVersion = "1.6.0"
    const val core = "androidx.core:core-ktx:$coreVersion"

    private const val appCompatVersion = "1.3.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val lifecycleVersion = "2.3.1"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"

    object Testing {

        private const val coreVersion = "1.0.0"
        const val core = "androidx.test:core:$coreVersion"

        private const val rulesVersion = "1.1.0"
        const val rules = "androidx.test:rules:$rulesVersion"

        private const val junitExtVersion = "1.1.3"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"

        private const val junitExtKtxVersion = "1.1.3"
        const val junitExtKtx = "androidx.test.ext:junit-ktx:$junitExtKtxVersion"

        private const val runnerVersion = "1.4.0"
        const val runner = "androidx.test:runner:$runnerVersion"

        private const val espressoVersion = "3.4.0"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"

        private const val monitorVersion = "1.5.0"
        const val monitor = "androidx.test:monitor:$monitorVersion"

    }

}