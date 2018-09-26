package com.aungkyawpaing.rabbit.benchmark

import com.aungkyawpaing.rabbit.benchmark.helper.benchMark
import com.aungkyawpaing.rabbkt.RabbktConverter
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import java.io.InputStream
import java.util.*

class BenchmarkTest {

    var possibleStringArray = mutableListOf<String>()
    var stringToBeConverted = ""

    companion object {
        const val CHARACTER_SIZE = 100000
        const val WARM_UP_ROUNDS = 5
        const val TOTAL_ROUNDS = 10
    }

    @Before
    fun setUp() {
        val inputStream: InputStream = File("wordlists.list").inputStream()
        inputStream.bufferedReader().useLines { lines ->
            lines.forEach {
                possibleStringArray.add(it)
            }
        }
        inputStream.close()

        val random = Random()
        val stringBuilder = StringBuilder()
        (0 until CHARACTER_SIZE).forEach {
            val randomIndex = random.nextInt(possibleStringArray.size)
            val randomString = possibleStringArray[randomIndex]
            stringBuilder.append(randomString)
        }
        stringToBeConverted = stringBuilder.toString()
    }


    @Test
    fun testRabbit() {
        benchMark("Rabbit", WARM_UP_ROUNDS, TOTAL_ROUNDS) {
            Rabbit.uni2zg(stringToBeConverted)
        }

    }

    @Test
    fun testRabbkt() {
        benchMark("Rabbkt", WARM_UP_ROUNDS, TOTAL_ROUNDS) {
            RabbktConverter.unicodeToZawgyi(stringToBeConverted)
        }
    }

    @After
    fun tearDown() {
        possibleStringArray.clear()
        stringToBeConverted = ""
    }
}