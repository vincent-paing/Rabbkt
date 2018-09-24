import org.junit.Assert.*
import org.junit.Test

class RabbktConverterTest {

    val zawgyiString = "သီဟိုဠ္မွ ဉာဏ္ႀကီးရွင္သည္ အာယုဝၯနေဆးၫႊန္းစာကို ဇလြန္ေဈးေဘး ဗာဒံပင္ထက္ အဓိ႒ာန္လ်က္ ဂဃနဏဖတ္ခဲ့သည္။"
    val unicodeString = "သီဟိုဠ်မှ ဉာဏ်ကြီးရှင်သည် အာယုဝဍ္ဎနဆေးညွှန်းစာကို ဇလွန်ဈေးဘေး ဗာဒံပင်ထက် အဓိဋ္ဌာန်လျက် ဂဃနဏဖတ်ခဲ့သည်။"

    @Test
    fun zawgyiToUnicodeTest() {
        val expected = unicodeString
        val actual = RabbktConverter.zawgyiToUnicode(zawgyiString)

        assertEquals(expected, actual)
    }

    @Test
    fun unicodeToZawgyiTest() {
        val expected = zawgyiString
        val actual = RabbktConverter.unicodeToZawgyi(unicodeString)

        assertEquals(expected, actual)
    }
}