package interfaces.composition

/**
 * The PrinterInterface defines the methods for printing.
 *
 * This interface provides the following methods:
 * - printSomething(): Prints "something".
 * - printSomethingElse(): Prints "something else".
 */

private interface PrinterInterface {
    fun printSomething() = println("something")
    fun printSomethingElse() = println("something else")
}

/**
 * The NewLinePrinterInterface defines an interface for classes that can print something and something else
 * with a new line.
 */
private interface NewLinePrinterInterface {
    fun printSomething() = println("new line something")
    fun printSomethingElse() = println("new line something else")
}

/**
 * This class represents a MultiPrinterClass that implements the PrinterInterface and NewLinePrinterInterface.
 * It provides functionality to print different messages using the implemented interfaces.
 */
private class MultiPrinterClass : PrinterInterface, NewLinePrinterInterface {
    override fun printSomething() = println("classy something")

    override fun printSomethingElse() {
        super<PrinterInterface>.printSomething()
    }
}

/**
 * This is the main method that serves as the entry point for the application.
 * It demonstrates the usage of different interfaces implemented by the MultiPrinterClass.
 */
private fun main() {
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
