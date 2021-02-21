package ru.gladkov.sciencehub.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.gladkov.sciencehub.shared.di.Configuration
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.di.PlatformType

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
    }
}
