plugins {
    kotlin("jvm") version "1.3.72"
}

group = "com.github.shk0da.ib"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(files("libs/TwsApi.jar"))
    implementation("org.slf4j:jcl-over-slf4j:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}