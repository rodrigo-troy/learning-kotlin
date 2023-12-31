package json

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-12-23
 * Time: 20:41
 */
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ExperimentalSerializationApi
@Serializable
class Player(val name: String, @EncodeDefault var level: Int = 1)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val jsonPrettyPrint = Json { prettyPrint = true }
    val player1 = Player("Best player", 5)
    println(jsonPrettyPrint.encodeToString(player1))

    val player2 = Player("John Doe")
    println(jsonPrettyPrint.encodeToString(player2))
}
