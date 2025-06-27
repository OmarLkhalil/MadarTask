package extensions

import deps.Dependencies
import deps.SupportDependencies
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import test.TestDependencies

//import test.AndroidTestDependencies

//import test.TestDependencies


fun DependencyHandler.room() {
    implementation(Dependencies.room_ktx)
    implementation(Dependencies.room_runtime)
    kapt(Dependencies.room_compiler)
}

fun DependencyHandler.helpers(){
    implementation(SupportDependencies.constraintlayout)
    implementation(SupportDependencies.ssp_library)
    implementation(SupportDependencies.sdp_library)
}

fun DependencyHandler.dataStore() {
    implementation(Dependencies.datastore)
    implementation(Dependencies.kotlin_collections)
}

fun DependencyHandler.kotlinx() {
    implementation(Dependencies.kotlin_serialization)
}

fun DependencyHandler.protoDataStore() {
    implementation(Dependencies.datastore)
    implementation(Dependencies.protoBufJavaLite)
    implementation(Dependencies.protoBufKotlinLite)
}

//fun DependencyHandler.chucker() {
//    releaseImplementation(Dependencies.chuckerRelease)
//    debugImplementation(Dependencies.chuckerDebug)
//}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_converter_gson)
    implementation(Dependencies.coroutine_adapter)
}

fun DependencyHandler.okHttp() {
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttp_logging_interceptor)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hilt_android)
    kapt(Dependencies.hilt_compiler)
}

fun DependencyHandler.androidx() {
    implementation(Dependencies.core_ktx)
    implementation(Dependencies.multidex)
    implementation(Dependencies.kotlin_stdlib)
    implementation(Dependencies.lifecycle_runtime)
    implementation(Dependencies.ui)
    implementation(Dependencies.ui_graphics)
    implementation(Dependencies.ui_tooling_preview)
    implementation(Dependencies.material3)
    implementation(Dependencies.work_runtime)
    implementation(Dependencies.app_compat)
    implementation(Dependencies.view_model)
    implementation(Dependencies.material)
    implementation(Dependencies.navigation_fragment_ktx)
    implementation(Dependencies.google_json)
}


fun DependencyHandler.dataModule() {
    moduleImplementation(project(":data"))
}

fun DependencyHandler.domainModule() {
    moduleImplementation(project(":domain"))
}
fun DependencyHandler.presentationModule() {
    moduleImplementation(project(":presentation"))
}



//fun DependencyHandler.testImplDeps() {
//    testImplementation(AndroidTestDependencies.junit)
//    androidTestImplementation(Dependencies.junit_ext)
//    androidTestImplementation(Dependencies.espresso_core)
//    androidTestImplementation(Dependencies.compose_ui_test_junit4)
//    androidTestImplementation(Dependencies.compose_ui_test_manifest)
//    androidTestImplementation(Dependencies.compose_ui_tooling)
//    androidTestImplementation(Dependencies.compose_ui_test)
//    androidTestImplementation(Dependencies.hilt_testing)
//}


fun DependencyHandler.testDeps() {
    testImplementation(TestDependencies.ANDROIDX_JUNIT)
}

fun DependencyHandler.testImplDeps() {
    androidTestImplementation(TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_ESPRESSO_CORE)
}
