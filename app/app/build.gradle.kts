import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    kotlin("plugin.serialization") version "2.3.0"

    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "ah.lada"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "ah.lada"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlin {
        // note about this syntax
        // this is called "lambda with receiver"
        // its like "sugar" syntax for Action<T> in dotnet
        // signature is T.() -> TRetVal
        // then the caller function can use the "lambda"
        // and apply it to T
        // example:
        // compilerOption( someAction: Option.() -> Unit) {
        //  var defaultOption = Option.Default()
        //  defaultOption.someAction() // <-- this will apply function to default option
        //  // then use defaultOption
        // }
        //
        // that is really same with Action<T> in dotnet
        // but in different syntax
        compilerOptions {
            this.jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    buildFeatures {
        compose = true
    }

    tasks.withType<Test> {
        testLogging {
            showStandardStreams = true
            events("PASSED", "SKIPPED", "FAILED") 
        }
    }
}

dependencies {
    val roomVersion = "2.8.4"
    val hiltVersion = "2.57.2"
    val navigationVersion = "2.9.6"
    val hiltCompilerVersion = "1.3.0"

    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    testImplementation("androidx.room:room-testing:$roomVersion")

    //Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")
    ksp("androidx.hilt:hilt-compiler:$hiltCompilerVersion")

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$navigationVersion")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment:$navigationVersion")
    implementation("androidx.navigation:navigation-ui:$navigationVersion")

    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navigationVersion")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$navigationVersion")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.kotlinx.serialization)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

}
