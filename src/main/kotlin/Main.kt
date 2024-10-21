import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.until
import java.io.File
import java.util.*
import kotlin.math.PI
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt


fun main(args: Array<String>) {
    //printInvertedString()
    //findAvailableSpace(args)
    //printLine()
    //getPercentage()
    //destructuring()
    /* countDivisibleNumbers(-10,
                           10,
                           5)*/
    /* splitString("Hello, world! I am a Kotlin programmer. I love Kotlin!",
                 3)*/
    //printColors()
    //println(f(6))
    //println(daysDifference("2020-01-01", "2020-01-02"))
    //printThirdRow()
    //printMaxValue()
    checkEquals()
}

private const val pi = PI

private fun printMaxValue() = println(generateSequence { readln().toInt() }.takeWhile { it != 0 }.maxOrNull())

private fun calculateArea() {
    when (readLine()) {
        "triangle" -> {
            val (a, b, c) = List(3) { readln().toDouble() }
            val p = (a + b + c) / 2
            println(sqrt(p * (p - a) * (p - b) * (p - c)))
        }

        "rectangle" -> {
            val result = List(2) { readln().toDouble() }.reduce { acc, d -> acc * d }
            println(result)
        }

        "circle" -> {
            val r = readln().toDouble()
            println(pi * r.pow(2))
        }
    }
}

private fun printThirdRow() {
    val inputArray = arrayOf(
        arrayOf(
            "(¬‿¬)_",
            "Program"
        ),
        arrayOf(
            "_(^.^)/",
            "with"
        ),
        arrayOf(
            "(>^_^)>",
            "Kotlin!"
        )
    )

    print(inputArray[2].joinToString(" "))
}

private fun printMatrix(matrix: Array<IntArray>) {
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

private fun printDogFace() {
    println("   ^__^")
    println("  (oo)\\_______")
    println("  (__)\\       )\\/\\")
    println("      ||----w |")
    println("      ||     ||")
}

private fun countDivisibleNumbers(
    a: Int,
    b: Int,
    n: Int
): Int = (a..b).count { it % n == 0 }.also { println(it) }

private fun createSizeClass() {
    val size = Size(
        10,
        20
    )
    println("The area is ${size.area}")
}

private fun createByteTimer() {
    val timer = ByteTimer(200)
    println(timer.time)
}

/**
 * Checks if the sum of the digits in the first half of the input string is equal to
 * the sum of the digits in the second half of the input string.
 *
 * The function reads a string input, splits it into two halves, converts each half
 * to a list of integers, and then calculates the sum of the digits in each half.
 * It prints "YES" if the sums are equal, otherwise it prints "NO".
 */
private fun luckyNumber() {
    val num = readln()
    val num1 = num.substring(
        0,
        num.length / 2
    ).map { it.digitToInt() }.sum()
    val num2 = num.substring(num.length / 2).map { it.digitToInt() }.sum()

    if (num1 == num2) {
        println("YES")
    } else {
        println("NO")
    }
}

private fun printColors() {
    // Set foreground colors
    for (i in 30..37) print("\u001b[${i}m ${"%3d".format(i)}  ")
    for (i in 90..97) print("\u001b[${i}m ${"%3d".format(i)}  ")

// Reset colors
    println("\u001B[0m")

// Set background colors
    for (i in 40..47) print("\u001b[${i}m ${"%3d".format(i)}  ")
    for (i in 100..107) print("\u001b[${i}m ${"%3d".format(i)}  ")

// Reset colors
    println("\u001B[0m")
    println()

    println("Standard foreground colors")
    for (i in 0..15) print("\u001b[38;5;${i}m ${"%3d".format(i)}")

    println()
    println()
    print("216 foreground colors")
    for (i in 16..231) {
        if ((i - 16) % 36 == 0) println()
        print("\u001b[38;5;${i}m ${"%3d".format(i)}")
    }
    println("\u001B[0m")
    println()

    println("Foreground grayscale shades")
    for (i in 232..255) print("\u001b[38;5;${i}m ${"%3d".format(i)}")
    println()

    println("Standard background colors")
    for (i in 0..15) print("\u001b[48;5;${i}m ${"%3d".format(i)}")
    println("\u001B[0m")
    println()
    print("216 background colors")
    for (i in 16..231) {
        if ((i - 16) % 36 == 0) println("\u001B[0m")
        print("\u001b[48;5;${i}m ${"%3d".format(i)}")
    }
    println("\u001B[0m")
    println()
    println("Background grayscale shades")
    for (i in 232..255)
        print("\u001b[48;5;${i}m ${"%3d".format(i)}")
    println("\u001B[0m")

    println("Done!")
}

private fun splitString(
    text: String,
    pieces: Int
) {
    //create a whitespace regex
    val regex = Regex("\\s+")
    val result = text.split(
        regex,
        pieces
    )
    result.forEach(::println)
}

private fun computeSum(n: Int): Int = if (n > 2) computeSum(n - 1) + computeSum(n - 2) + computeSum(n - 3) else n

private fun destructuring() {
    val (first, last, age) = readln().split(" ")
    println("${first.uppercase(Locale.getDefault()).first()}. $last, $age years old")
}

private fun getPercentage() {
    Scanner(File("file.txt")).use { sc ->
        val number = sc.nextInt()
        println(number * 100)
    }

    Scanner(File("file.txt")).use { scanner ->
        val number = scanner.nextInt()
        println(number * 100)
    }

    val letters = listOf(
        'c',
        'g'
    )
    var count = 0

    val word = readln().lowercase(Locale.getDefault())
    for (c in word) {
        if (letters.contains(c)) {
            count++
        }
    }

    println(count.toDouble() / word.length * 100)
}

private fun daysDifference(date1: String, date2: String): Int {
    val d1 = LocalDate.parse(date1)
    val d2 = LocalDate.parse(date2)

    return d1.until(
        d2,
        DateTimeUnit.DAY
    ).absoluteValue
}

private fun printLine() = List(5) { readln() }
    .map { "$it " }
    .forEach(::print)

private fun checkEquals() = List(2) { readln() }.let { (a, b) -> println(a.reversed() == b) }

private fun printName() = List(2) { readln() }.let { (a, b) -> println("${a.first()}. $b") }

fun reversed(args: Array<String>) {
    // Step 1: Read a line of text from the standard input
    val line = readLine()!!

    // Step 2: Split the line into words
    val words = line.split(" ")

    // Step 3: Reverse the words and print the result
    println(words.reversed().joinToString(" "))
}


private fun invertArray() {
    var inputArray: Array<Array<String>> = arrayOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toTypedArray()
        inputArray += strings
    }
    val newArray = arrayOf(
        inputArray[inputArray.size - 1].reversedArray(),
        inputArray[0].reversedArray()
    )

    println(newArray.contentDeepToString())
}

private fun findAvailableSpace(args: Array<String>) {
    println("Program arguments: ${args.joinToString()}")

    val field = Array(5) { IntArray(5) { 0 } }
    val split1 = readln().split(" ")
    val split2 = readln().split(" ")
    val split3 = readln().split(" ")
    val occupiedCells = listOf(
        Pair(
            split1[0].toInt(),
            split1[1].toInt()
        ),
        Pair(
            split2[0].toInt(),
            split2[1].toInt()
        ),
        Pair(
            split3[0].toInt(),
            split3[1].toInt()
        )
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

private fun printInvertedString() {
    val str = "Hello, Kotlin"
    var i = str.lastIndex
    while (i >= 1) {
        print(str[i])
        i--
    }
}

private fun checkRange() {
    val (a, b, c, d, n) = List(5) { readln().toInt() }
    val range1 = a..b
    val range2 = c..d
    println(n in range1 || n in range2)
}

private fun <T> getStringsOnly(list: List<T>): List<String> {
    val result = list.filterIsInstance<String>()

    return result
}
