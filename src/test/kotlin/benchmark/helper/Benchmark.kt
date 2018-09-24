package benchmark.helper

class Benchmark(private val tag: String) {

    var startTime: Long = 0
    var endTime: Long = 0
    var elapsedTime: Long = 0

    fun start() {
        startTime = System.currentTimeMillis()
    }

    fun stop() {
        endTime = System.currentTimeMillis()
        elapsedTime = endTime - startTime
    }

    fun output() {
        println("-----$tag-----")
        println("Elapsed : $elapsedTime ms")
    }

}

