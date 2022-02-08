object Libs {

    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.1"

    const val jvtTarget = "1.8"

    const val kotlinVersion = "1.5.10"
    const val composeVersion = "1.0.0"

    private const val koinVersion = "3.1.2"

    object ClassPath {
        private const val gradleVersion = "7.0.0"
        private const val googleServicesVersion = "4.3.10"
        const val gradle = "com.android.tools.build:gradle:$gradleVersion"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val koin = "io.insert-koin:koin-gradle-plugin:$koinVersion"
        const val googleServices = "com.google.gms:google-services:$googleServicesVersion"
    }

    object AndroidX {

        object Kotlin {
            private const val coroutinesCoreVersion = "1.5.2"
            const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesCoreVersion"
        }

        object Core {
            private const val coreKtxVersion = "1.6.0"
            const val ktx = "androidx.core:core-ktx:$coreKtxVersion"
        }

        object Appcompat {
            private const val appcompatVersion = "1.3.1"
            const val compat = "androidx.appcompat:appcompat:$appcompatVersion"
        }

        object Material {
            private const val materialVersion = "1.4.0"
            const val material = "com.google.android.material:material:$materialVersion"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui:$composeVersion"
            const val material = "androidx.compose.material:material:$composeVersion"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        }

        object LifeCycle {
            private const val lifeCycleVersion = "2.3.1"
            private const val composeViewModelVersion = "1.0.0-alpha07"
            const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"
        }

        object Activity {
            private const val activityVersion = "1.3.1"
            const val activity = "androidx.activity:activity-compose:$activityVersion"
        }

        object ConstraintLayout {
            private const val constraintLayoutComposeVersion = "1.0.0-beta02"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:$constraintLayoutComposeVersion"
        }

        object Navigation {
            private const val navigationAnimatedVersion = "0.16.0"

            const val navigationAnimated = "com.google.accompanist:accompanist-navigation-animation:$navigationAnimatedVersion"
        }

        object Koin {
            const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
            const val koinCore = "io.insert-koin:koin-core:$koinVersion"
            const val koinCompose = "io.insert-koin:koin-androidx-compose:$koinVersion"
        }

        object Room {
            private const val roomVersion = "2.3.0"
            const val roomBase = "androidx.room:room-runtime:$roomVersion"
            const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
            const val roomKtx = "androidx.room:room-ktx:$roomVersion"
        }

        object Firebase {
            private const val bomVersion = "28.4.2"
            private const val analyticsVersion = "19.0.2"
            const val firebaseBom = "com.google.firebase:firebase-bom:$bomVersion"
            const val firebaseAnalytics = "com.google.firebase:firebase-analytics:$analyticsVersion"
        }

    }

    object Test {

        private const val junitCoreVersion = "4.13.2"
        private const val junitExtVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"
        private const val coroutinesTestVersion = "1.5.0"
        private const val mockitoTestingVersion = "3.2.0"
        private const val androidXTestCoreVersion = "1.0.0"
        private const val androidXTestRulesVersion = "1.1.0"

        const val junitCore = "junit:junit:$junitCoreVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
        const val junit = "androidx.compose.ui:ui-test-junit4:$composeVersion"
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val coroutinesTesting = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"
        const val mockitoTesting = "org.mockito.kotlin:mockito-kotlin:$mockitoTestingVersion"
        const val koinTestingTools = "io.insert-koin:koin-test:$koinVersion"
        const val koinJUnit = "io.insert-koin:koin-test-junit4:$koinVersion"
        const val androidXTestCore = "androidx.test:core:$androidXTestCoreVersion"
        const val androidXTestRules = "androidx.test:rules:$androidXTestRulesVersion"
    }

    object ThirdParty {
        private const val swipeToRevealVersion = "1.0.0"
        const val swipeToReveal = "de.charlex.compose:revealswipe:$swipeToRevealVersion"
    }

}