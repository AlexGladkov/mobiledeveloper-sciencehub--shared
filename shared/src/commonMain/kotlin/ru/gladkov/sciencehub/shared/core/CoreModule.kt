package ru.gladkov.sciencehub.shared.core

import org.kodein.di.DI
import ru.gladkov.sciencehub.shared.core.ktor.ktorModule
import ru.gladkov.sciencehub.shared.core.serialization.serializationModule

val coreModule = DI.Module {
    importAll(
        ktorModule,
        serializationModule
    )
}