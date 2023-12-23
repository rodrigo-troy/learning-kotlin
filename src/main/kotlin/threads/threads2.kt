package threads

/**
 * Represents a custom thread class that extends the Thread class.
 * It provides the functionality to print a message from within the thread's execution.
 *
 * @property name The name of the thread.
 */
private class MyThread(name: String) : Thread(name) {
    override fun run() {
        println("Hello from $name")
    }
}

/**
 * Main method of the program.
 *
 * This method creates two instances of the MyThread class and starts them as separate threads.
 * It then prints "Finished" to the console.
 * The printing order of the threads is not guaranteed.
 *
 * @param args the command line arguments
 */
private fun main() {
    val t1 = MyThread("My-thread-1")
    t1.start()

    val t2 = MyThread("My-thread-2")
    t2.start()

    println("Finished")
}
