plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    id(Plugins.googleGsm)
    id(Plugins.hilt)
    id(Plugins.kotlinKapt)
}

android {

    namespace = "com.lls.jetnotes"

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
        sourceCompatibility = ProjectConfig.javaVersion
        targetCompatibility = ProjectConfig.javaVersion
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = ProjectConfig.jvtTarget
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

    implementation(project(Modules.data))
    implementation(project(Modules.domain))

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

    implementation(Hilt.hilt)
    implementation(Hilt.navigationCompose)
    kapt(Hilt.compiler)

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