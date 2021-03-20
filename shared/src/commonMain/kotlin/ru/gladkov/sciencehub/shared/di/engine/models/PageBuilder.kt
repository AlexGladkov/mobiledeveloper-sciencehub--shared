package ru.gladkov.sciencehub.shared.di.engine.models

@ArticleDSL
class PageBuilder {

    var number: Int = -1
    private var pageBlocks: ArrayList<PageBlock> = ArrayList()

    fun pageBlocks(block: PageBlockContainer.() -> Unit) {
        val pageBlockContainer = PageBlockContainer().apply(block)
        pageBlocks.addAll(pageBlockContainer.content)
    }

    fun build(): Page = Page(number, pageBlocks)
}

class PageBlockContainer {

    private val _content: MutableList<PageBlock> = mutableListOf()
    val content: List<PageBlock> get() = _content

    @ArticleDSL
    internal inline fun pageBlock(block: PageBlockBuilder.() -> Unit) =
        PageBlockBuilder().apply(block).build().also {
            _content.add(it)
        }
}

