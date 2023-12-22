/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 01-04-23
 * Time: 17:58
 */
private data class Ship2(val name: String, val ammunition: Int)

private fun main() {
    val ships = "XWing-100 YWing-200 TWing-50 TIEFighter-300".split(" ")
    val shipsList = ships.map {
        Ship2(
            it.split("-")[0],
            it.split("-")[1].toInt()
        )
    }

    val chunked: List<List<Ship2>> = shipsList.chunked(3)
    println("chunked: $chunked")

    val averages: List<Int> = chunked.map { it.map { it.ammunition }.average().toInt() }
    println("averages: $averages")


}
