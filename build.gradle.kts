plugins {
    id("io.datalbry.connector.sdk") version "0.0.31"
    idea
}

repositories {
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/space/maven") }
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
    mavenCentral()
}

tasks.withType<Test> {
    environment["sample-api-uri"] =  properties["datalbry.sample.api.uri"]
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(libs.datalbry.client.sample.api)
}

group = "io.datalbry.connector"