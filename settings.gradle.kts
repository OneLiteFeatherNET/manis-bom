rootProject.name = "manis-bom"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            name = "OneLiteFeatherRepository"
            url = uri("https://repo.onelitefeather.dev/onelitefeather")
            if (System.getenv("CI") != null) {
                credentials {
                    username = System.getenv("ONELITEFEATHER_MAVEN_USERNAME")
                    password = System.getenv("ONELITEFEATHER_MAVEN_PASSWORD")
                }
            } else {
                credentials(PasswordCredentials::class)
                authentication {
                    create<BasicAuthentication>("basic")
                }
            }
        }
        maven("https://reposilite.atlasengine.ca/public")
    }
    versionCatalogs {
        create("libs") {
            version("mycelium.bom", "1.5.2")
            version("aonyx", "0.6.0")
            version("hibernate.bom", "7.1.10.Final")
            version("cloudnet.bom", "4.0.0-RC16-SNAPSHOT")

            version("common.io", "2.21.0")
            version("zt.zip", "1.17")
            version("caffeine", "3.2.3")
            version("worldSeed", "11.5.5")
            version("commons.geometry", "1.0")
            version("postgresql", "42.7.8")
            version("google.autovalue", "1.1.1")
            version("rabbitmq", "5.27.1")
            version("h2", "2.4.240")
            version("jaxb", "4.0.6")
            version("cyclonedx", "3.1.0")

            library("mycelium.bom", "net.onelitefeather", "mycelium-bom").versionRef("mycelium.bom")
            library("aonyx.bom", "net.onelitefeather", "aonyx-bom").versionRef("aonyx")
            library("hibernate.bom", "org.hibernate.orm", "hibernate-platform").versionRef("hibernate.bom")
            library("cloudnet.bom", "eu.cloudnetservice.cloudnet", "bom").versionRef("cloudnet.bom")

            library("postgresql", "org.postgresql", "postgresql").versionRef("postgresql")
            library("h2", "com.h2database", "h2").versionRef("h2")

            library("jaxb.runtime", "org.glassfish.jaxb", "jaxb-runtime").versionRef("jaxb")
            library("jaxb.impl", "com.sun.xml.bind", "jaxb-impl").versionRef("jaxb")

            library("google.service", "com.google.auto.service", "auto-service").versionRef("google.autovalue")
            library("rabbitmq", "com.rabbitmq", "amqp-client").versionRef("rabbitmq")

            library("commons.geometry.core", "org.apache.commons", "commons-geometry-core").versionRef("commons.geometry")
            library(
                "commons.geometry.euclidean",
                "org.apache.commons",
                "commons-geometry-euclidean"
            ).versionRef("commons.geometry")

            library(
                "commons.geometry.spherical",
                "org.apache.commons",
                "commons-geometry-spherical"
            ).versionRef("commons.geometry")
            library(
                "commons.geometry.parent",
                "org.apache.commons",
                "commons-geometry-parent"
            ).versionRef("commons.geometry")

            library("common.io", "commons-io", "commons-io").versionRef("common.io")
            library("zt.zip", "org.zeroturnaround", "zt-zip").versionRef("zt.zip")
            library("caffeine", "com.github.ben-manes.caffeine", "caffeine").versionRef("caffeine")
            library("world.seed.engine", "net.worldseed.multipart", "WorldSeedEntityEngine").versionRef("worldSeed")

            bundle(
                "geometry.full", listOf(
                    "commons.geometry.core",
                    "commons.geometry.euclidean",
                    "commons.geometry.spherical",
                    "commons.geometry.parent"
                )
            )

            bundle(
                "geometry.game", listOf(
                    "commons.geometry.core",
                    "commons.geometry.euclidean",
                )
            )

            bundle(
                "jaxb", listOf(
                    "jaxb.runtime",
                    "jaxb.impl"
                )
            )

            plugin("cyclonedx", "org.cyclonedx.bom").versionRef("cyclonedx")
        }
    }
}