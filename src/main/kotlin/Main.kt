import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun printMatrix(matrix: Array<IntArray>) {
    println()
    print("Cinema:\n  ")
    (1..matrix[0].size).forEach { i ->
        print("$i ")
    }

    println()

    matrix.indices.forEach { i ->
        print("${i + 1} ")
        matrix[i].indices.forEach { j ->
            print("${matrix[i][j]} ")
        }
        println()
    }

    println()
}

fun printDogFace() {
    println("   ^__^")
    println("  (oo)\\_______")
    println("  (__)\\       )\\/\\")
    println("      ||----w |")
    println("      ||     ||")
}

fun countDivisibleNumbers(a: Int,
                          b: Int,
                          n: Int): Int = (a..b).count { it % n == 0 }.also { println(it) }

fun createSizeClass() {
    val size = Size(10,
                    20)
    println("The area is ${size.area}")
}

fun createByteTimer() {
    val timer = ByteTimer(200)
    println(timer.time)
}

//Given the number N with an even number of digits.
// If the sum of the first half of the digits equals the sum of the second half of the digits, then this number is considered lucky.
// For a given number, output "YES" if this number is lucky, otherwise output "NO".
fun luckyNumber() {
    val num = readln()
    val num1 = num.substring(0,
                             num.length / 2).map { it.digitToInt() }.sum()
    val num2 = num.substring(num.length / 2).map { it.digitToInt() }.sum()

    if (num1 == num2) {
        println("YES")
    } else {
        println("NO")
    }
}

fun splitString(text: String,
                pieces: Int) {
    //create a whitespace regex
    val regex = Regex("\\s+")
    val result = text.split(regex,
                            pieces)
    result.forEach(::println)
}

fun main(args: Array<String>) {
    //printInvertedString()
    //findAvailableSpace(args)
    //printLine()
    //convertDate()
    //getPercentage()
    //destructuring()
    countDivisibleNumbers(-10,
                          10,
                          5)
    splitString("Hello, world! I am a Kotlin programmer. I love Kotlin!",
                3)
}

fun destructuring() {
    val (first, last, age) = readln().split(" ")
    println("${first.uppercase(Locale.getDefault()).first()}. $last, $age years old")
}

fun getPercentage() {
    val letters = listOf('c',
                         'g')
    var count = 0

    val word = readln().lowercase(Locale.getDefault())
    for (c in word) {
        if (letters.contains(c)) {
            count++
        }
    }

    println(count.toDouble() / word.length * 100)
}

fun convertDate() {
    val date = "2019-12-31"
    val formattedDate = LocalDate.parse(date,
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    println(formattedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))

}

fun printLine() = List(5) { readln() }
    .map { "$it " }
    .forEach(::print)

fun findAvailableSpace(args: Array<String>) {
    println("Program arguments: ${args.joinToString()}")

    val field = Array(5) { IntArray(5) { 0 } }
    val split1 = readln().split(" ")
    val split2 = readln().split(" ")
    val split3 = readln().split(" ")
    val occupiedCells = listOf(
            Pair(split1[0].toInt(),
                 split1[1].toInt()),
            Pair(split2[0].toInt(),
                 split2[1].toInt()),
            Pair(split3[0].toInt(),
                 split3[1].toInt())
    )

    occupiedCells.forEach { println(it) }

    for (pair in occupiedCells) {
        field[pair.first - 1][pair.second - 1] = 1
    }

    val emptyRows = mutableListOf<Int>()
    val emptyColumns = mutableListOf<Int>()

    for (i in field.indices) {
        if (field[i].sum() == 0) {
            emptyRows.add(i + 1)
        }

        if (field.sumOf { it[i] } == 0) {
            emptyColumns.add(i + 1)
        }
    }

    println(emptyRows.distinct().joinToString(" "))
    println(emptyColumns.distinct().joinToString(" "))
}

fun printInvertedString() {
    val str = "Hello, Kotlin"
    var i = str.lastIndex
    while (i >= 1) {
        print(str[i])
        i--
    }
}
