plugins {
    id("kr.pe.ssun.library")
    kotlin("kapt")
}

android {
    namespace = "kr.pe.ssun.template.core.domain"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}