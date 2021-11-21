plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {

    compileSdk = Libs.compileSdk

    defaultConfig {
        applicationId = "com.lls.jetnotes"
        minSdk = Libs.minSdk
        targetSdk = Libs.targetSdk
        versionCode = Libs.versionCode
        versionName = Libs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
            jvmTarget = Libs.jvtTarget
            useIR = true
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.composeVersion
        kotlinCompilerVersion = Libs.kotlinVersion
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

    implementation(Libs.AndroidX.Core.ktx)
    implementation(Libs.AndroidX.Appcompat.compat)
    implementation(Libs.AndroidX.Material.material)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.toolingPreview)

    implementation(Libs.AndroidX.LifeCycle.lifeCycle)
    implementation(Libs.AndroidX.LifeCycle.viewModel)
    implementation(Libs.AndroidX.LifeCycle.viewModelCompose)

    implementation(Libs.AndroidX.Activity.activity)
    implementation(Libs.AndroidX.ConstraintLayout.constraintLayout)
    implementation(Libs.AndroidX.Navigation.navigationAnimated)

    implementation(Libs.AndroidX.Koin.koinCore)
    implementation(Libs.AndroidX.Koin.koinAndroid)
    implementation(Libs.AndroidX.Koin.koinCompose)

    implementation(Libs.AndroidX.Room.roomBase)
    kapt(Libs.AndroidX.Room.roomCompiler)
    implementation(Libs.AndroidX.Room.roomKtx)

    platform(Libs.AndroidX.Firebase.firebaseBom)
    implementation(Libs.AndroidX.Firebase.firebaseAnalytics)

    testImplementation(Libs.Test.junitCore)
    androidTestImplementation(Libs.Test.junitExt)
    androidTestImplementation(Libs.Test.espresso)
    androidTestImplementation(Libs.Test.junit)
    debugImplementation(Libs.Test.tooling)

    implementation(Libs.ThirdParty.swipeToReveal)
}