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
    implementation(Koin.core)

    //COROUTINES
    implementation(Coroutines.core)

    //TEST
    implementation(JUnit.core)

    testImplementation(Coroutines.Testing.coroutines)
    testImplementation(Mockito.kotlin)

}