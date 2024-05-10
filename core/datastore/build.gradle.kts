plugins {
    id("kr.pe.ssun.library")
    id("kr.pe.ssun.hilt")
}

android {
    namespace = "kr.pe.ssun.template.core.datastore"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(libs.androidx.dataStore.preferences)
}