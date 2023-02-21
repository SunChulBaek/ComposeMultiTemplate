plugins {
    id("kr.pe.ssun.library")
    id("kr.pe.ssun.hilt")
}

android {
    namespace = "kr.pe.ssun.template.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}