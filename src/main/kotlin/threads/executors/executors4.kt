package threads.executors

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun findSum(num: Int): Int {
    val executor = Executors.newSingleThreadExecutor()
    var sum = 0

    for (i in 1..5) {
        executor.submit {
            sum += num / i;
            println("Sum: $sum")
        }
    }

    executor.shutdown()
    executor.awaitTermination(60, TimeUnit.MILLISECONDS)

    return sum
}

fun main() {
    println("Total: ${findSum(10)}")
}
