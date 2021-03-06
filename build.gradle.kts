// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    Koin.koin
}

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.koinGradlePlugin)
        classpath(Google.gmsServices)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}