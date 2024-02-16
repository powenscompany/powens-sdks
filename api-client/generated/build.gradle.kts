
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    jvm()

    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "PowensApiGeneratedClient"
            isStatic = true
        }
    }

    /*js {
        browser()
        nodejs()
    }*/

    sourceSets {

        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlinx.serialization.core)

            api(libs.ktor.client.core)
            api(libs.ktor.client.contentNegotiation)
            api(libs.ktor.client.serialization)
            api(libs.ktor.serialization.kotlinxJson)
            api(libs.kotlinx.datetime)
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
