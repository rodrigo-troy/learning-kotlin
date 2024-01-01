package json

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-12-23
 * Time: 20:59
 */
@Serializable
data class AnotherTest(
    val name: String,
    val integerNumber: Int,
    val realNumber: Double,
    val listString: List<String>,
    val setInteger: Set<Int>
)

val jsonString = """
    {
        "name": "myName",
        "integerNumber": 10,
        "realNumber": 12.0,
        "listString": [
            "First String",
            "Second String"
        ],
        "setInteger": [
            1000,
            2000
        ]
    }
""".trimIndent()

fun main() {
    val instance = Json.decodeFromString<AnotherTest>(jsonString)
    println(instance)
}
