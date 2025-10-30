// Root-level build.gradle.kts

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false

    // Hilt plugin declaration with version
    id("com.google.dagger.hilt.android") version "2.57.1" apply false
}