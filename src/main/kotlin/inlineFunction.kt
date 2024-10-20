/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 29-03-23
 * Time: 14:49
 *
 * An inline private fun ction in Kotlin is a private fun ction that is expanded at the call site instead of being executed as a separate private fun ction call. In simpler terms, the body of an inline private fun ction is copied and pasted directly into the calling code, similar to a macro in C/C++ or a template in C++.
 *
 * By default, all private fun ctions in Kotlin are non-inline, which means that they are executed as separate private fun ction calls. However, marking a private fun ction as inline enables the compiler to replace the private fun ction call with the private fun ction's body. This reduces the overhead of the private fun ction call, as well as the creation of unnecessary objects.
 *
 * For instance, we can define an inline private fun ction called measureTimeMillis that takes a lambda expression as a parameter. The lambda expression is expected to perform a time-consuming operation that we want to measure. In the measureTimeMillis private fun ction, we first record the start time using System.currentTimeMillis(), then call the lambda expression, and finally subtract the start time from the current time to get the total time taken.
 *
 * Marking the measureTimeMillis private fun ction as inline instructs the Kotlin compiler to replace any calls to this private fun ction with the actual code inside the private fun ction body at compile time. This means that there will be no private fun ction call overhead at runtime, which can be beneficial for performance-critical code.
 *
 * In the main private fun ction, we call the measureTimeMillis private fun ction and pass a lambda expression that sleeps for one second using Thread.sleep(1000). The time taken for this operation is returned by measureTimeMillis and stored in the time variable, which we then print to the console.
 *
 * private fun ctions in Kotlin are stored in memory the same way as any other object. When a private fun ction is defined in code, it is compiled into bytecode and can then be loaded into memory during program execution. When the private fun ction is called, its code is loaded into memory, and the processor begins to execute this code. private fun ctions are stored in the heap, which is a memory area allocated for storing objects during program execution. When you create a private fun ction in a heap, enough memory is allocated to store it, including the private fun ction code and any variables or objects needed to run it.
 *
 * It's essential to note that each time a private fun ction is called, a new instance of the private fun ction is created in memory. This means that if a private fun ction is called repeatedly, multiple instances of that private fun ction will be created in memory.
 *
 * Overall, inline private fun ctions can be a powerful tool in Kotlin for optimizing performance-critical code by eliminating private fun ction call overhead. However, they should be used with care, as inlining too much code can lead to an increased binary size and longer compile time.*/
private inline fun measureTimeMillis(block: () -> Unit): Long {
    val startTime = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - startTime
}

private fun main() {
    val time = measureTimeMillis {
        // do some time-consuming operation
        Thread.sleep(1000)
    }
    println("Time taken: $time milliseconds")
}
