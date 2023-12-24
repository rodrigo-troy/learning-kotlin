package threads

/**
 * The `Counter` class represents a simple counter that can be incremented.
 * It provides a method to increment the value of the counter by one.
 *
 * The operation value++ can be decomposed into three steps:
 *
 * 1. read the current value;
 * 2. increment the value by 1;
 * 3. write the incremented value back in the field.
 *
 * Now, consider a scenario where two threads, Thread-A and Thread-B, are operating on the same instance of Counter. If both threads call the increment() function at the same time:
 *
 * 1. Thread-A reads the current value.
 * 2. Concurrently, Thread-B also reads the current value.
 * 3. Thread-A increments the value and writes it back.
 * 4. After that, Thread-B increments the old value (it read before) and writes back.
 *
 * In this case, even though increment() function has been called twice, the counter's value only increments once. This is a typical example of a race condition and is due to thread interference. The increment operation needs to be atomic to prevent such issues, i.e., reading the value, incrementing, and writing back should be done as a single, indivisible operation to avoid interference between threads.
 *
 * @property value The current value of the counter
 */
class Counter {
    var value: Long = 0

    fun increment() {
        value++
    }
}

/**
 * Represents a thread that increments a counter value.
 *
 * @property counter The counter object to be incremented.
 */
class CounterThread(private val counter: Counter) : Thread() {
    override fun run() {
        counter.increment()
    }
}

/**
 * Executes multiple CounterThread instances to increment the value of a Counter object.
 *
 * @param useJoin a boolean value indicating whether to use the join() method on each thread.
 *                If true, the main thread will wait for each CounterThread to complete execution before proceeding.
 *                If false, the main thread will not wait and all CounterThreads will execute concurrently.
 */
private fun executeCounterThreads(useJoin: Boolean) {
    val counter = Counter()
    val threads = List(2) { CounterThread(counter) }

    threads.forEach {
        it.start()
        if (useJoin) {
            it.join()
        }
    }

    print("${counter.value} ")
}

/**
 * The `main` function is the entry point of the program. It executes the `executeCounterThreads` method multiple times,
 * passing different values for the `useJoin` parameter.
 *
 * @see executeCounterThreads
 */
fun main() {
    repeat(100) {
        executeCounterThreads(true)
    }

    println()

    repeat(100) {
        executeCounterThreads(false)
    }
}
