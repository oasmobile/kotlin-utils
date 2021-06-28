import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    `java-library`
    `maven-publish`
}

group = "com.oasis.mlib"
version = "v3.0.0"

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

publishing {
    publications {
        create<MavenPublication>("KotlinUtils") {
            artifactId = "KotlinUtils"
            from(components["java"])
            pom {
                name.set("Kotlin Utils")
                description.set("oasis mlib kotlin utils library")
                url.set("https://github.com/oasmobile/kotlin-utils")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("zhangxuchang")
                        name.set("ZHANG XUCHANG")
                        email.set("zhangxuchang@oasgames.com")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            name = "KotlinUtils"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}