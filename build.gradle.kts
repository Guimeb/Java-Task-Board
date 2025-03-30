plugins {
    java
    application
}

group = "br.com.dio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("com.h2database:h2:2.2.220")
    implementation("org.liquibase:liquibase-core:4.29.1")
    implementation("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

application {
    mainClass.set("br.com.dio.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}
