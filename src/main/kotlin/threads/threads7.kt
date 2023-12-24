package threads

/**
 * Main method that calculates the sum of two ranges and prints the result.
 *
 * This method prompts the user to input the limits of two ranges and creates two `RangeSummator` objects
 * to calculate the sum of each range. It then starts the threads, waits for them to finish using `join()`,
 * and retrieves the partial sums from each thread. Finally, it calculates the total sum of the two ranges
 * and prints the result.
 */
fun main() {
    val (from1Incl, to1Incl) = readRange()
    val (from2Incl, to2Incl) = readRange()

    val summator1 = RangeSummator(from1Incl, to1Incl)
    val summator2 = RangeSummator(from2Incl, to2Incl)
    summator1.start()
    summator2.start()
    summator1.join()
    summator2.join()

    val partialSum1 = summator1.result
    val partialSum2 = summator2.result
    val sum = partialSum1 + partialSum2
    println(sum)
}

fun readRange(): List<Int> = readln().split(" ").map { it.toInt() }


/**
 * Identifies the main thread in the application.
 *
 * This variable holds the ID of the main thread when it is initialized.
 * It is used to compare with the current thread ID to determine if the current thread is the main thread.
 *
 * Usage Example:
 **/
val mainThreadIdentifier = Thread.currentThread().id

/**
 * Class representing a RangeSummator.
 *
 * @property fromIncl The inclusive starting point of the range.
 * @property toIncl The inclusive ending point of the range.
 */
private class RangeSummator(private var fromIncl: Int, private var toIncl: Int) : Thread() {
    @Volatile
    var result: Long = 0
        private set

    override fun run() {
        val currentId = currentThread().id

        if (currentId == mainThreadIdentifier) {
            throw RuntimeException("You must start a new thread!")
        }

        var sum: Long = 0

        for (i in fromIncl..toIncl) {
            sum += i.toLong()
        }

        result = sum
    }
}
