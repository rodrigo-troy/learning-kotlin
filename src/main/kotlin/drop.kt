/**
 * The main function is the entry point of the program. It demonstrates the usage of various list
 * manipulation methods from the Kotlin standard library.
 */
private fun main() {
    val list = listOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    )

    val drop = list.drop(5)
    println("drop: $drop")

    val droplast = list.dropLast(5)
    println("dropLast: $droplast")
    println(list.dropWhile { it < 5 })
    println(list.dropWhile { it == 1 })
    println(list.dropWhile { it == 2 })

    val dropWhile12 = list.dropWhile { it == 1 || it == 2 }
    println("dropWhile: $dropWhile12")
    println(list.dropLastWhile { it > 5 })
}
