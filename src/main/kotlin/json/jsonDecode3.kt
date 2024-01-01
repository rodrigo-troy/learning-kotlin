package json

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-12-23
 * Time: 20:59
 */
@Serializable
data class Person(val name: String)


/**
 * The main function is the entry point of the program.
 * It demonstrates the usage of the Kotlin Serialization library to encode and decode a list of Person objects into JSON format.
 *
 * Kotlin List and Set types are serializable if their elements are serializable,
 * while Kotlin Map is serializable if its keys and values are serializable.
 */
fun main() {
    val persons = listOf(Person("Joe Hill"), Person("Elen Doe"))
    println(persons)

    val jsonStr = Json.encodeToString(persons)
    println(jsonStr)

    val newPersons = Json.decodeFromString<List<Person>>(jsonStr)
    println(newPersons)
}
