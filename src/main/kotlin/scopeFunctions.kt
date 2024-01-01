/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 27-03-23
 * Time: 13:25
 * https://kotlinlang.org/docs/scope-private fun ctions.html
 * https://hyperskill.org/learn/step/23478
 *
 * Recommendations:
 *
 * Executing a lambda on non-null objects: let
 * Introducing an expression as a variable in local scope: let
 * Object configuration: apply
 * Object configuration and computing the result: run
 * Running statements where an expression is required: non-extension run
 * Additional effects: also
 * Grouping private function calls on an object: with
 */
data class Musician(var name: String, var instrument: String = "Guitar", var band: String = "Radiohead")

private fun main() {
    val musician = Musician("Jonny Greenwood").apply {
        instrument = "Banjo" // here we can also use this.instrument
    }

    print(musician)

    withExample()

    runExample()

    applyExample()
}

private fun withExample() {
    val musicians = mutableListOf("Thom York", "Jonny Greenwood", "Colin Greenwood")
    with(musicians) {
        println("'with' is called with the argument $this")
        println("List contains $size elements")
    }

    val firstAndLast = with(musicians) {
        "First list element - ${first()}," +
                " last list element - ${last()}"
    }
    println(firstAndLast)
}

private fun applyExample() {
    val numbers = mutableListOf<Int>()
    numbers.also { println("Let's add some elements in this list") }
        .apply {
            add(2)
            add(3)
            add(1)
        }
        .also { println("And now let's sort these elements in the list") }
        .sort() // also() and sort() get as a parameter our changed context object - numbers
    println(numbers)
}

private fun runExample() {
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]+")
    }

    for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")) {
        println(match.value)
    }
}
