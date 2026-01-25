// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // ==================== Build Plugins ====================
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.ksp) apply false

    // ==================== Kotlin Plugins ====================
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}