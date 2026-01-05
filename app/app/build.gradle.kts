import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "2.3.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.kotlinx.serialization)

    // https://github.com/realm/realm-kotlin/tree/main?tab=readme-ov-file#installation
    implementation("io.realm.kotlin:library-base:1.16.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

}
