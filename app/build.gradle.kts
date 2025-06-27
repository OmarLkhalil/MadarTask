import extensions.androidx
import extensions.dataStore
import extensions.kotlinx
import extensions.room
import extensions.hilt
import extensions.presentationModule
import extensions.dataModule
import extensions.domainModule
import extensions.testImplDeps
import extensions.testDeps
import extensions.helpers


plugins {
    id(plugs.BuildPlugins.KOTLIN_ANDROID)
    id(plugs.BuildPlugins.ANDROID_APPLICATION)
    id(plugs.BuildPlugins.KAPT)
    id(plugs.BuildPlugins.HILT) version deps.Versions.hilt
}

android {
    namespace = build.ApplicationId.id
    compileSdk = deps.Versions.compileSdk

    defaultConfig {
        applicationId = build.ApplicationId.id
        minSdk = deps.Versions.minSdk
        targetSdk = deps.Versions.targetSdk
        versionCode = deps.Versions.versionCode
        versionName = deps.Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module("org.hamcrest:hamcrest-core:1.3")).using(module("junit:junit:4.13.2"))
        }
        resolutionStrategy{
            force("com.squareup:javapoet:1.13.0")
        }
    }
    configurations {
        all {
            exclude(group = "org.hamcrest", module = "hamcrest-core")
            resolutionStrategy {
                force("com.squareup:javapoet:1.13.0")
            }
        }
    }
    hilt {
        enableAggregatingTask = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin{
        jvmToolchain(deps.Versions.java.toInt())
    }
    kotlinOptions {
        jvmTarget = deps.Versions.java
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    // DataStore
    dataStore()

    // Room
    room()

    // KotlinX
    kotlinx()

    // AndroidX
    androidx()

    // Hilt
    hilt()

    // helpers
    helpers()

    // Modules
    presentationModule()
    dataModule()
    domainModule()

    // Test dependencies
    testDeps()
    testImplDeps()

}