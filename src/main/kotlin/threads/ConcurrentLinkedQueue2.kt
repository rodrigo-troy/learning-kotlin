package threads

import java.time.LocalDateTime
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

/**
 * This variable represents the limit used in the example code.
 * This limit is used by the generator functions to control the number of items added to the queue,
 * and by the poller function to control the number of items read from the queue.
 * Changing the value of this variable will affect the behavior of the example code.
 */
private const val limit = 5

/**
 * The main method is the entry point of the program. It creates a concurrent linked queue
 * and three threads - two generators and one poller - that interact with the queue.
 * The generators add integers to the queue in a specific pattern, while the poller reads
 * the integers from the queue and prints them.
 */
fun main() {
    val queue = ConcurrentLinkedQueue<Int>()

    val generator1 = thread(start = false, name = "G1", block = {
        repeat(limit) {
            val i = (it + 1) * -10
            println("${LocalDateTime.now()} - ${Thread.currentThread().name} - adding $i")
            queue.add(i)
            Thread.sleep(10)
        }
    })

    val generator2 = thread(start = false, name = "G2", block = {
        repeat(limit) {
            val i = (it + 1) * 10
            println("${LocalDateTime.now()} - ${Thread.currentThread().name} - adding $i")
            queue.add(i)
            Thread.sleep(10)
        }
    })

    val poller = thread(start = false, name = "P1", block = {
        var countRead = 0

        while (countRead != limit * 2) {
            println("${LocalDateTime.now()} - ${Thread.currentThread().name} - Poll status: $queue")
            val next: Int? = queue.poll()

            if (next != null) {
                countRead++
            }

            println("${LocalDateTime.now()} - ${Thread.currentThread().name} - read $next")

            try {
                TimeUnit.MILLISECONDS.sleep(10)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    })

    generator1.start()
    generator2.start()
    poller.start()
}
