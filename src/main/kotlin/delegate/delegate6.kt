package delegate

/**
 * The `ICounter` interface defines the contract for a counter object. It provides methods to manipulate the count value and retrieve the current count.
 */
private interface ICounter {
    var count: Int
    fun increaseCount()
    fun getCurrentCount(): Int
}

/**
 * A private class representing a counter object that implements the `ICounter` interface.
 *
 * @property count The current count value of the counter.
 */
private class Counter(override var count: Int) : ICounter {
    // In case we need to count differently, this function can be altered
    override fun increaseCount() {
        count++
    }

    override fun getCurrentCount(): Int = count
}

/**
 * Represents an iterator class that implements the [ICounter] interface.
 *
 * This class allows for iterating over a counter and incrementing its count.
 *
 * @param base The [ICounter] instance to be iterated over.
 */
private class Iterator(base: ICounter) : ICounter by base {
    fun next() {
        increaseCount()
    }
}

/**
 * The `main` function is the entry point of the program.
 * It reads an integer input, creates a `Counter` object with the input value, and an `Iterator` object using the `Counter`.
 * The program then calls the `next` function of the iterator 5 times to increase the count, and finally prints the current count using the `getCurrentCount` function.
 * This function doesn't take any parameters and doesn't return anything.
 */
private fun main() {
    val a = readln().toInt()
    val counter = Counter(a)
    val it = Iterator(counter)

    for (i in 1..5) {
        it.next()
    }

    println(it.getCurrentCount())
}
