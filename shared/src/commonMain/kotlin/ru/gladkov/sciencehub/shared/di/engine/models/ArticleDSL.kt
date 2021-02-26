package ru.gladkov.sciencehub.shared.di.engine.models

fun page(block: PageBuilder.() -> Unit): Page = PageBuilder().apply(block).build()

fun PageBlockContainer.headerBlock(text: String) = pageBlock {
    type = "Header"
    content = text
}

fun PageBlockContainer.imageBlock(url: String) = pageBlock {
    type = "Image"
    content = url
}

fun PageBlockContainer.textBlock(text: String) = pageBlock {
    type = "Plain"
    content = text
}

fun PageBlockContainer.compositeBlock(pageBlock: PageBlock) = pageBlock {
    type = "Composite"
    content = "This is image description"
    innerBlock = pageBlock
}