package aggregate.function

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 29-03-23
 * Time: 12:42
 */
data class Ship(val name: String, val ammunition: Int)

private fun main() {
    val ships = "HMS-100 USS-200 BMS-50 BMS-150 USS-10".split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    val res = shipsList.minByOrNull { it.ammunition }

    println(res)

    val names = listOf("anne", "michael", "caroline", "dimitry", "emilio")
    println(names.maxByOrNull { it.length > 4 })
    println(names.maxByOrNull { it.length })
}
