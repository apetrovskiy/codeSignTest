/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.6.1/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    `java-library`

    // Apply the application plugin to add support for building a CLI application.
    application

//    kotlin("multiplatform") version "1.4.10"
    kotlin("jvm") version "1.4.10"
}

/*
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}*/

tasks.withType<JavaCompile>().configureEach {
    javaCompiler.set(javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(11))
    })
}

tasks.withType<Test>().configureEach {
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(14))
    })
}

sourceSets.main {
    java.srcDirs("src/main/java")
}

sourceSets.test {
    java.srcDirs("src/test/java")
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")

    implementation("org.clojure:clojure:1.10.2-alpha4")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-test
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.20")

    // https://mvnrepository.com/artifact/org.junit.vintage/junit-vintage-engine
    testImplementation("org.junit.vintage:junit-vintage-engine:5.7.0")

    // https://mvnrepository.com/artifact/org.junit.platform/junit-platform-runner
    testImplementation("org.junit.platform:junit-platform-runner:1.7.0")

    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.1")
}

application {
    // Define the main class for the application.
    mainClassName = "testCodi.App"
}

val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "6.7.1"
    distributionType = Wrapper.DistributionType.ALL
}