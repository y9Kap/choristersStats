plugins {
    kotlin("jvm") version "1.8.20"
}

group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.exposed:exposed-core:0.35.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.35.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.35.1")
    implementation("org.postgresql:postgresql:42.2.27")
}
kotlin {
    target.compilations.all {
        kotlinOptions {
            //freeCompilerArgs += "-jvm-target 11"
            jvmTarget = "11"
        }
    }
}
