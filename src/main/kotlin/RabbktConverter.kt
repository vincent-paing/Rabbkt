import converter.RuleBasedStringConverter

/**
 * Utility class for easily converting between Zawgyi and Unicode
 * Wraps Rules in [Rule] for both Zawgyi and Unicode
 */
public object RabbktConverter {

    private val zawgyiToUnicodeConverter = RuleBasedStringConverter(zgToUnicodeRules)
    private val unicodeToZawgyiConverter = RuleBasedStringConverter(unicodeToZawgyiRules)

    /**
     * Convert Zawgyi Text to Unicode using [RuleBasedStringConverter] with rules from [Rule]
     * @param zawgyiString Zawgyi String
     * @return Unicode String
     */
    fun zawgyiToUnicode(zawgyiString: String): String {
        //because of JDK 7 bugs in Android
        var temp = zawgyiString.replace("null", "\uFFFF\uFFFF")
        temp = zawgyiToUnicodeConverter.convert(temp)
        return temp.replace("\uFFFF\uFFFF", "null")
    }

    /**
     * Convert Unicode Text to Zawgyi using [RuleBasedStringConverter] with rules from [Rule]
     * @param unicodeString Unicode String
     * @return Zawgyi String
     */
    fun unicodeToZawgyi(unicodeString: String): String {
        var temp = unicodeString.replace("null", "\uFFFF\uFFFF")
        temp = unicodeToZawgyiConverter.convert(temp)
        return temp.replace("\uFFFF\uFFFF", "null")
    }
}