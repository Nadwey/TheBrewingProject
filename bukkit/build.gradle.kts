import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("com.gradleup.shadow") version "8.3.2"
}

dependencies {
    implementation(project(":api"))

    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("io.th0rgal:oraxen:1.173.0")

    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:5.0.5")
    implementation("com.github.Anon8281:UniversalScheduler:0.1.3")
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
}