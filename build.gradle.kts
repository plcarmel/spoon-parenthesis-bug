import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
    application
}

repositories {
    mavenCentral()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("fr.inria.gforge.spoon:spoon-core:10.0.1-beta-1")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.14.1")
}

application {
    mainClass.set("org.example.MainKt")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "11"
