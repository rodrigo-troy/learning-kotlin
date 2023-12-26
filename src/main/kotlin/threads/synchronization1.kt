import kotlin.concurrent.thread

private interface ICounter {
    var count: Int
    fun inc()
}

/**
 * The `Counter` class represents a simple counter that can be incremented by calling the `inc` method.
 *
 * Example usage:
 *  ```kotlin
 *  val counterInstance = Counter()
 *  counterInstance.inc()*/
private class Counter : ICounter {
    override var count = 0

    override fun inc() {
        count++
    }
}

/**
 * The SynchronizedCounter class is a thread-safe counter implementation with a single public method, inc().
 * This class uses the @Synchronized annotation to ensure that only one thread can access the increment operation
 * at a time, preventing race conditions and maintaining data integrity.
 *
 * Usage:
 *
 * val counterInstance = SynchronizedCounter()
 * counterInstance.inc()
 *
 * @property count The current count value.
 */
private class SynchronizedCounter : ICounter {
    override var count = 0

    @Synchronized
    override fun inc() {
        count++
    }
}

/**
 * Runs two threads concurrently to increment a shared counter instance.
 *
 * @param counter An instance of a class implementing the [ICounter] interface, representing the counter to be incremented.
 */
private fun runCounterThreads(counter: ICounter) {
    val thread1 = thread(block = {
        for (i in 1..10_000_000) {
            counter.inc();
        }
    })

    val thread2 = thread(block = {
        for (i in 1..10_000_000) {
            counter.inc();
        }
    })

    thread1.join()
    thread2.join()

    println("The result of the threads' work: ${counter.count}")
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
 * This is why incrementing a value concurrently by multiple threads is not trivial, and we must carefully manage critical sections in our code.
 */
fun main() {
    runCounterThreads(Counter())
    runCounterThreads(SynchronizedCounter())
}
