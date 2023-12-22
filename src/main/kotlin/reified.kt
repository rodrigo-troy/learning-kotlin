/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 02-05-23
 * Time: 17:25
 */
private inline fun <reified T> filterByType(list: List<Any>): List<T> {
    val newList = mutableListOf<T>()
    for (item in list) {
        if (item is T) {
            newList.add(item)
        }
    }
    return newList
}

private inline fun <reified T> filterByType2(list: List<Any>): List<T> {
    return list.filterIsInstance<T>()
}

private fun main() {
    val mixedList = listOf("Kotlin", 1, 2, 3, "Java", "Android", 4, 5, 6)
    val stringList1: List<String> = filterByType(mixedList)
    println(stringList1)

    val stringList2: List<String> = filterByType2(mixedList)
    println(stringList2)
}
