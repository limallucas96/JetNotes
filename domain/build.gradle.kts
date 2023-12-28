plugins {
    id("java-library")
    id("kotlin")
}

java {

    sourceCompatibility = ProjectConfig.javaVersion
    targetCompatibility = ProjectConfig.javaVersion
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