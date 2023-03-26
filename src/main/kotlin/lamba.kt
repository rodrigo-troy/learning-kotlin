/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 25-03-23
 * Time: 21:37
 */
class MagicClass(val magic: Int) {

    fun magicFun(a: Int): Int {
        return a * magic
    }
}

data class Spell(val name: String, val power: Int)

fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    val res = spells.filter { it.power >= 40 }.map { it.name }

    println(res)
}


fun builderString(
    builder: StringBuilder.(String) -> Unit
): String {
    val stringBuilder = StringBuilder()
    stringBuilder.builder("")
    return stringBuilder.toString()
}
