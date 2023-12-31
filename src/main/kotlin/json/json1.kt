package json

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-12-23
 * Time: 20:41
 */
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class Test(
    val name: String,
    val integerNumber: Int,
    val realNumber: Double,
    val listString: List<String>,
    val setInteger: Set<Int>
)

fun main() {
    val listStr = listOf("One", "Two", "Three")
    val setNum = setOf(1, 0, 2, 9)
    val instance = Test("test", 42, 15.55, listStr, setNum)

    val serialized = Json.encodeToString(instance)
    println(serialized)
}
