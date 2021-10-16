plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdk = Libs.compileSdk

    defaultConfig {
        minSdk = Libs.minSdk
        targetSdk = Libs.targetSdk
//        versionCode = Libs.versionCode
//        versionName = Libs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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

    packagingOptions {
        resources {
            excludes += ("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":domain"))

    // ROOM
    implementation(Libs.AndroidX.Room.roomBase)
    kapt(Libs.AndroidX.Room.roomCompiler)
    implementation(Libs.AndroidX.Room.roomKtx)

    // KOIN
    implementation(Libs.AndroidX.Koin.koinCore)
    implementation(Libs.AndroidX.Koin.koinAndroid)

    //TEST
    testImplementation(Libs.Test.junitCore)

}