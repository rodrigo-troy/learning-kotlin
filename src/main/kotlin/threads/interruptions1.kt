package threads

import java.time.LocalDateTime

/**
 * Represents a custom thread that can be interrupted.
 *
 * This class extends the [Thread] class and overrides its [run] method to provide custom behavior.
 * When the thread is started, it enters a loop and sleeps for 1 second on each iteration.
 * If the thread is interrupted while sleeping, it will print a message and exit the loop.
 *
 * The reaction to this event depends on the interrupted thread itself. In the most common case, it stops the execution.
 * However, the thread may simply ignore the flag.
 *
 * Depending on the current state of the thread, interruptions are handled differently.
 * Invoking customThread.interrupt() will cause InterruptedException if the thread is sleeping or joining another thread.
 * If the thread is running, calling the .interrupt() method will change the isInterrupted flag to true.
 * This flag allows you to monitor whether the flow is interrupted.
 * @see Thread
 */

private class InterruptedThread : Thread() {
    override fun run() {
        while (!isInterrupted) {
            try {
                doAction()
                println("${LocalDateTime.now()} - Thread ID: ${currentThread().id} - sleeping for 1000ms...")
                sleep(1000)
            } catch (e: InterruptedException) {
                println("Error: ${e.message}")
                println("${LocalDateTime.now()} - Thread ID: ${currentThread().id} - sleeping was interrupted")
                break
            }
        }

        print("${LocalDateTime.now()} - Thread ID: ${currentThread().id} finished")
    }

    private fun doAction() {
        println("${LocalDateTime.now()} - Thread ID: ${currentThread().id} - doing action")
    }
}

/**
 * The main function is the entry point of the application.
 * It demonstrates the usage of the InterruptedThread class by creating a custom thread,
 * starting it, interrupting it, and printing the current time and thread ID.
 */
fun main() {
    val customThread: Thread = InterruptedThread()
    customThread.start()
    Thread.sleep(3000)
    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - interrupting thread")
    customThread.interrupt()
}
