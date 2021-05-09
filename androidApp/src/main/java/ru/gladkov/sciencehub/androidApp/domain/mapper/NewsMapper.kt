package ru.gladkov.sciencehub.androidApp.domain.mapper

import ru.gladkov.sciencehub.androidApp.domain.models.HubbleNew
import ru.gladkov.sciencehub.shared.features.hubble.ktor.models.KtorHubbleResponse

class NewsMapper : Mapper<KtorHubbleResponse, HubbleNew> {
    override fun transform(data: KtorHubbleResponse) = HubbleNew(data.newsId, data.newsName)
}
