package threads

/**
 * Represents a variable that holds an integer number.
 *
 * @property number The integer number value stored in the variable.
 */
var number = 0

/**
 * Represents the readiness state of a process or operation.
 *
 * @property ready indicates whether the process or operation is ready or not.
 *
 * @see Reader
 * @see main
 */
var ready = false

/**
 * This class represents a reader thread that waits for a flag to become true and then prints a number.
 * It extends the `Thread` class.
 *
 * @constructor Creates a new instance of the `Reader` class.
 */
class Reader : Thread() {
    override fun run() {
        while (!ready) {
            println("waiting...")
            yield() // thread does not need resources right now but wants to request them soon
        }
        println(number)
    }
}

/**
 * The main method is the entry point of the program. It starts a new thread called "Reader",
 * sleeps for 100 milliseconds, sets the value of "number" to 42, and sets the value of "ready"
 * to true.
 *
 * This method does not have any parameters.
 *
 * Most of the time, the output will indeed be 42. Yet, there are instances where the program might print out zero. Such discrepancies can arise due to weakened visibility and rearrangement of memory.
 *
 * Most modern processors do not write to memory immediately after receiving a request. These requests are added to a queue in a separately allocated write buffer. After some time, all requests from the queue are immediately executed and the data is written to the main memory.
 *
 * Thus, when the main thread changes the values of the number and ready variables, there is no guarantee that the reading thread will see it. That is, the reading thread might see the updated value either immediately, or with some delay, or never at all!
 *
 * Weak Visibility: Weak visibility in computer systems refers to how changes made by one part of the system (like a processor or a thread) to shared data are not immediately noticeable to other parts of the system. This concept is often discussed in the context of memory models, which define the behavior of memory operations in multi-threaded programs. In stricter memory models, like "sequential consistency", changes to shared data are immediately visible to all parts of the system. However, in weaker models, such as "processor consistency" or "PRAM consistency", there might be delays or different views of the data depending on the part of the system and the timing of the memory accesses. This discrepancy can lead to issues in program correctness, especially in multi-threaded applications where different threads might see different states of the shared data.
 *
 * Memory Reordering: Memory reordering is a phenomenon where the actual execution order of memory operations (like reads and writes) differs from the order specified by the program. This can happen both due to compiler optimizations and the way modern processors work. Compilers and processors might reorder operations for efficiency and speed, taking advantage of out-of-order execution capabilities of the CPU. However, this reordering can cause unexpected behaviors in multi-threaded programs where the order of operations is crucial for correctness. To manage this, memory models and specific memory ordering instructions (like memory barriers) are used to ensure that operations occur in a predictable and required manner, especially in systems with weaker memory models or those that allow more aggressive reordering.
 *
 * In summary, weak visibility is about the delayed or inconsistent visibility of data changes across different parts of a system, while memory reordering refers to the alteration of the execution order of memory operations for optimization purposes. Both concepts are crucial in understanding and designing multi-threaded and concurrent applications, where the timing and order of operations are critical for program correctness.
 *
 * Even when an operation is atomic, immediate recognition of its results by different threads isn’t assured. This lack of guaranteed visibility stems from various factors, including the caching mechanisms of CPUs and the reordering optimizations employed by compilers. These factors can delay or obscure the reflection of changes made by one thread in the memory accessible to other threads.
 *
 * the @Volatile annotation allows us to provide visibility to data changes. Thus, this annotation becomes very useful when you have multithreading in a program and access a block of code in parallel with multiple threads.
 *
 * @see Reader
 * @see number
 * @see ready
 * @see Thread.sleep
 * */
fun main() {
    Reader().start()
    Thread.sleep(100)
    number = 42
    ready = true
}
