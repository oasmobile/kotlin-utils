import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    `java-library`
}

group = "com.oasis.mlib"
version = "v0.0.1"

repositories {
    mavenCentral()
    mavenLocal()
    maven(url = "https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}