plugins {
    `maven-publish`
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21.3-R0.1-SNAPSHOT")
}

tasks {
    jar {
        archiveBaseName.set(rootProject.name)
        archiveVersion.set(project.version.toString())
        archiveClassifier.set("api")
    }
}