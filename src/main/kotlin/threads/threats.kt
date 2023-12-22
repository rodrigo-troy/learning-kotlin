private fun main() {
    val t: Thread = Thread.currentThread() // main thread

    println("Name: ${t.name}")
    println("ID: ${t.id}")
    println("Alive: ${t.isAlive}")
    println("Priority: ${t.priority}")
    println("Daemon: ${t.isDaemon}")
}
