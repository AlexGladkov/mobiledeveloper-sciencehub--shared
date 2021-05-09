package ru.gladkov.sciencehub.androidApp.domain.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(format: String): Date? {
    val fmt = SimpleDateFormat(format, Locale.getDefault())
    return try {
        fmt.parse(this)
    } catch (pe: ParseException) {
        null
    }
}

fun Date.toString(format: String): String? {
    val fmt = SimpleDateFormat(format, Locale.getDefault())
    return try {
        fmt.format(this)
    } catch (pe: ParseException) {
        null
    }
}