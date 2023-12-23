package threads

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 23-12-23
 * Time: 18:27
 *
 *
 * Represents a custom thread class that extends the Thread class.
 * It provides the functionality to print a message from within the thread's execution.
 *
 * @property name The name of the thread.
 */

private class CustomThread(name: String) : Thread(name) {
    override fun run() {
        println("Hello from $name")
    }
}


/**
 * The main function of the program.
 *
 * This function creates two instances of the CustomThread class and starts them as separate threads.
 * It then waits for both threads to complete their execution before printing "Finished" to the console.
 */
private fun main() {
    // Create a new instance of CustomThread with the name "My-thread-1"
    val t1 = CustomThread("My-thread-1")
    // Start the execution of the thread
    t1.start()

    // Create a new instance of CustomThread with the name "My-thread-2"
    val t2 = CustomThread("My-thread-2")
    // Start the execution of the thread
    t2.start()


    // Wait for thread t1 to complete its execution
    t1.join()
    // Wait for thread t2 to complete its execution
    t2.join()

    // Print "Finished" to the console
    println("Finished")
}
