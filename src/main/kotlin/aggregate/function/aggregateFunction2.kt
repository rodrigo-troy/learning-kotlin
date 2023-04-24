package aggregate.function

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 29-03-23
 * Time: 12:42
 */
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val empty: List<Int> = emptyList()

    println("minOrNull: ${numbers.minOrNull()}")
    println("Empty: ${empty.minOrNull()}")
    println("maxOrNull: ${numbers.maxOrNull()}")
    println("min: ${numbers.min()}")
    println("average: ${numbers.average()}")
    println("average: ${empty.average()}")
    println("sum: ${numbers.sum()}")
    println("sum: ${empty.sum()}")
    println("count: ${numbers.count()}")
    println("count { it % 2 == 0 }: ${numbers.count { it % 2 == 0 }}")
    println()

    val words = listOf("anne", "michael", "caroline", "dimitry", "emilio")
    println("count: ${words.count()}")
    println("count { it.length > 5 }: ${words.count { it.length > 5 }}")
    println("count { it.first() == 'a' }: ${words.count { it.first() == 'a' }}")

    println("maxByOrNull { it.length }: ${words.maxByOrNull { it.length }}")
    println("maxByOrNull { it.length > 5  }: ${words.maxByOrNull { it.length > 5 }}")
    println("minByOrNull { it.length }: ${words.minByOrNull { it.length }}")

    println("maxOfOrNull { it.length }: ${words.maxOfOrNull { it.length }}")
    println("minOfOrNull { it.length }: ${words.minOfOrNull { it.length }}")

    println("sumOf { it.length }: ${words.sumOf { it.length }}")


    // emptyList
    val emptyWordsList = emptyList<String>()
    println(emptyWordsList.count()) // 0
    println(emptyWordsList.maxByOrNull { it.length }) // null
    println(emptyWordsList.minByOrNull { it.length }) // null
    println(emptyWordsList.maxOfOrNull { it.length }) // null
    println(emptyWordsList.minOfOrNull { it.length }) // null

    try {
        println(emptyWordsList.maxOf { it.length })  // NoSuchElementException
        println(emptyWordsList.minOf { it.length })  // NoSuchElementException
        println(emptyWordsList.maxBy { it.length })  // NoSuchElementException
        println(emptyWordsList.minBy { it.length })  // NoSuchElementExceptio
    } catch (e: Exception) {
        println(e)
    }

    println(words.maxWithOrNull(compareBy { it.length }))
    println(words.minWithOrNull(compareBy { it.length }))

    println(words.maxOfWithOrNull(naturalOrder()) { it.length })
    println(words.minOfWithOrNull(naturalOrder()) { it.length })
    println(words.sortedWith(compareBy { it.length }).reversed())
    println(words.sortedWith(compareBy { it[it.length / 2] }).reversed())
}
