import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.until
import java.io.File
import java.util.*
import kotlin.math.absoluteValue


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
    printThirdRow()
}


fun printThirdRow() {
    val inputArray = arrayOf(
        arrayOf("(¬‿¬)_", "Program"),
        arrayOf("_(^.^)/", "with"),
        arrayOf("(>^_^)>", "Kotlin!")
    )

    print(inputArray[2].joinToString(" "))
}

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

fun countDivisibleNumbers(
    a: Int,
    b: Int,
    n: Int
): Int = (a..b).count { it % n == 0 }.also { println(it) }

fun createSizeClass() {
    val size = Size(
        10,
        20
    )
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

fun printColors() {
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

fun splitString(
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

fun f(n: Int): Int = if (n > 2) f(n - 1) + f(n - 2) + f(n - 3) else n

fun destructuring() {
    val (first, last, age) = readln().split(" ")
    println("${first.uppercase(Locale.getDefault()).first()}. $last, $age years old")
}

fun getPercentage() {
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

fun daysDifference(date1: String, date2: String): Int {
    val d1 = LocalDate.parse(date1)
    val d2 = LocalDate.parse(date2)

    return d1.until(d2, DateTimeUnit.DAY).absoluteValue
}

fun printLine() = List(5) { readln() }
    .map { "$it " }
    .forEach(::print)

fun invertArray() {
    //Do not touch code below
    var inputArray: Array<Array<String>> = arrayOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toTypedArray()
        inputArray += strings
    }
    val newArray = arrayOf(inputArray[inputArray.size - 1].reversedArray(), inputArray[0].reversedArray())

    println(newArray.contentDeepToString())

}

fun findAvailableSpace(args: Array<String>) {
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

fun printInvertedString() {
    val str = "Hello, Kotlin"
    var i = str.lastIndex
    while (i >= 1) {
        print(str[i])
        i--
    }
}

fun checkRange() {
    val (a, b, c, d, n) = List(5) { readln().toInt() }
    val range1 = a..b
    val range2 = c..d
    println(n in range1 || n in range2)
}
