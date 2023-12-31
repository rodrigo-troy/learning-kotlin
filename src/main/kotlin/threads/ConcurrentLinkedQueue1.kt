package threads

import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

private fun ConcurrentLinkedQueue<Int>.isSorted(): Boolean {
    var previous = Int.MIN_VALUE  // Smallest possible integer value
    for (number in this) {
        if (number < previous) {
            return false
        }
        previous = number
    }
    return true
}

/**
 * Adds numbers to the provided ConcurrentLinkedQueue.
 * This function is not thread-safe. If two threads call this function concurrently, the numbers added to the queue
 * may be out of order.
 *
 *
 * Note that because the ConcurrentLinkedQueue is indeed thread-safe, the integrity of the queue and its operations
 * (add in this case) will not be compromised even when accessed from multiple threads concurrently.
 *
 *
 * @param target the ConcurrentLinkedQueue to which numbers will be added
 */
private fun addNumbers(target: ConcurrentLinkedQueue<Int>) {
    //val threadName = Thread.currentThread().name
    //println("$threadName started")
    for (i in 0..100) {
        println("${Thread.currentThread().name} adding $i")
        target.add(i)
    }
}

/**
 * Runs two threads concurrently to add numbers to a shared ConcurrentLinkedQueue instance.
 * Even though the addNumbers function is not thread-safe, the ConcurrentLinkedQueue class is thread-safe.
 * This means that the numbers added to the queue may not be in order, but the queue itself will not be corrupted.
 */
private fun main() {
    val numbers = ConcurrentLinkedQueue<Int>()

    val writer = thread(start = false, name = "Thread 1", block = {
        addNumbers(numbers)
    })

    writer.start()

    addNumbers(numbers)

    writer.join()


    println()
    println("----------------------------------------------------------------------------------------------------")
    println()

    println("Is the queue sorted? ${numbers.isSorted()}")
    println("The queue contains ${numbers.size} elements:")
    numbers.forEach { print("$it ") }
}
