import org.gradle.jvm.tasks.Jar

plugins {
    kotlin("jvm") version "1.3.72"
}

group = "com.github.shk0da.ib"
version = "0.1.2"

repositories {
    mavenCentral()
}

apply(plugin = "maven")

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

val allowedLibs = listOf("TwsApi.jar")
val richJar = task("richJar", type = Jar::class) {
    from(configurations.runtimeClasspath.get()
        .filter { allowedLibs.contains(it.name) }
        .map({ if (it.isDirectory) it else zipTree(it) })
    )
    with(tasks.jar.get() as CopySpec)
}

tasks {
    "build" {
        dependsOn(richJar)
    }
}