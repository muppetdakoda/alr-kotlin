import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jvmTarget = "1.8"
val valiktorVersion = "0.5.0"
val junitVersion = "5.3.1"
val assertJVersion = "3.11.1"
val dassertVersion = "1.1.0-SNAP"

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.31"
    id("org.gradle.java")
    id("org.gradle.jacoco")
    id("org.springframework.boot") version "2.2.0.RELEASE"

    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.31"
}

apply(plugin = "io.spring.dependency-management")

group = "dev.dakoda"
version = "0.0"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://jitpack.io")
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    // Helper libraries
    implementation("au.com.console:kassava:1.0.0")
    implementation("org.valiktor:valiktor-core:$valiktorVersion")

    // Dependency Injection
    implementation("org.springframework.boot:spring-boot-dependencies:2.0.5.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // External frameworks
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.+")
    runtimeOnly("org.hsqldb:hsqldb")

    // - TESTING -

    // Assertions
    testImplementation("com.github.dakodabutnot:dassert:$dassertVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    // Mocking
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("com.ninja-squad:springmockk:1.1.3") {
        exclude(module = "mockito-core")
    }

    // Testing lifecycle
    implementation("io.cucumber:cucumber-spring:4.7.4")
    testImplementation("io.cucumber:cucumber-java8:4.7.4")
    testImplementation("io.cucumber:cucumber-junit:4.7.4")

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
        this@jacocoTestReport.classDirectories.setFrom(
            sourceSets.main.get().output.asFileTree.matching {
                exclude("dev/dakoda/alr/*.*")
            }
        )
    }
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
}