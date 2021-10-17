plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    // KOIN
    implementation(Libs.AndroidX.Koin.koinCore)

    //COROUTINES
    implementation(Libs.AndroidX.Kotlin.coroutinesCore)

    //TEST
    testImplementation(Libs.Test.junitCore)
    testImplementation(Libs.Test.coroutinesTesting)
    testImplementation(Libs.Test.mockitoTesting)

}