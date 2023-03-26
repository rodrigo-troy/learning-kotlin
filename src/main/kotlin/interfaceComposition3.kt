/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 26-03-23
 * Time: 19:49
 */

interface PrinterInterface {
    fun printSomething() = print("something")
    fun printSomethingElse() = print("something else")
}

interface NewLinePrinterInterface {
    fun printSomething() = println("new line something")
    fun printSomethingElse() = println("new line something else")
}

class MultiPrinterClass : PrinterInterface, NewLinePrinterInterface {
    override fun printSomething() = print("classy something")

    override fun printSomethingElse() {
        super<PrinterInterface>.printSomething()
    }
}

fun main() {
    val multiPrinterClass = MultiPrinterClass()
    multiPrinterClass.printSomething()
    multiPrinterClass.printSomethingElse()

    val printerInterface: PrinterInterface = multiPrinterClass
    printerInterface.printSomething()
    printerInterface.printSomethingElse()

    val newLinePrinterInterface: NewLinePrinterInterface = multiPrinterClass
    newLinePrinterInterface.printSomething()
    newLinePrinterInterface.printSomethingElse()
}
