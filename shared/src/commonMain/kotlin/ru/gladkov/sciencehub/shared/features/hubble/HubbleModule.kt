package ru.gladkov.sciencehub.shared.features.hubble

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.features.hubble.ktor.KtorHubbleDataSource
import kotlin.native.concurrent.ThreadLocal

internal val hubbleModule = DI.Module(
    name = "HubbleModule",
    init = {
        bind<HubbleRemoteDataSource>() with singleton {
            KtorHubbleDataSource(
                httpClient = instance(),
                json = instance()
            )
        }

        bind<HubbleRepository>() with singleton {
            HubbleRepository(
                remoteDataSource = instance()
            )
        }
    }
)

@ThreadLocal
object HubbleModule {

    val hubbleRepository: HubbleRepository
        get() = EngineSDK.di.instance()
}

val EngineSDK.hubble: HubbleModule
    get() = HubbleModule