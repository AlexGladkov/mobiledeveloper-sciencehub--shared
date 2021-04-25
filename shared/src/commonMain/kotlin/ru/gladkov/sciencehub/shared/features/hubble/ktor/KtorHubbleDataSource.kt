package ru.gladkov.sciencehub.shared.features.hubble.ktor

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.delay
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import ru.gladkov.sciencehub.shared.features.hubble.HubbleRemoteDataSource
import ru.gladkov.sciencehub.shared.features.hubble.ktor.models.KtorHubbleResponse

class KtorHubbleDataSource(
    private val httpClient: HttpClient,
    val json: Json
): HubbleRemoteDataSource {

    override suspend fun fetchNews(): List<KtorHubbleResponse> {
        val httpRequest = httpClient.get<HttpStatement> {
            url {
                path("/api/v3/news")
            }
        }

        return json.decodeFromString(
            ListSerializer(KtorHubbleResponse.serializer()),
            httpRequest.execute().readText()
        )
    }
}