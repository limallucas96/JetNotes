object Libs {

    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"

    const val jvtTarget = "1.8"

    const val kotlinVersion = "1.5.10"
    const val composeVersion = "1.0.0"

    object ClassPath {
        private const val gradleVersion = "7.0.0"
        const val gradle = "com.android.tools.build:gradle:$gradleVersion"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    }

    object AndroidX {

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
//            private const val navigationVersion = "2.4.0-alpha06"
            private const val navigationAnimatedVersion = "0.16.0"

//            const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
            const val navigationAnimated = "com.google.accompanist:accompanist-navigation-animation:$navigationAnimatedVersion"
        }

    }

    object Test {
        private const val junitCoreVersion = "4.13.2"
        private const val junitExtVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"

        const val junitCore = "junit:junit:$junitCoreVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
        const val junit = "androidx.compose.ui:ui-test-junit4:$composeVersion"
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    }

}