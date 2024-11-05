plugins {
    java
}

tasks {
    jar {
        enabled = false
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "idea")

    group = "dev.jsinco.brewery"
    version = "1.0-SNAPSHOT"

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    repositories {
        mavenCentral()

        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://jitpack.io")
        maven("https://repo.oraxen.com/releases")
        maven("https://storehouse.okaeri.eu/repository/maven-public/")
        maven("https://repo.oraxen.com/releases")
        maven("https://repo.clojars.org/")
    }

    dependencies {
        implementation("org.jetbrains:annotations:26.0.1")

        compileOnly("org.projectlombok:lombok:1.18.34")
        annotationProcessor("org.projectlombok:lombok:1.18.34")
    }
}

