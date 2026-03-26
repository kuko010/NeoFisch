import gg.meza.stonecraft.mod

plugins {
    id("gg.meza.stonecraft")
}

modSettings {
    clientOptions {
        fov = 90
        guiScale = 3
        narrator = false
        darkBackground = true
        musicVolume = 0.0
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}


tasks.processResources {
    if (mod.isNeoforge) {
        val props = mapOf(
            "neoforge_version" to (findProperty("neoforge_version")?.toString() ?: ""),
            "id" to mod.id,
            "version" to mod.version,
            "name" to mod.name,
            "description" to mod.description,
            "minecraftVersion" to (findProperty("minecraft_version")?.toString() ?: "")
        )

        inputs.properties(props)

        filesMatching("META-INF/neoforge.mods.toml") {
            expand(props)
        }
    }
}

repositories {
    maven {
        name = "ParchmentMC"
        url = uri("https://maven.parchmentmc.org")
    }
}


// Example of overriding publishing settings
publishMods {
    modrinth {
        if (mod.isFabric) requires("fabric-api")
    }

    curseforge {
        clientRequired = true // Set as needed
        serverRequired = false // Set as needed
        if (mod.isFabric) requires("fabric-api")
    }
}
