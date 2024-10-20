plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21"
    id("com.github.ben-manes.versions") version "0.51.0"
}

group = "com.rodrigotroy"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("ch.qos.logback:logback-classic:1.5.11")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:2.0.21")
    testImplementation("io.mockk:mockk:1.13.13")
}

tasks.test {
    useJUnitPlatform()
}

//https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
kotlin {
    jvmToolchain(17)
}
