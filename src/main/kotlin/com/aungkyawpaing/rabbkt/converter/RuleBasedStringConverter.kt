package com.aungkyawpaing.rabbkt.converter

/**
 * Implementation of [StringConverter]
 * Uses a provided rule set to convert string
 */
public class RuleBasedStringConverter constructor(private val rules: Map<Regex, String>) :
        StringConverter {

    /**
     * @param input Input string
     * @return Converted String
     */
    override fun convert(input: String): String {
        var tempString = input
        rules.forEach { (key, value) ->
            tempString = tempString.replace(key, value)
        }
        return tempString
    }


}
