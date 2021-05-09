package ru.gladkov.sciencehub.androidApp

import android.app.Application
import ru.gladkov.sciencehub.shared.di.Configuration
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.di.PlatformType

class HubbleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        EngineSDK.init(
            configuration =
            Configuration(
                platformType = PlatformType.Android("1.0", "1")
            )
        )
    }
}
