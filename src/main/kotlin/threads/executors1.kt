package threads

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


const val NUMBER_OF_TASKS = 10
const val POOL_SIZE = 4

/**
 * The main method that executes a set of tasks using a fixed thread pool.
 * It creates an executor service with a fixed number of threads.
 * Then, it submits a number of tasks to the executor service for execution.
 * Each task prints its name and the name of the thread executing it.
 * Finally, it shuts down the executor service gracefully.
 */
fun main() {
    val executor: ExecutorService = Executors.newFixedThreadPool(POOL_SIZE)

    for (i in 0..NUMBER_OF_TASKS) {
        executor.submit {
            val taskName: String = "task-$i"
            val threadName: String = Thread.currentThread().name
            println("$threadName executes $taskName")
        }
    }

    executor.shutdown()
}
