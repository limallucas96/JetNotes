plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {

    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "com.example.jetnotes.base.KoinTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = ProjectConfig.jvtTarget
            useIR = true
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.version
        kotlinCompilerVersion = Kotlin.version
    }

    packagingOptions {
        resources {
            excludes += ("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(AndroidX.core)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifecycle)
    implementation(AndroidX.viewModel)

    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.toolingPreview)
    implementation(Compose.viewModel)
    implementation(Compose.activity)
    implementation(Compose.constraintLayout)

    implementation(Google.navigation)
    implementation(Google.material)

    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Koin.compose)

    implementation(Room.runtime)
    implementation(Room.ktx)
    kapt(Room.compiler)

    platform(Firebase.bom)
    implementation(Firebase.analytics)

    testImplementation(JUnit.core)
    testImplementation(Koin.Testing.test)

    debugImplementation(Compose.Testing.tooling)

    androidTestImplementation(AndroidX.Testing.core)
    androidTestImplementation(AndroidX.Testing.rules)
    androidTestImplementation(AndroidX.Testing.junitExt)
    androidTestImplementation(AndroidX.Testing.espresso)
    androidTestImplementation(Compose.Testing.junit)
    androidTestImplementation(Koin.Testing.junit)

}