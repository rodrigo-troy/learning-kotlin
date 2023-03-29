/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 29-03-23
 * Time: 14:49
 *An inline function is a function that is expanded at the call site instead of being executed as a separate function call. In other words, the body of an inline function is copied and pasted directly into the calling code, just like a macro in C/C++ or a template in C++.
 *
 * By default, all functions in Kotlin are non-inline, meaning that they are executed as separate function calls. However, when we mark a function as inline, the compiler replaces the function call with the function's body. This reduces the overhead of the function call as well as the creation of unnecessary objects.
 *
 * In this example, we define an inline function called measureTimeMillis that takes a lambda expression as a parameter. The lambda expression is expected to perform some time-consuming operation, which we want to measure. Inside the measureTimeMillis function, we first record the start time using System.currentTimeMillis(), then call the lambda expression, and finally subtract the start time from the current time to get the total time taken.
 *
 * By marking the measureTimeMillis function as inline, the Kotlin compiler will replace any calls to this function with the actual code inside the function body at compile time. This means that there will be no function call overhead at runtime, which can be beneficial for performance-critical code.
 *
 * In the main function, we call the measureTimeMillis function and, using Thread.sleep(1000), pass a lambda expression that sleeps for one second. The time taken for this operation is returned by measureTimeMillis and stored in the time variable, which is then printed to the console.
 *
 * In Kotlin, functions are stored in memory in the same way as any other object. When a function is defined in code, it is compiled into bytecode and can then be loaded into memory during program execution.
 *
 * When the function is called, its code is loaded into memory, and the processor begins to execute this code. Like other objects, functions are stored in the heap, a memory area allocated for storing objects during program execution. When you create a function in a heap, enough memory is allocated to store it, including the function code and any variables or objects needed to run it.
 *
 * It is important to understand that each time a function is called, a new instance of the function is created in memory. This means that if a function is called repeatedly, many instances of that function will be created in memory.
 *
 * Overall, inline functions can be a powerful tool in Kotlin for optimizing performance-critical code by eliminating function call overhead. However, they should be used with care, as inlining too much code can lead to an increased binary size and longer compile time. */
inline fun measureTimeMillis(block: () -> Unit): Long {
    val startTime = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - startTime
}

fun main() {
    val time = measureTimeMillis {
        // do some time-consuming operation
        Thread.sleep(1000)
    }
    println("Time taken: $time milliseconds")
}
