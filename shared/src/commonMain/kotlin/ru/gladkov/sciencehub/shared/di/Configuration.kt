package ru.gladkov.sciencehub.shared.di

data class Configuration(val platformType: PlatformType)

sealed class PlatformType {
    data class iOS(val version: String, val buildNumber: String): PlatformType()
    data class Android(val version: String, val buildNumber: String): PlatformType()
}