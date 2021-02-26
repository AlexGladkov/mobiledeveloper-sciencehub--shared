package ru.gladkov.sciencehub.shared.di.engine.models

@ArticleDSL
class PageBlockBuilder {

    var content = ""
    var type = "UNDEFINED"
    var innerBlock: PageBlock? = null

    fun build(): PageBlock = PageBlock(content, type, innerBlock)
}