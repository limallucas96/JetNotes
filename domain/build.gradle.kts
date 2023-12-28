plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlin)
}

java {

    sourceCompatibility = ProjectConfig.javaVersion
    targetCompatibility = ProjectConfig.javaVersion
}

dependencies {

    // HILT
    implementation("javax.inject:javax.inject:1")

    //COROUTINES
    implementation(Coroutines.core)

    //TEST
    implementation(JUnit.core)

    testImplementation(Coroutines.Testing.coroutines)
    testImplementation(Mockito.kotlin)

}