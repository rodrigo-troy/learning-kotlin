package threads

import java.time.LocalTime
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


/**
 * Main function that schedules a task to run at a fixed rate using a single-threaded scheduled executor.
 * The task prints the current time followed by "Hello!" to the console.
 */
fun main() {
    val executor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
    val function = { println(LocalTime.now().toString() + ": Hello!") }

    executor.scheduleAtFixedRate(
        function,
        1000,
        1000,
        TimeUnit.MILLISECONDS
    )
}
