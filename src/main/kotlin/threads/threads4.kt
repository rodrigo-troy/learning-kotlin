package threads

/**
 * The Worker class represents a worker thread that performs a task and waits for it to finish,
 * before continuing with the program execution.
 *
 * @constructor Creates an instance of Worker class.
 *
 * @see Thread
 */
class Worker : Thread() {
    override fun run() {
        println("Starting a task")
        sleep(5000)
        println("The task is finished")
    }
}

/**
 * The main method is the entry point of the program.
 * It creates an instance of the Worker class, starts the worker, and performs some useful work.
 * After that, it waits for the worker to complete its task and then stops.
 */
fun main() {
    val worker = Worker()
    worker.start()
    Thread.sleep(100)
    println("Do something useful")
    worker.join(3000)
    println("The program stopped")
}
