package threads

/**
 * The main method reads a string from user input, creates a SlowStringProcessor object, starts it as a separate thread,
 * waits for it to finish processing, and then prints out the number of unique characters in the processed string.
 *
 * @throws RuntimeException if the main thread attempts to run the SlowStringProcessor directly (should start a new thread instead)
 * @throws RuntimeException if the thread is interrupted during processing
 */
fun main() {
    val str: String = readln()
    val processor = SlowStringProcessor(str)
    processor.start()
    processor.join()
    println(processor.numberOfUniqueCharacters)
}

/**
 * Represents the ID of the main thread.
 *
 * This property stores the ID of the main thread that the variable is initialized on.
 *
 * @see Thread.getId
 *
 * @sample SlowStringProcessor
 * @sample SlowStringProcessor.run
 */
val mainThreadId = Thread.currentThread().id

/**
 * SlowStringProcessor is a class that extends Thread and is used to process a given user input string
 * by counting the number of unique characters in it.
 *
 * @property userInput The user input string to be processed.
 * @property numberOfUniqueCharacters The number of unique characters in the processed user input string.
 */
class SlowStringProcessor(private val userInput: String) : Thread() {
    @Volatile
    var numberOfUniqueCharacters: Int = 0
        private set

    override fun run() {
        val currentId = currentThread().id

        if (currentId == mainThreadIdentifier) {
            throw RuntimeException("You must start a new thread!")
        }

        try {
            sleep(2000)
        } catch (e: Exception) {
            throw RuntimeException("Do not interrupt the processor", e)
        }

        numberOfUniqueCharacters = userInput.split("").filter { it != "" }.toTypedArray().distinct().size
    }
}
