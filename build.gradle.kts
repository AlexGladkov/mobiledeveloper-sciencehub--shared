buildscript {
    val kotlin_version by extra("1.4.31")
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.0")
        classpath(kotlin("gradle-plugin", version = kotlin_version))
        classpath(kotlin("serialization", version = kotlin_version))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}