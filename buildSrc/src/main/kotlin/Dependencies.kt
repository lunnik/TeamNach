/**
 *
 *
 */
object Dependencies {
    const val JET_BRAINS_KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:" + Versions.KOTLIN_VERSION

    const val APP_COMPAT = "androidx.appcompat:appcompat:" + Versions.KTX_VERSION
    const val CORE_KTX = "androidx.core:core-ktx:" + Versions.CORE_KTX_VERSION
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:" + Versions.CONSTRAINT_VERSION

    const val MATERIAL_COMPONENTS = "com.google.android.material:material:" + Versions.MATERIAL_COMPONENTS_VERSION
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:" + Versions.NAVIGATION_VERSION
    const val SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.NAVIGATION_VERSION
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:" + Versions.NAVIGATION_VERSION
    const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:" + Versions.LEGACY_SUPPORT_VERSION

    const val ROOM_COMPILER = "androidx.room:room-compiler:" + Versions.ROOM_VERSION
    const val ROOM_RUNTIME = "androidx.room:room-runtime:" + Versions.ROOM_VERSION
    const val ROOM_KTX = "androidx.room:room-ktx:" + Versions.ROOM_VERSION

    const val TIMBER = "com.jakewharton.timber:timber:" + Versions.TIMBER_VERSION

    /* KOIN */
    const val KOIN = "org.koin:koin-android-viewmodel:" + Versions.KOIN_VERSION

    /* GLIDE */
    const val GLIDE = "com.github.bumptech.glide:glide:" + Versions.GLIDE_VERSION
    const val GLIDE_LIFECYCLE_COMPILER = "android.arch.lifecycle:compiler:" + Versions.GLIDE_LIFE_CYCLE_COMPILER_VERSION
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:" + Versions.GLIDE_COMPILER_VERSION

    /* LIFECYCLE */
    const val LIFECYCLE_LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.LIFECYCLE_VERSION
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.LIFECYCLE_VERSION
    const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.LIFECYCLE_VERSION

    /* FIREBASE */
    const val FIREBASE_AUTH = "com.google.firebase:firebase-auth:" + Versions.FIREBASE_AUTH_VERSION
    const val FIREBASE_MESSAGING = "com.google.firebase:firebase-messaging:" + Versions.FIREBASE_MESSAGING_VERSION
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics:" + Versions.FIREBASE_CRASHLYTICS_VERSION
    const val FIREBASE_BASE = "com.google.android.gms:play-services-base:" + Versions.FIREBASE_BASE_VERSION
    const val FIREBASE_ML_VISION = "com.google.firebase:firebase-ml-vision:" + Versions.FIREBASE_ML_VISION_VERSION
    const val FIREBASE_ML_VISION_FACE = "com.google.firebase:firebase-ml-vision-face-model:" + Versions.FIREBASE_ML_VISION_FACE_VERSION

    /* RETROFIT */
    const val RETROFIT = "com.squareup.retrofit2:retrofit:" + Versions.RETROFIT_VERSION
    const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:" + Versions.RETROFIT_VERSION
    const val RETROFIT_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:" + Versions.RETROFIT_INTERCEPTOR_VERSION

    /* MOSHI */
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:" + Versions.MOSHI_KOTLIN_VERSION
    const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:" + Versions.MOSHI_CONVERTER_VERSION
    const val MOSHI_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:" + Versions.MOSHI_CODEGEN_VERSION

    /* COROUTINES */
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" + Versions.COROUTINES_CORE_VERSION
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.COROUTINES_ANDROID_VERSION
    const val COROUTINES_PLAY_SERVICE = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:" + Versions.COROUTINES_PLAY_SERVICES_VERSION

    /*TEST*/
    const val JUNIT = "junit:junit:" + Versions.JUNIT_VERSION
    const val TEST_JUNIT = "androidx.test.ext:junit:" + Versions.TEST_JUNIT_VERSION
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:" + Versions.ESPRESSO_CORE_VERSION

    /*EXTERNAL*/
    const val EASY_PREFS = "com.pixplicity.easyprefs:library:" + Versions.EASY_PREFS_VERSION


}
