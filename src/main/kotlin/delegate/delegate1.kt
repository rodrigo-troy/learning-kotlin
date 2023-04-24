package delegate

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-03-23
 * Time: 13:20
 */
interface MyInterface {
    fun print()
    val msg: String
}

class MyImplementation : MyInterface {
    override fun print() {
        println(msg)
    }

    override val msg: String = "MyImplementation sends regards!"
}

/**
 * Essentially, in the constructor of this class, we require something that implements the interface MyInterface marked by a colon (:), and then, using the keyword by, we tell the derived class that whenever it is asked to perform anything "promised" by the MyInterface interface, it will use the provided object to do so.
 */
class MyNewClass(base: MyInterface) : MyInterface by base {
    override val msg = "Delegate sends regards."
    private val base1 = base

    fun anotherMethod() {
        println("Another method that prints the message from the base class: ${base1.msg}")
    }
}

fun main() {
    val myImplementation = MyImplementation()
    val delegate = MyNewClass(myImplementation)
    delegate.print()
    println(delegate.msg)
    delegate.anotherMethod()
}
