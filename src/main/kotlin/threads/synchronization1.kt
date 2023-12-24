import kotlin.concurrent.thread

/**
 * The `Counter` class represents a simple counter that can be incremented by calling the `inc` method.
 *
 * Example usage:
 *  ```kotlin
 *  val counterInstance = Counter()
 *  counterInstance.inc()*/
private class Counter {
    var count = 0

    fun inc() {
        count++
    }
}

/**
 * Main entry point of the program.
 *
 * This method demonstrates the usage of threads to increment a counter concurrently. It creates two threads,
 * where each thread increments a shared counter instance. The threads are joined after their work is finished,
 * and the final count of the counter instance is printed.
 *
 * The final value should be 20 000 000. However, when the program ends its work, we have a different, wrong result.
 *
 * This happens because sometimes a thread does not see the changes of shared data made by another thread, and sometimes a thread may see an intermediate value of a non-atomic operation. Those are examples of visibility and atomicity problems we deal with while working with shared data.
 *
 * That is why increasing a value by multiple threads is a critical section.
 */
fun main() {
    val counterInstance = Counter()

    val thread1 = thread(block = {
        for (i in 1..10_000_000) {
            counterInstance.inc();
        }
    })

    val thread2 = thread(block = {
        for (i in 1..10_000_000) {
            counterInstance.inc();
        }
    })

    thread1.join()
    thread2.join()

    println("The result of the threads' work: ${counterInstance.count}")
}
