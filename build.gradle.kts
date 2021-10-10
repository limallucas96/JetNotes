// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    "koin"
}

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Libs.ClassPath.gradle)
        classpath(Libs.ClassPath.kotlinPlugin)
        classpath(Libs.ClassPath.koin)
        classpath(Libs.ClassPath.googleServices)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}