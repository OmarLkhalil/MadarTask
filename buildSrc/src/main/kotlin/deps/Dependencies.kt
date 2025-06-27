package deps


object Dependencies {

    // Kotlin & Core
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val kotlin_metadata = "org.jetbrains.kotlin:kotlin-metadata:${Versions.meta_data}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    // Coroutines
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutine_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutine_adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"
    const val kotlin_coroutines_play_services = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesPlayServices}"

    // Dagger / Hilt
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_navigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
    const val hilt_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"

    // Navigation
    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_runtime = "androidx.navigation:navigation-runtime:${Versions.navigation}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigation_dynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    const val navigation_compose = "androidx.navigation:navigation-compose:${Versions.navigation}"

    // UI Components
    const val app_compat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val ui_graphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val compose_material = "androidx.compose.material:material:${Versions.compose}"
    const val material3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val compose_runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val compose_compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val work_runtime = "androidx.work:work-runtime-ktx:${Versions.work}"
    const val view_model = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // Room & DataStore
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val datastore = "androidx.datastore:datastore-core:${Versions.dataStore}"
    const val datastore_preferences = "androidx.datastore:datastore-preferences:${Versions.dataStore}"

    // ProtoBuf
    const val protoBufJavaLite = "com.google.protobuf:protobuf-javalite:${Versions.protoBuf}"
    const val protoBufKotlinLite = "com.google.protobuf:protobuf-kotlin-lite:${Versions.protoBuf}"

    // Network - Retrofit / OkHttp / Moshi / GSON
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi_kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val logging_interceptor = "com.github.ihsanbal:LoggingInterceptor:${Versions.loggingInterceptor}"

    // Firebase
    const val firebase_core = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    const val firebase_auth = "com.google.android.gms:play-services-auth:${Versions.firebaseAuth}"
    const val firebase_analytics = "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"
    const val firebase_crashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"
    const val firebase_messaging = "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"
    const val firebase_iid = "com.google.firebase:firebase-iid:21.1.0" // no version in your Versions.kt — left as-is

    // Lifecycle
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    // Material Dialogs
    const val material_dialogs = "com.afollestad.material-dialogs:core:${Versions.materialDialogs}"
    const val material_dialogs_input = "com.afollestad.material-dialogs:input:${Versions.materialDialogs}"

    // Chucker
    const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    // Serialization / Collections
    const val kotlin_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    const val kotlin_collections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.kotlinCollections}"

    // RxJava
    const val rxjava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}"
    const val reactivestreams = "android.arch.lifecycle:reactivestreams:${Versions.reactivestreams}"
    const val retrofit_adapter_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxJava2Adapter}"

    // Google Services & Maps
    const val play_core = "com.google.android.play:core:${Versions.playCore}"
    const val android_service_map = "com.google.android.gms:play-services-maps:17.0.0"
    const val service_map = "com.google.maps:google-maps-services:0.1.20"
    const val service_location = "com.google.android.gms:play-services-location:18.0.0"
    const val service_places = "com.google.android.gms:play-services-places:17.0.0"
    const val google_places = "com.google.android.libraries.places:places:2.5.0"

    // Logging & Tools
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val google_json = "com.googlecode.json-simple:json-simple:1.1.1"
    const val leak_canary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val markdown_processor = "com.yydcdut:markdown-processor:${Versions.markdownProcessor}"

    // UI Extras
    const val indicator = "com.tbuonomo:dotsindicator:4.2"
    const val circle_indicator = "me.relex:circleindicator:2.1.6"
    const val circle_image = "de.hdodenhof:circleimageview:${Versions.circleImage}"
}
