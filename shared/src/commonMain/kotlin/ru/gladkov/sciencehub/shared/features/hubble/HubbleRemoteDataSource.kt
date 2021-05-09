package ru.gladkov.sciencehub.shared.features.hubble

import ru.gladkov.sciencehub.shared.features.hubble.ktor.models.KtorHubbleNewDetailsResponse
import ru.gladkov.sciencehub.shared.features.hubble.ktor.models.KtorHubbleResponse

interface HubbleRemoteDataSource {
    suspend fun fetchNews(): List<KtorHubbleResponse>
    suspend fun getNew(newId: String): KtorHubbleNewDetailsResponse
}