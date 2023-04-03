fun main() {
    val words = listOf("anne",
                       "michael",
                       "caroline",
                       "dimitry",
                       "emilio")
    println(words.sortedBy { it.last() }.reversed())

    val list = listOf(1,
                      2,
                      3,
                      4,
                      5,
                      6,
                      7,
                      8,
                      9,
                      10)

    //Please order them with the following criteria: odd elements first, then even elements.

    println(list.sortedBy { it % 2 == 0 })
}
