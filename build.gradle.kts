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
    implementation("org.apache.cassandra:cassandra-all:3.0.26") {
        exclude(group = "org.slf4j", module = "slf4j-log4j12")
        exclude(group = "log4j", module = "log4j")
    }
}
