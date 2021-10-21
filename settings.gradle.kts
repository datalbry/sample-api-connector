enableFeaturePreview("VERSION_CATALOGS")
rootProject.name = "sample-api-connector"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "io.datalbry.connector.sdk") {
                useModule("io.datalbry.connector:connector-sdk-plugin:${requested.version}")
            }
        }
    }
}