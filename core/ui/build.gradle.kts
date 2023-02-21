plugins {
    id("kr.pe.ssun.library")
    id("kr.pe.ssun.library.compose")
}

android {
    namespace = "kr.pe.ssun.template.core.ui"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(project(":core:domain"))

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}