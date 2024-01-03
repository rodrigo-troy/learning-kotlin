package threads.callable

import java.time.LocalDateTime
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 03-01-24
 * Time: 17:51
 */
fun main() {
    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Start counting")

    val generator: Callable<Int> = Callable {
        TimeUnit.SECONDS.sleep(5)
        println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - Returning value")
        70000
    }

    println("${LocalDateTime.now()} - Thread ID: ${Thread.currentThread().id} - ${generator.call()}")
}
