package ru.gladkov.sciencehub.androidApp.domain.mapper

import ru.gladkov.sciencehub.androidApp.domain.models.HubbleNewDetails
import ru.gladkov.sciencehub.androidApp.domain.utils.toDate
import ru.gladkov.sciencehub.androidApp.domain.utils.toString
import ru.gladkov.sciencehub.shared.features.hubble.ktor.models.KtorHubbleNewDetailsResponse

class NewDetailsMapper : Mapper<KtorHubbleNewDetailsResponse, HubbleNewDetails> {
    override fun transform(data: KtorHubbleNewDetailsResponse) =
        HubbleNewDetails(
            description = data.description,
            name = data.name,
            newsId = data.newsId,
            date = data.publication?.toDate("yyyy-MM-dd'T'HH:mm:ss.SSSZ")?.toString("dd-MM-yyyy"),
            img = "https:${data.thumbnailRetina}",
            url = data.url
        )
}
