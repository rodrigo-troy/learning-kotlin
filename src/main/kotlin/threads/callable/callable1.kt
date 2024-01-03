package threads.callable

import java.time.LocalDateTime
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * Main method to start the program execution.
 *
 * This method prints the current date and time along with the thread ID and starts counting.
 * It creates a Callable object named generator that sleeps for 5 seconds and then prints the current date and time,
 * thread ID, and returns the value 70000. Finally, it prints the result returned by the generator.
 */
fun main() {
    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Start counting")

    val generator: Callable<Int> = Callable {
        TimeUnit.SECONDS.sleep(5)
        println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Returning value")
        70000
    }

    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - ${generator.call()}")
}
