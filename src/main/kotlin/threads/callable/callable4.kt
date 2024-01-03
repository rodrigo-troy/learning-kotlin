package threads.callable

import java.time.LocalDateTime
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * The main function demonstrates the use of multi-threading with ExecutorService.
 *
 * It creates a fixed thread pool with 4 threads using `Executors.newFixedThreadPool(4)`.
 * Then it creates a list of Callables, each representing a task that will be executed by a thread in the pool.
 * Each Callable prints a message with the current date, time, thread ID, and sleeps for a specific number of seconds before returning a result.
 * The results are then collected and summed up, and the sum is printed to the console.
 *
 * @see Executors.newFixedThreadPool
 * @see TimeUnit.SECONDS.sleep
 * @see Callable
 * @see ExecutorService.invokeAll
 */
fun main() {
    val executor = Executors.newFixedThreadPool(4)

    val callables = listOf(
        Callable {
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Sleeping for 1 seconds...")
            TimeUnit.SECONDS.sleep(1)
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - returning result...")
            1000
        },
        Callable {
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Sleeping for 2 seconds...")
            TimeUnit.SECONDS.sleep(2)
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - returning result...")
            2000
        },
        Callable {
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Sleeping for 3 seconds...")
            TimeUnit.SECONDS.sleep(3)
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - returning result...")
            1500
        },
        Callable {
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Sleeping for 8 seconds...")
            TimeUnit.SECONDS.sleep(8)
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - returning result...")
            5600
        }
    )

    val futures = executor.invokeAll(callables)
    var sum = 0
    for (future in futures) sum += future.get()
    println(sum)
}
