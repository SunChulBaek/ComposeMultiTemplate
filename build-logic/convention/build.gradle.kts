/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    `kotlin-dsl`
}

group = "kr.pe.ssun.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        val baseId = "kr.pe.ssun"
        register("androidApplicationCompose") {
            id = "${baseId}.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "${baseId}.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
//        register("androidApplicationJacoco") {
//            id = "${baseId}.application.jacoco"
//            implementationClass = "AndroidApplicationJacocoConventionPlugin"
//        }
        register("androidLibraryCompose") {
            id = "${baseId}.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "${baseId}.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "${baseId}.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
//        register("androidLibraryJacoco") {
//            id = "${baseId}.library.jacoco"
//            implementationClass = "AndroidLibraryJacocoConventionPlugin"
//        }
//        register("androidTest") {
//            id = "${baseId}.test"
//            implementationClass = "AndroidTestConventionPlugin"
//        }
        register("androidHilt") {
            id = "${baseId}.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
//        register("firebase-perf") {
//            id = "${baseId}.firebase-perf"
//            implementationClass = "FirebasePerfConventionPlugin"
//        }
    }
}