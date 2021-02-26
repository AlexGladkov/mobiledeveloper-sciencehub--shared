package ru.gladkov.sciencehub.androidApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import ru.gladkov.sciencehub.shared.di.Configuration
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.di.PlatformType
import ru.gladkov.sciencehub.shared.di.engine.models.Page
import ru.gladkov.sciencehub.shared.di.engine.models.headerBlock
import ru.gladkov.sciencehub.shared.di.engine.models.page
import ru.gladkov.sciencehub.shared.di.engine.models.textBlock

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

        compileArticle(page {
            number = 1
            pageBlocks {
                headerBlock(text = "This is article header")
                textBlock(text = "This is article text")
                textBlock(text = "This is another article text")
                textBlock(text = "This is the end")
            }
        })
    }

    fun compileArticle(page: Page) {
        page.pageBlocks.forEach {
            Log.e("TAG", "Type -> ${it.type}, Content -> ${it.content}")
        }
    }
}
