import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("com.gradleup.shadow") version "8.3.2"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

dependencies {
    implementation(project(":api"))

    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("io.th0rgal:oraxen:1.173.0") // newest versions that supports Java 17

    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:5.0.5")
    implementation("com.github.puregero:multilib:1.2.4") // Folia & ShreddedPaper support
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    processResources {
        outputs.upToDateWhen { false }
        filter<ReplaceTokens>(mapOf(
            "tokens" to mapOf("version" to project.version.toString()),
            "beginToken" to "\${",
            "endToken" to "}"
        ))
    }

    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    shadowJar {
        val pack = "dev.jsinco.brewery.depend"

        // TODO: relocate things
        relocate("com.github.Anon8281.universalScheduler", "${pack}.universalScheduler")

        archiveClassifier.set("")
    }

    jar {
        enabled = false
    }


    runServer {
        minecraftVersion("1.21.3")
    }
}