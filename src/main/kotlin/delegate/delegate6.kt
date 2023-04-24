package delegate

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-03-23
 * Time: 13:20
 */
interface ICounter {
    var count: Int
    fun increaseCount()
    fun getCurrentCount(): Int
}

class Counter(override var count: Int) : ICounter {
    // In case we need to count differently, this function can be altered
    override fun increaseCount() {
        count++
    }

    override fun getCurrentCount(): Int = count
}

// Do not change the code above

class Iterator(base: ICounter) : ICounter by base {
    fun next() {
        increaseCount()
    }
}

// Do not change the code below

fun main() {
    val a = readln().toInt()
    val counter = Counter(a)
    val it = Iterator(counter)

    for (i in 1..5) {
        it.next()
    }

    println(it.getCurrentCount())
}
