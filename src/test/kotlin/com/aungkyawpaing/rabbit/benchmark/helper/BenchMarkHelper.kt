package com.aungkyawpaing.rabbit.benchmark.helper


inline fun benchMark(tag: String,
                     warmUpRounds: Int = 0, rounds: Int = 1, function: (() -> (Unit))) {
    (0 until warmUpRounds).forEach {
        function.invoke()
    }


    val benchMark = Benchmark(tag)
    var elapsedTimeList = mutableListOf<Long>()
    (0 until rounds).forEach {
        benchMark.start()
        function.invoke()
        benchMark.stop()
        benchMark.output()
        elapsedTimeList.add(benchMark.elapsedTime)
    }

    var totalElapsedTime = 0L
    elapsedTimeList.forEach {
        totalElapsedTime += it
    }

    val averageElapsedTime = totalElapsedTime / elapsedTimeList.size
    println("-----$tag-----")
    println("Average Time : $averageElapsedTime ms")

}
