plugins {
    kotlin("jvm") version "1.9.22" apply false
    id("org.springframework.boot") version "3.4.4" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
}

allprojects {
    group = "com.unizone"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}