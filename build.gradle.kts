plugins {
    kotlin("jvm") version "1.9.0" apply false
    id("io.gitlab.arturbosch.detekt") version "1.23.0"  // Static analysis
    id("org.jetbrains.kotlinx.kover") version "0.7.3"   // Code coverage
}

allprojects {
    group = "com.nexus"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}