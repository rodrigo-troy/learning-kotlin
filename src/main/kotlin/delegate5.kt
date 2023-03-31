/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-03-23
 * Time: 13:20
 */
interface MyInterface2 {
    fun print()
    val amount: Int
}

class AdditionPrinter : MyInterface2 {
    override fun print() {
        for (i in 1..amount) print("*")
    }

    override val amount: Int = 3 + 7
}

class SubtractionPrinter : MyInterface2 {
    override fun print() {
        for (i in 1..amount) print("*")
    }

    override val amount: Int = 23 - 15
}

class MultiplicationPrinter : MyInterface2 {
    override fun print() {
        for (i in 1..amount) print("*")
    }

    override val amount: Int = 3 * 4
}

class Printer(base: MyInterface2) : MyInterface2 by base {
    override fun print() {
        for (i in 1..amount + 2) print("*")
    }
}

fun main() {
    val p = Printer(AdditionPrinter())
    p.print()
}
