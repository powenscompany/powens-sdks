plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.library)
    alias(libs.plugins.openApi.generator)
    alias(libs.plugins.kotlin.cocoapods)
}

openApiGenerate {
    inputSpec.set("$projectDir/specs/powens-api.yml")
    outputDir.set("$projectDir/generated")
    generatorName.set("kotlin")
    library.set("multiplatform")
    apiPackage.set("com.powens.api.client.services")
    modelPackage.set("com.powens.api.model")
    packageName.set("com.powens.api")
    configFile.set("$projectDir/generator-config.yml")
}

openApiValidate {
    inputSpec.set("$projectDir/specs/powens-api.yml")
}

// Configure the whole spec dir for invalidation of the generator cache
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
        summary = "Client for Powens APIs"
        homepage = "powens.com"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "PowensApiClient"
        }
    }

}

android {
    namespace = "com.powens.api.client"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
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
