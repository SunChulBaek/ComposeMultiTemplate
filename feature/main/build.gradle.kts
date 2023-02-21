plugins {
    id("kr.pe.ssun.feature")
    id("kr.pe.ssun.library.compose")
}

android {
    namespace = "kr.pe.ssun.template.feature.main"
}

dependencies {
    implementation(libs.androidx.compose.material3.windowSizeClass)
}