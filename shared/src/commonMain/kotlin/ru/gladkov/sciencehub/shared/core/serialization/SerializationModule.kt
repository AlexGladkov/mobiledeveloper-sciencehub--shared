package ru.gladkov.sciencehub.shared.core.serialization

import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val serializationModule = DI.Module(
    name = "SerializationModule",
    init = {
        bind<Json>() with singleton {
            Json {
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
    }
)