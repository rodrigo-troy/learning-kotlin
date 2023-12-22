package delegate

/**
 * This is the main interface for the delegate pattern example.
 * It declares a print method and a msg property that needs to be implemented by any class that uses this interface.
 */
private interface MyInterface {
    fun print()
    val msg: String
}

/**
 * This class implements the MyInterface interface.
 * It provides the implementation for the print method and the msg property.
 */
private class MyImplementation : MyInterface {
    override fun print() {
        println(msg)
    }

    override val msg: String = "MyImplementation sends regards!"
}

/**
 * This class demonstrates the delegate pattern in Kotlin.
 * It takes an instance of a class that implements MyInterface and delegates the implementation of the interface to that instance.
 * It also overrides the msg property to provide its own message.
 */
private class MyNewClass(base: MyInterface) : MyInterface by base {
    override val msg = "Delegate sends regards."
    private val base1 = base

    /**
     * This method demonstrates how to access the original implementation of the interface.
     * It prints the message from the base class.
     */
    fun anotherMethod() {
        println("Another method that prints the message from the base class: ${base1.msg}")
    }
}

/**
 * This is the main function of the program.
 * It creates an instance of MyImplementation and MyNewClass and demonstrates how the delegate pattern works in Kotlin.
 */
private fun main() {
    val myImplementation = MyImplementation()
    val delegate = MyNewClass(myImplementation)
    delegate.print()
    println(delegate.msg)
    delegate.anotherMethod()
}
