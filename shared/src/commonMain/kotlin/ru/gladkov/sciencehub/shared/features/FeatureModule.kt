package ru.gladkov.sciencehub.shared.features

import org.kodein.di.DI
import ru.gladkov.sciencehub.shared.features.hubble.hubbleModule

val featureModule = DI.Module(
    name = "featureModule",
    allowSilentOverride = false,
    prefix = "",
    fun DI.Builder.() {
        importAll(
            hubbleModule
        )
    }
)