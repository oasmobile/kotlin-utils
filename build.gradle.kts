//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    id("com.gradle.plugin-publish") version "0.15.0"
    `java-library`
    `maven-publish`
    `java-gradle-plugin`
}

group = "com.oasis.mlib"
version = "v3.2.0"

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "11"
//}

gradlePlugin {
    plugins {
        create("oasisDistributionPlugin") {
            id = "com.oasis.gradle.distribution"
            implementationClass = "com.oasis.mlib.utils.GradlePlugin"
        }
    }
}

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

pluginBundle {
    // These settings are set for the whole plugin bundle
    website = "https://github.com/oasmobile/kotlin-utils"
    vcsUrl = "https://github.com/oasmobile/kotlin-utils"

    // tags and description can be set for the whole bundle here, but can also
    // be set / overridden in the config for specific plugins
    description = "Build product for distribution"

    // The plugins block can contain multiple plugin entries.
    //
    // The name for each plugin block below (greetingsPlugin, goodbyePlugin)
    // does not affect the plugin configuration, but they need to be unique
    // for each plugin.

    // Plugin config blocks can set the id, displayName, version, description
    // and tags for each plugin.

    // id and displayName are mandatory.
    // If no version is set, the project version will be used.
    // If no tags or description are set, the tags or description from the
    // pluginBundle block will be used, but they must be set in one of the
    // two places.

    (plugins) {
        // plugin
        "oasisDistributionPlugin" {
            // id is captured from java-gradle-plugin configuration
            displayName = "Product distribution plugin"
            tags = listOf("build", "publish")
            version = "1.2"
        }
    }

    // Optional overrides for Maven coordinates.
    // If you have an existing plugin deployed to Bintray and would like to keep
    // your existing group ID and artifact ID for continuity, you can specify
    // them here.
    //
    // As publishing to a custom group requires manual approval by the Gradle
    // team for security reasons, we recommend not overriding the group ID unless
    // you have an existing group ID that you wish to keep. If not overridden,
    // plugins will be published automatically without a manual approval process.
    //
    // You can also override the version of the deployed artifact here, though it
    // defaults to the project version, which would normally be sufficient.

    mavenCoordinates {
        groupId = "com.oasis.mlib"
        artifactId = "KotlinUtils"
        version = "3.3"
    }
}