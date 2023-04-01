/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 01-04-23
 * Time: 17:09
 */
class BiggerBox<T>(var value1: T, var value2: T) {}

fun <T> BiggerBox<T>.changeBoxes() {
    val tmp = this.value1
    this.value1 = this.value2
    this.value2 = tmp
}

fun main() {
    val box: BiggerBox<String> = BiggerBox("hyperskill",
                                           "kotlin")
    println("${box.value1} and ${box.value2}")
    box.changeBoxes()
    println("${box.value1} and ${box.value2}")
}


class SomeCollection<T>(val list: List<T>) {
    fun <T> invert(list: List<T>) {
        val invertedList = list.reversed()
        println(invertedList.joinToString(separator = "\n"))
    }
}

//Define and implement a generic method info inside the companion object Info that accepts a generic list and returns the contents of the input list as a String. If the list is empty, return "[]". You do not need to print the result.

// Do not change code below
class Info {
    companion object Info {
        fun <T> info(list: List<T>): String {
            return if (list.isEmpty()) {
                "[]"
            } else {
                list.joinToString(prefix = "[",
                                  postfix = "]")
            }
        }
    }
}
