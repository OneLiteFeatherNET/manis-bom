plugins {
    `maven-publish`
    `java-platform`
    alias(libs.plugins.cyclonedx)
}

group = "net.onelitefeather"
version = "0.1.0"

javaPlatform {
    allowDependencies()
}

dependencies {
    api(platform(libs.mycelium.bom))
    api(platform(libs.aonyx.bom))
    api(platform(libs.hibernate.bom))
    api(platform(libs.cloudnet.bom))
    constraints {
        api(libs.postgresql)
        api(libs.h2)
        api(libs.google.service)
        api(libs.rabbitmq)
        api(libs.common.io)
        api(libs.zt.zip)
        api(libs.caffeine)
        api(libs.world.seed.engine)
        api(libs.bundles.geometry.full)
        api(libs.bundles.geometry.game)
        api(libs.bundles.jaxb)
    }
}

publishing {
    repositories {
        maven {
            authentication {
                credentials(PasswordCredentials::class) {
                    username = System.getenv("ONELITEFEATHER_MAVEN_USERNAME")
                    password = System.getenv("ONELITEFEATHER_MAVEN_PASSWORD")
                }
            }
            name = "OneLiteFeatherRepository"
            url = if (project.version.toString().contains("SNAPSHOT")) {
                uri("https://repo.onelitefeather.dev/onelitefeather-snapshots")
            } else {
                uri("https://repo.onelitefeather.dev/onelitefeather-releases")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])
            pom {
                name.set("${project.name} ${project.version}")
                description.set("Bill of materials for the Aonyx project")
                developers {
                    developer {
                        name.set("OneliteFeather")
                        contributors {
                            contributor {
                                name.set("theEvilReaper")
                            }
                            contributor {
                                name.set("TheMeinerLP")
                            }
                        }
                    }
                }

                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/OneLiteFeatherNET/Aonyx-bom/issues")
                }
            }
        }
    }
}
