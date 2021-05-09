package ru.gladkov.sciencehub.shared.features.hubble.ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorHubbleNewDetailsResponse(
    @SerialName("abstract")
    val description: String?,
    @SerialName("credits")
    val credits: String?,
    @SerialName("keystone_image_1x")
    val keystoneImage1x: String?,
    @SerialName("keystone_image_2x")
    val keystoneImage2x: String?,
    @SerialName("mission")
    val mission: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("news_id")
    val newsId: String?,
    @SerialName("publication")
    val publication: String?,
    @SerialName("release_images")
    val releaseImages: List<Int>?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("thumbnail_1x")
    val thumbnail1x: String?,
    @SerialName("thumbnail_2x")
    val thumbnail2x: String?,
    @SerialName("thumbnail_retina")
    val thumbnailRetina: String?,
    @SerialName("url")
    val url: String?
)