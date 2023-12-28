// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Plugins.applicationVersion apply false
    id(Plugins.jetbrainsKotlinAndroid) version Plugins.kotlinVersion apply false
    id(Plugins.googleGsm) version Plugins.googleGsmVersion apply false
    id(Plugins.hiltAndroid) version Plugins.hiltAndroidVersion apply false
}