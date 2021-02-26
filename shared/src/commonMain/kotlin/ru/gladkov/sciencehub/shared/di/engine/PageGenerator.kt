package ru.gladkov.sciencehub.shared.di.engine

import ru.gladkov.sciencehub.shared.di.engine.models.*

class PageGenerator {
    private fun generatePage(): Page = page {
        number = 1
        pageBlocks {
            headerBlock("This is article header")
            textBlock("This is article content")
            compositeBlock(imageBlock(url = "imageUrl"))
        }
    }
}
