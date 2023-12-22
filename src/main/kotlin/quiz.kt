/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 09-02-23
 * Time: 18:32
 */
private fun main() {
    val quizAnswer1 = 15
    var quizAnswer2 = 3
    val quizAnswer3 = "isosceles"
    val quizAnswer4 = 47

    // Write your code below
    println("What is 75 / 5?")
    val studentAnswer1 = readln().toInt()
    println("What is the value of y in the equation: 6 * 2y = 36?")
    val studentAnswer2 = readln().toInt()
    println("What is the name of the type of triangle that has two equal sides.")
    val studentAnswer3 = readlnOrNull()
    println("What is the value of 8 * 6 - (3 - 2)?")
    val studentAnswer4 = readln().toInt()

    var points = 0

    if (studentAnswer1 == quizAnswer1) {
        points += 25
    }

    when (studentAnswer2) {
        quizAnswer2 -> {
            points += 25
        }

        quizAnswer2++, quizAnswer2-- -> {
            points += 20
        }

        else -> {
            points++
        }
    }

    when (studentAnswer3) {
        quizAnswer3 -> {
            points += 25
        }

        "equilateral" -> {
            points += 10
        }

        else -> {
            points++
        }
    }

    when (studentAnswer4) {
        quizAnswer4 -> {
            points += 25
        }

        in 44..54 -> {
            points += 20
        }

        else -> {
            points++
        }
    }

    when (points) {
        in 0..59 -> println("You received an F")
        in 60..69 -> println("You received a D")
        in 70..79 -> println("You received a C")
        in 80..89 -> println("You received a B")
        in 90..100 -> println("You received an A")
        in 101..110 -> println("You received an A+")
    }
}
