package deps

object Compilers {
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"


    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_android_lifecycle_compiler =
        "androidx.hilt:hilt-compiler:${Versions.hiltAndroidXCompiler}"
}