/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 27-03-23
 * Time: 12:54
 */
import java.util.logging.Filter
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger

/**
 * The Main class represents the entry point of the program. It contains the main function
 * which initializes the program and demonstrates the usage of the Logger class.
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val logger = Logger.getLogger(Main::class.java.name)
        val filter: Filter = FilterExample()
        logger.filter = filter
        logger.severe("Severe Log")
        logger.info("Info Log")
        logger.warning("Warning Log")
    }
}

/**
 * A concrete implementation of the Filter interface that filters out log records based on their level.
 * This class filters log records with level other than INFO and WARNING.
 *
 * @see Filter
 */
class FilterExample : Filter {
    override fun isLoggable(record: LogRecord): Boolean {
        return !(record.level !== Level.INFO || record.level !== Level.WARNING)
    }
}

/**
 * Entry point of the program.
 */
private fun main() {
    val demoArray = intArrayOf(0, 1, 2, 3, 4, 5)
    demo(demoArray)
}

/**
 * Prints the element at index 10 of the given input array.
 *
 * @param input The input array.
 *
 * @throws ArrayIndexOutOfBoundsException If the index 10 is outside the range of the input array.
 */
fun demo(input: IntArray) {
    println(input[10])
}
