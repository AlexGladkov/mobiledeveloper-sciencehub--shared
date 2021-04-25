package ru.gladkov.sciencehub.shared.features.hubble.ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorHubbleResponse(
    @SerialName("news_id") val newsId: String,
    @SerialName("name") val newsName: String
)