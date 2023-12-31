package threads

import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

/**
 * Adds numbers to the provided ConcurrentLinkedQueue.
 * This function is not thread-safe. If two threads call this function concurrently, the numbers added to the queue
 * may be out of order.
 *
 * @param target the ConcurrentLinkedQueue to which numbers will be added
 */
fun addNumbers(target: ConcurrentLinkedQueue<Int>) {
    val threadName = Thread.currentThread().name
    println("$threadName started")
    for (i in 0..9_999) {
        println("$threadName adding $i")
        target.add(i)
    }
}

/**
 * Runs two threads concurrently to add numbers to a shared ConcurrentLinkedQueue instance.
 * Even though the addNumbers function is not thread-safe, the ConcurrentLinkedQueue class is thread-safe.
 * This means that the numbers added to the queue may not be in order, but the queue itself will not be corrupted.
 */
fun main() {
    val numbers = ConcurrentLinkedQueue<Int>()

    val writer = thread(start = false, name = "Thread 1", block = {
        addNumbers(numbers)
    })

    writer.start()

    addNumbers(numbers)

    writer.join()

    println(numbers.size)

    println()
    println("--------------------")
    println()

    numbers.forEach { println(it) }
}
