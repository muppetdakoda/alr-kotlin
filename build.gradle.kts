import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jvmTarget = "1.8"
val valiktorVersion = "0.5.0"
val junitVersion = "5.3.1"
val assertJVersion = "3.11.1"
val dassertVersion = "1.0.1"

plugins {
    kotlin("jvm") version "1.3.31"
    java
    jacoco
    id("org.springframework.boot") version "2.0.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

group = "com.dakoda"
version = "0.0"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://jitpack.io")
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.valiktor", "valiktor-core", valiktorVersion)
    implementation("com.github.dakodabutnot", "dassert", dassertVersion)
    implementation("org.springframework.boot", "spring-boot-dependencies", "2.0.5.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("org.hsqldb:hsqldb")

    testImplementation("org.assertj", "assertj-core", assertJVersion)
    testImplementation("org.junit.jupiter", "junit-jupiter-api", junitVersion)
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", junitVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = jvmTarget
}

tasks {

    test {
        finalizedBy(jacocoTestReport)
        useJUnitPlatform { }
    }

    jacocoTestReport {
        reports {
            xml.isEnabled = false
            csv.isEnabled = false
            html.isEnabled = true
            html.destination = file("$buildDir/coverage")
        }
    }
}