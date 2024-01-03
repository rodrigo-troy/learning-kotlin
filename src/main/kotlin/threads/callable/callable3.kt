package threads.callable

import java.time.LocalDateTime
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * The main method is the entry point of the application.
 * It initializes an executor and submits a task to it, which sleeps for 1 second 7 times,
 * and then returns the value 70000.
 *
 * The main method then enters a loop and waits for the submitted task to complete. It periodically checks
 * if the task is done, waiting for 2 seconds between each check.
 *
 * Finally, the main method prints the current timestamp, the thread ID, and the result of the task.
 */
fun main() {
    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Start counting")

    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    val future = executor.submit(Callable {
        repeat(7) {
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Sleeping for 1 seconds...")
            TimeUnit.SECONDS.sleep(1)
        }

        println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Returning value")
        70000
    })

    while (!future.isDone) {
        println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Waiting for result")
        TimeUnit.MILLISECONDS.sleep(2000)
    }

    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - ${future.get()}")
}
