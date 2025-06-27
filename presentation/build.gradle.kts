//import extensions.testImplDeps
import extensions.domainModule
import extensions.hilt
import extensions.kotlinx
import extensions.testDeps
import extensions.testImplDeps
import extensions.androidx

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
    id(plugs.BuildPlugins.KOTLIN_ANDROID)
    id(plugs.BuildPlugins.KAPT)
    id(plugs.BuildPlugins.HILT) version deps.Versions.hilt
}


android {
    namespace = build.ApplicationId.presentation
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
    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module("org.hamcrest:hamcrest-core:1.3")).using(module("junit:junit:4.13.2"))
        }
    }
}

dependencies {
    // Coroutines etc
    kotlinx()

    // Hilt ViewModel injection
    hilt()

    // Domain dependency
    domainModule()

    // android x
    androidx()


    // Test dependencies
    testDeps()
    testImplDeps()
}
