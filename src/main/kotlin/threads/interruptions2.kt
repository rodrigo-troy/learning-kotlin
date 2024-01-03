package threads

import java.time.LocalDateTime

/**
 * Executes a counting task on a separate thread.
 */
private class CountingTask : Runnable {
    override fun run() {
        println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Start counting")
        var i = 1

        try {
            while (!Thread.interrupted()) {
                println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Counting $i")
                i++
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Sleeping was interrupted")
        }

        println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Finishing")
    }
}

/**
 * The main entry point for the program.
 *
 * This method starts a new thread and executes a counting task on it.
 * After 3 seconds, it interrupts the thread and prints a message.
 */
fun main() {
    val counter = Thread(CountingTask())
    counter.start()
    Thread.sleep(3000)
    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - interrupting thread")
    counter.interrupt()
    counter.join()
}
