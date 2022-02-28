import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName
        setProperty("archivesBaseName", versionName)

        testInstrumentationRunner = "com.example.jetnotes.base.KoinTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {

        create(SigningConfig.release) {
            keyAlias = SigningConfig.Release.keyAlias
            keyPassword = SigningConfig.Release.keyPassword
            storeFile = file(SigningConfig.Release.storeFile)
            storePassword = SigningConfig.Release.storePassword
        }

        getByName(SigningConfig.debug) {
            keyAlias = SigningConfig.Debug.keyAlias
            keyPassword = SigningConfig.Debug.keyPassword
            storeFile = file(SigningConfig.Debug.storeFile)
            storePassword = SigningConfig.Debug.storePassword
        }
    }

    buildTypes {

        getByName(SigningConfig.release) {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName(SigningConfig.release)
        }

        getByName(SigningConfig.debug) {
            applicationIdSuffix = ProjectConfig.debugApplicationIdSuffix
            isDebuggable = true
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