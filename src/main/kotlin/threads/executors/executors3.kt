package threads.executors

import java.time.LocalTime
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import kotlin.random.Random

private const val TASK_NUMBER = 25

fun main() {
    val executor = Executors.newCachedThreadPool() as ThreadPoolExecutor
    println("Pool size: ${executor.poolSize}")

    println("${LocalTime.now()}: Let's submit $TASK_NUMBER tasks to the executor")
    for (i in 1..TASK_NUMBER) {
        println("${LocalTime.now()}: Adding task $i to the executor")
        TimeUnit.MILLISECONDS.sleep(100)
        executor.submit {
            val sleepTime = Random.nextLong(6000L)
            println("${LocalTime.now()}: Task $i is being executed by ${Thread.currentThread().name} and will sleep for $sleepTime ms")
            TimeUnit.MILLISECONDS.sleep(sleepTime)
            println("${LocalTime.now()}: Task $i completed by ${Thread.currentThread().name}")
        }
    }

    println("${LocalTime.now()}: All tasks submitted, let's shutdown the executor and wait for all tasks to finish...")
    executor.shutdown()

    val terminated = executor.awaitTermination(3, TimeUnit.SECONDS)

    if (terminated) {
        println("${LocalTime.now()}: The executor was successfully stopped")
    } else {
        println("\n${LocalTime.now()}: === Timeout elapsed before termination ===")
    }

    println("${LocalTime.now()}: Completed task count: ${executor.completedTaskCount}")
    println("${LocalTime.now()}: Pool size: ${executor.poolSize}\n")
}
