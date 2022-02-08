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

        //START: Room instrumented unity tests configs
        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
            }
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        configurations.all {
//            resolutionStrategy.force("androidx.room:room-testing:2.4.1")
//        }
        //END: Room instrumented unity tests configs

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

    //START: Room instrumented unity tests configs
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/schemas")
    }
    //END: Room instrumented unity tests configs
}

dependencies {

    implementation(project(":domain"))

    // ROOM
    implementation(Libs.AndroidX.Room.roomBase)
    implementation("androidx.room:room-testing:2.4.1")
    implementation("androidx.test:monitor:1.5.0")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.3")
    kapt(Libs.AndroidX.Room.roomCompiler)
    implementation(Libs.AndroidX.Room.roomKtx)

    // KOIN
    implementation(Libs.AndroidX.Koin.koinCore)
    implementation(Libs.AndroidX.Koin.koinAndroid)

    //TEST
    testImplementation(Libs.Test.junitCore)
    testImplementation(Libs.Test.coroutinesTesting)
    testImplementation(Libs.Test.mockitoTesting)

    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")

}