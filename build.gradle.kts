plugins {
    kotlin("jvm") version "1.4.31"
}

group = "dev.hbrown"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testImplementation("io.strikt:strikt-core:0.29.0")
    testImplementation("com.christophsturm:filepeek:0.1.3") //used by strikt
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
    }
}
