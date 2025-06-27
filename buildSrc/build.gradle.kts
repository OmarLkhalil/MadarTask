import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://jitpack.io")

}
dependencies {
    api(kotlin("gradle-plugin:2.0.0"))
    implementation("com.android.tools.build:gradle:8.7.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")

}