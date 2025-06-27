import extensions.kotlinx
import extensions.room
import extensions.hilt
import extensions.room
import extensions.dataStore
import extensions.domainModule
import extensions.testDeps
import extensions.testImplDeps
import org.gradle.kotlin.dsl.invoke

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
    id(plugs.BuildPlugins.KOTLIN_ANDROID)
    id(plugs.BuildPlugins.KAPT)
    id(plugs.BuildPlugins.HILT) version deps.Versions.hilt
}

android {
    namespace = build.ApplicationId.data
    compileSdk = deps.Versions.compileSdk

    defaultConfig {
        minSdk = deps.Versions.minSdk
        targetSdk = deps.Versions.compileSdk
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = deps.Versions.java
    }
    kotlin{
        jvmToolchain(deps.Versions.java.toInt())
    }
    kapt {
        arguments {
            arg("room.verifySchema", "false")
        }
    }

    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module("org.hamcrest:hamcrest-core:1.3")).using(module("junit:junit:4.13.2"))
        }
    }
}

dependencies {

    dataStore()

    // Dependency Injection
    hilt()

    // Kotlin coroutines, serialization
    kotlinx()

    // Domain dependency
    domainModule()

    // Room database
    room()

    // Test dependencies
    testDeps()
    testImplDeps()
}
