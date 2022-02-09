plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk

        //START: Room instrumented unity tests configs
        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
            }
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
            jvmTarget = ProjectConfig.jvtTarget
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

    implementation(project(Modules.domain))

    // ROOM
    implementation(Room.runtime)
    implementation(Room.ktx)
    kapt(Room.compiler)

    // KOIN
    implementation(Koin.core)
    implementation(Koin.android)

    //TEST
    testImplementation(JUnit.core)
    testImplementation(Coroutines.Testing.coroutines)
    testImplementation(Mockito.kotlin)

    androidTestImplementation(AndroidX.Testing.runner)
    androidTestImplementation(AndroidX.Testing.junitExt)
    androidTestImplementation(AndroidX.Testing.junitExtKtx)

    implementation(Room.Testing.core)
    implementation(AndroidX.Testing.monitor)

}