plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.openApi.generator)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.touchlab.skie)
    `maven-publish`
}

openApiGenerate {
    inputSpec.set("$projectDir/specs/powens-api.yml")
    outputDir.set("$projectDir/generated")
    generatorName.set("kotlin")
    library.set("multiplatform")
    apiPackage.set("com.powens.sdk.client.services")
    modelPackage.set("com.powens.sdk.model")
    packageName.set("com.powens.sdk")
    configFile.set("$projectDir/generator-config.yml")
}

openApiValidate {
    inputSpec.set("$projectDir/specs/powens-api.yml")
}

// Configure the whole /spec dir for invalidation of the generator cache
tasks.withType(org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class.java) {
    inputs.dir("$projectDir/specs")
}
tasks.withType(org.openapitools.generator.gradle.plugin.tasks.ValidateTask::class.java) {
    inputs.dir("$projectDir/specs")
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    jvm()

    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "PowensApiClient"
            isStatic = true
        }
    }

    /*js {
        browser()
        nodejs()
    }*/
    
    sourceSets {

        // Register generated source folders
        listOf(commonMain/*, commonTest, iosTest, jsTest, jvmTest*/).forEach {
            it.get().kotlin.srcDir("generated/src/${it.name}/kotlin")
        }

        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.contentNegotiation)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.serialization.kotlinxJson)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlinx.serialization.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            api(libs.ktor.client.mock)
        }

        androidMain.dependencies {
            implementation(project.dependencies.platform(libs.androidx.compose.bom))
            implementation(libs.androidx.browser)
            implementation(libs.androidx.compose.material3)
            implementation(libs.androidx.compose.ui)
            implementation(libs.androidx.compose.uiTooling.preview)
            implementation(libs.androidx.activity.compose)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        jvmMain.dependencies {
            implementation(kotlin("stdlib-jdk7"))
            implementation(libs.ktor.client.cio.jvm)
        }

        jvmTest.dependencies {
            implementation(kotlin("test-junit"))
        }

        /*jsMain.dependencies {
            implementation(libs.ktor.client.js)
        }

        jsTest*/

        /*all {
            languageSettings.apply {
                optIn("kotlin.Experimental")
            }
        }*/
    }

    cocoapods {
        summary = "SDK for Powens APIs"
        homepage = "powens.com"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "PowensSDK"
        }
    }

}

android {
    namespace = "com.powens.sdk"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    with (sourceSets["main"]) {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        //res.srcDirs("src/androidMain/res")
        //resources.srcDirs("src/commonMain/resources")
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        manifestPlaceholders["powensDomain"] = "\${powensDomain}"
        manifestPlaceholders["powensClientId"] = "\${powensClientId}"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compilerExtension.get()
    }
    dependencies {
        debugImplementation(libs.androidx.compose.uiTooling)
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

/*tasks {
    register("iosTest") {
        val device = project.findProperty("device")?.toString() ?: "iPhone 8"
        dependsOn("linkDebugTestIosX64")
        group = JavaBasePlugin.VERIFICATION_GROUP
        description = "Execute unit tests on ${device} simulator"
        doLast {
            val binary = kotlin.targets.getByName<KotlinNativeTarget>("iosX64").binaries.getTest("DEBUG")
            exec {
                commandLine("xcrun", "simctl", "spawn", device, binary.outputFile)
            }
        }
    }
    register("test") {
        dependsOn("allTests")
    }
}*/

publishing {
    publications {
        create("release", MavenPublication::class.java) {
            groupId = "com.powens"
            artifactId = "sdk"
            version = "1.0-beta1"
            afterEvaluate { from(components["release"]) }
        }
    }
}