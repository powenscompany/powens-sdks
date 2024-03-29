plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.cocoapods)
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
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Powens UI Kit"
        homepage = "powens.com"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "PowensUIKit"
        }
    }
    
    sourceSets {

        commonMain.dependencies {
            implementation(projects.apiClient)
        }

        androidMain.dependencies {
            implementation(project.dependencies.platform(libs.androidx.compose.bom))
            implementation(libs.androidx.browser)
            implementation(libs.androidx.compose.material3)
            implementation(libs.androidx.compose.ui)
            implementation(libs.androidx.compose.uiTooling.preview)
            implementation(libs.androidx.activity.compose)
        }

    }
}

android {
    namespace = "com.powens.kit"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    with (sourceSets["main"]) {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
        resources.srcDirs("src/commonMain/resources")
    }

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
        debugImplementation(libs.androidx.compose.uiTooling)
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