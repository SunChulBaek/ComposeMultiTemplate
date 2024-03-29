import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import kr.pe.ssun.template.configureKotlinAndroid
import kr.pe.ssun.template.configurePrintApksTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.io.FileInputStream
import java.util.*

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val propFile = file(rootProject.file("build.properties"))
            val properties = Properties().apply { load(FileInputStream(propFile))}

            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)

                defaultConfig.applicationId = "com.example.androidtemplate"
                defaultConfig.targetSdk = 34
                defaultConfig.versionCode = properties.getProperty("versionCode").toInt()
                defaultConfig.versionName = properties.getProperty("versionName")

                signingConfigs {
                    create("release") {
                        val keystorePropFile = rootProject.file("keystore.properties")
                        val keystoreProperties = Properties().apply {
                            if (keystorePropFile.exists()) {
                                load(FileInputStream(keystorePropFile))
                            }
                        }
                        val path = keystoreProperties.getProperty("releaseKeyStore")
                        if (path != null) {
                            keyAlias = keystoreProperties.getProperty("releaseKeyAlias")
                            keyPassword = keystoreProperties.getProperty("releaseKeyPassword")
                            storeFile = rootProject.file(keystoreProperties.getProperty("releaseKeyStore"))
                            storePassword = keystoreProperties.getProperty("releaseStorePassword")
                        }
                    }
                }

                buildTypes {
                    getByName("debug") {
                        isDebuggable = true
                    }
                    getByName("release") {
                        signingConfig = signingConfigs.getByName("release")
                        isMinifyEnabled = false
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    }
                }
            }
            extensions.configure<ApplicationAndroidComponentsExtension> {
                configurePrintApksTask(this)
            }
        }
    }
}