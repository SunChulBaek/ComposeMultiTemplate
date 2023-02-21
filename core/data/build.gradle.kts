plugins {
    id("kr.pe.ssun.library")
    id("kr.pe.ssun.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "kr.pe.ssun.template.core.data"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
//    implementation(project(":core:database"))
//    implementation(project(":core:datastore"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
}