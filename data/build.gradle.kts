plugins {
    id(Plugins.com_android_library)
    id(Plugins.kotlinAndroid)
    id(Plugins.hilt)
    id(Plugins.kotlinKapt)
}

android {

    namespace = "com.lls.data"

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
        sourceCompatibility = ProjectConfig.javaVersion
        targetCompatibility = ProjectConfig.javaVersion
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = ProjectConfig.jvtTarget
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

    implementation(Hilt.hilt)
    kapt(Hilt.compiler)

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