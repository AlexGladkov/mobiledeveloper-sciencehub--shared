package ru.gladkov.sciencehub.shared.core.ktor.engine

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual class HttpEngineFactory {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
        return Ios
    }
}