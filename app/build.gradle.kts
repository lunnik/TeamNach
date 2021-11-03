
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(DefaultConfig.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(DefaultConfig.MIN_ANDROID_SDK)
        targetSdkVersion(DefaultConfig.TARGET_ANDROID_SDK)
        buildToolsVersion(DefaultConfig.BUILD_TOOLS_VERSION)
        applicationId = App.APPLICATION_ID
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        configurations.all {
            resolutionStrategy {
                this.force(Dependencies.CORE_KTX)
            }
        }
    }

    flavorDimensions(App.DIMENSION)
    productFlavors {
        create("develop") {
            applicationId = "com.example.grueponach"
            versionNameSuffix = "-develop"
            dimension = App.DIMENSION
            buildConfigField(
                "String",
                "API_BASE_URL",
                "\"https://api.themoviedb.org/3/\""
            )
        }
    }

    buildTypes {
        getByName("debug") {
            minifyEnabled(false)
        }

        getByName("release") {
            minifyEnabled(true)
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }


}

dependencies {

    implementation(fileTree("libs") { include(listOf("*.jar")) })
    implementation(Dependencies.JET_BRAINS_KOTLIN)
    /* ANDROID X */
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.LEGACY_SUPPORT)
    /* DEBUG */
    implementation(Dependencies.TIMBER)
    /* RETROFIT */
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.GSON_CONVERTER)
    implementation(Dependencies.RETROFIT_INTERCEPTOR)
    /* MOSHI */
    implementation(Dependencies.MOSHI_KOTLIN)
    implementation(Dependencies.MOSHI_CONVERTER)
    implementation(Dependencies.MOSHI_CODEGEN)
    /* ROOM */
    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.ROOM_KTX)
    kapt(Dependencies.ROOM_COMPILER)
    /* GOOGLE */
    implementation(Dependencies.MATERIAL_COMPONENTS)
    /* KOIN */
    implementation(Dependencies.KOIN)
    /* GLIDE */
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_LIFECYCLE_COMPILER)
    kapt(Dependencies.GLIDE_COMPILER)
    /* Lifecycle */
    implementation(Dependencies.LIFECYCLE_LIVE_DATA)
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEW_MODEL)
    /* COROUTINES */
    api(Dependencies.COROUTINES_CORE)
    api(Dependencies.COROUTINES_ANDROID)



    /* TESTING */
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.TEST_JUNIT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
    /* MODULE */
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.NETWORK))
    implementation(project(Modules.DATA_SOURCE))
    implementation(project(Modules.MOVIE))
    /* EXTERNAL*/
    implementation(Dependencies.EASY_PREFS)

}
