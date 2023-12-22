/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 01-04-23
 * Time: 17:26
 */
private fun main() {
    val listNumbers: List<Int> = listOf(
        1,
        2,
        3,
        4,
        5
    )
    println("listNumbers: $listNumbers")

    val listStrings: List<String> = listOf(
        "one",
        "two",
        "three",
        "four",
        "five"
    )
    println("listStrings: $listStrings")

    val zipped: List<Pair<Int, String>> = listNumbers.zip(listStrings)
    println("zipped: $zipped")


    val unzipped: Pair<List<Int>, List<String>> = zipped.unzip()
    println("unzipped: $unzipped")

    val numbers: List<Int> = listOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    )

    val zippedWithDifferentLength: List<Pair<Int, String>> = numbers.zip(listStrings)
    println("zippedWithDifferentLength: $zippedWithDifferentLength")

    val zippedWithTransform: List<String> = numbers.zip(listStrings) { number, string ->
        "$number - $string"
    }

    println("zippedWithTransform: $zippedWithTransform")

    val associatedWith: Map<String, Int> = listStrings.associateWith { it.length }
    println("associatedWith: $associatedWith")

    val associatedBy: Map<String, String> = listStrings.associateBy { it.first().uppercase() }
    println("associatedBy: $associatedBy")

    val associatedWithLambda: Map<String, Int> = listStrings.associate {
        it.first().uppercase() to it.length
    }
    println("associatedWithLambda: $associatedWithLambda")

    val joinToString: String = numbers.joinToString(
        separator = " ; ",
        prefix = "{ ",
        postfix = " }",
        limit = 3,
        truncated = "..."
    )
    println("joinToString: $joinToString")

    val joinTo = numbers.joinTo(
        StringBuilder(),
        separator = " ; ",
        prefix = "{ ",
        postfix = " }",
        limit = 3,
        truncated = "..."
    )
    println("joinTo: $joinTo")
}
