// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        val hiltVersion by extra("2.57.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    id("com.google.devtools.ksp") version "2.3.4" apply false
}