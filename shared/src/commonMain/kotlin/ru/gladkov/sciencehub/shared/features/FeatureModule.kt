package ru.gladkov.sciencehub.shared.features

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.di.engine.PageGenerator
import ru.gladkov.sciencehub.shared.di.engine.engineModule
import ru.gladkov.sciencehub.shared.features.hubble.HubbleRepository
import ru.gladkov.sciencehub.shared.features.hubble.hubbleModule
import kotlin.native.concurrent.ThreadLocal

val featureModule = DI.Module {
    importAll(
        hubbleModule
    )
}