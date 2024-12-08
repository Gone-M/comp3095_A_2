plugins {
    java
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "ca.gbc"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation ("org.springframework.kafka:spring-kafka")
    implementation ("io.confluent:kafka-avro-serializer:7.0.1")
    implementation ("org.springframework.cloud:spring-cloud-stream-binder-kafka")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation ("org.apache.avro:avro:1.11.2")
    implementation ("io.confluent:kafka-avro-serializer:7.5.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
