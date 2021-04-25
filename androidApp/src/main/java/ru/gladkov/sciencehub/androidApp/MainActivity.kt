package ru.gladkov.sciencehub.androidApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.gladkov.sciencehub.shared.di.Configuration
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.di.PlatformType
import ru.gladkov.sciencehub.shared.di.engine.models.Page
import ru.gladkov.sciencehub.shared.di.engine.models.headerBlock
import ru.gladkov.sciencehub.shared.di.engine.models.page
import ru.gladkov.sciencehub.shared.di.engine.models.textBlock
import ru.gladkov.sciencehub.shared.features.hubble.hubble

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EngineSDK.init(
            configuration =
            Configuration(
                platformType = PlatformType.Android("1.0", "1")
            )
        )

        GlobalScope.launch {
            val result = EngineSDK.hubble.hubbleRepository.fetchNews()
            Log.e("TAG", "Result -> ${result.count()}")
        }
    }
}
