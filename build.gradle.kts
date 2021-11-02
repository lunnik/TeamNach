// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {

    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        classpath(Dependencies.SAFE_ARGS)
    }

}


allprojects {
    repositories {
        google()
        jcenter()

    }
}


tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}