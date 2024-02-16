
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.openApi.generator)
    alias(libs.plugins.kotlin.cocoapods)
}

openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set("$projectDir/specs/api-schema.yml")
    outputDir.set("$projectDir/generated")
    apiPackage.set("com.powens.api.client")
    modelPackage.set("com.powens.api.model")
    library.set("multiplatform")
    instantiationTypes.set(mapOf(
        "map" to "AdditionalProperties"
        //"LocalDate" to "kotlinx.datetime.LocalDate"
    ))
    importMappings.set(mapOf(
        "LocalDate" to "kotlinx.datetime.LocalDate",
        "Int" to "kotlin.Int",
        "Long" to "kotlin.Long",
    ))
    typeMappings.set(mapOf(
        "map" to "AdditionalProperties",
        "date" to "LocalDate",
        "number+int64" to "Long",
        "number+int32" to "Int",
        "number+monetary" to "BigDecimal"
    ))
    configOptions.set(mapOf(
        "dateLibrary" to "kotlinx-datetime",
        "omitGradlePluginVersions" to "true",
        "omitGradleWrapper" to "true"
    ))
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
    
    sourceSets {
        commonMain.dependencies {
            implementation(projects.apiClient.generated)
        }
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
