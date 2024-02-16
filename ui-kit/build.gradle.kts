import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.parcelize)
    `maven-publish`
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    sourceSets {

        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.androidx.compose.bom))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(libs.androidx.browser)
            implementation(projects.apiClient)
        }

        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs.androidx.compose.uiTooling.preview)
            implementation(libs.androidx.activity.compose)
        }

    }
}

android {
    namespace = "com.powens.kit"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        manifestPlaceholders["powensDomain"] = "\${powensDomain}"
        manifestPlaceholders["powensClientId"] = "\${powensClientId}"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
    publishing {
        singleVariant("release")
    }
}

publishing {
    publications {
        create("release", MavenPublication::class.java) {
            groupId = "com.powens"
            artifactId = "sdk"
            version = "1.0-alpha1"
            afterEvaluate { from(components["release"]) }
        }
    }
}