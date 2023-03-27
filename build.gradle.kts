import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "me.rodrigotroy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10");
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {

    //set the kotlin compiler version 17
    kotlinOptions.jvmTarget = "17"

}

application {
    mainClass.set("MainKt")
}
