import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.openApi.generator)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.touchlab.skie)
    `maven-publish`
}

openApiGenerate {
    inputSpec.set("$projectDir/specs/powens-api.yml")
    outputDir.set("$projectDir/openapi-generated")
    generatorName.set("kotlin")
    library.set("multiplatform")
    packageName.set("com.powens.sdk")
    modelPackage.set("com.powens.sdk.model")
    apiPackage.set("com.powens.sdk.client.services")
    configFile.set("$projectDir/openapi-generator-config.yml")
    ignoreFileOverride.set("$projectDir/.openapi-generator-ignore")
}

openApiValidate {
    inputSpec.set("$projectDir/specs/powens-api.yml")
}

// Configure invalidation (inputs) of the OpenApi generator tasks
tasks.withType(org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class.java) {
    inputs.file("$projectDir/openapi-generator-config.yml")
    inputs.file("$projectDir/.openapi-generator-ignore")
    inputs.dir("$projectDir/specs")
}
tasks.withType(org.openapitools.generator.gradle.plugin.tasks.ValidateTask::class.java) {
    inputs.dir("$projectDir/specs")
}

kotlin {

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
            freeCompilerArgs.addAll(
                "-P",
                "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=com.powens.sdk.infrastructure.Parcelize"
            )
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
            it.get().kotlin.srcDir("openapi-generated/src/${it.name}/kotlin")
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
            implementation(libs.ktor.client.okhttp)
            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.browser)
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
        name = "PowensConnect"
        summary = "Ready-made tools to connect with Powens APIs and easily implement aggregation journeys"
        version = "1.0.0-beta"
        authors = "Powens"
        homepage = "https://www.powens.com"
        source = "{ :git => 'https://github.com/powenscompany/powens-connect-ios.git', :tag => '$version' }"
        license = "{ :type => 'LGPLv3' }"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "PowensConnect"
        }
    }

}

android {

    namespace = "com.powens.sdk"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        manifestPlaceholders["powensDomain"] = "\${powensDomain}"
        manifestPlaceholders["powensClientId"] = "\${powensClientId}"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    dependencies {
        debugImplementation(compose.uiTooling)
    }

}

composeCompiler {
    targetKotlinPlatforms = setOf(KotlinPlatformType.androidJvm)
}

publishing {
    publications {
        create("release", MavenPublication::class.java) {
            groupId = "com.powens"
            artifactId = "powens-connect"
            version = "1.0.0-beta"
            afterEvaluate { from(components["release"]) }
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