package ru.gladkov.sciencehub.androidApp.domain.mapper

interface Mapper<SRC, DST> {
    fun transform(data: SRC): DST
}
