private fun main() {
    printThreadInfo()
}

fun printThreadInfo() {
    val t: Thread = Thread.currentThread() // main thread
    println()
    println("*** Thread info ***")
    println("ID: ${t.id}")
    println("Name: ${t.name}")
    println("Alive: ${t.isAlive}")
    println("Priority: ${t.priority}")
    println("Daemon: ${t.isDaemon}")
    println("Interrupted: ${t.isInterrupted}")
    println("State: ${t.state}")
    println("Class: ${t.javaClass}")
    println("Thread group: ${t.threadGroup}")
    println("Context class loader: ${t.contextClassLoader}")
    println("*******************")
    println()
}
