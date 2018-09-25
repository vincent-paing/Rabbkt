package com.aungkyawpaing.rabbkt.converter

/**
 * Generic Interface for converting string, hidden from external use
 */
internal interface StringConverter {

    fun convert(input: String): String
}