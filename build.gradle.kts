import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0" apply false
}

group = "com.brobert"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}
apply(plugin = "org.jlleitschuh.gradle.ktlint")
dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // logging
    implementation("io.github.microutils:kotlin-logging:1.7.2")
    implementation("net.logstash.logback:logstash-logback-encoder:5.2")

    // jpa
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.hibernate:hibernate-envers")
//    implementation("org.hibernate:hibernate-jcache")
    // runtimeOnly("org.ehcache:ehcache")
    // implementation("org.flywaydb:flyway-core")
//    runtimeOnly("org.postgresql:postgresql")
//    testRuntimeOnly("com.h2database:h2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// removes -plain.jar from build output
tasks.getByName<Jar>("jar") {
    enabled = false
}
