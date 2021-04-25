package ru.gladkov.sciencehub.shared.features.hubble

import ru.gladkov.sciencehub.shared.features.hubble.ktor.models.KtorHubbleResponse

interface HubbleRemoteDataSource {
    suspend fun fetchNews(): List<KtorHubbleResponse>
}