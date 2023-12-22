package delegate

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-03-23
 * Time: 13:20
 */
private interface MyInterface2 {
    fun print()
    val amount: Int
}

private class AdditionPrinter : MyInterface2 {
    override fun print() {
        for (i in 1..amount) print("*")
    }

    override val amount: Int = 3 + 7
}

private class SubtractionPrinter : MyInterface2 {
    override fun print() {
        for (i in 1..amount) print("*")
    }

    override val amount: Int = 23 - 15
}

private class MultiplicationPrinter : MyInterface2 {
    override fun print() {
        for (i in 1..amount) print("*")
    }

    override val amount: Int = 3 * 4
}

private class Printer(base: MyInterface2) : MyInterface2 by base {
    override fun print() {
        for (i in 1..amount + 2) print("*")
    }
}

private fun main() {
    val p = Printer(AdditionPrinter())
    p.print()
}
