plugins {
    kotlin("jvm") version "1.9.20"
}

group = "uk.co.matt-bailey.adventofcode2023"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}