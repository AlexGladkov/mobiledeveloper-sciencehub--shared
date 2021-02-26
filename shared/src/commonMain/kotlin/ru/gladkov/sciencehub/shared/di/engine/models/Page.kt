package ru.gladkov.sciencehub.shared.di.engine.models

data class Page(val number: Int, val pageBlocks: List<PageBlock>)

data class PageBlock(val content: String, val type: String, val pageBlock: PageBlock?)