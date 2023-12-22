package `interface`

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 26-03-23
 * Time: 19:13
 *
 * This is the first interface in the program.
 * It declares two methods, f and g. The f method has a default implementation that printlns "First".
 */
private interface FirstInterface {
    fun f() {
        println("First")
    }

    fun g()
}

/**
 * This is the second interface in the program.
 * It declares two methods, f and g. Both methods have a default implementation.
 */
private interface SecondInterface {
    fun f() {
        println("Second")
    }

    fun g() {
        println("g")
    }
}

/**
 * This class implements the FirstInterface.
 * It provides an implementation for the g method.
 */
private class FirstClass : FirstInterface {
    override fun g() {
        println("g")
    }
}

/**
 * This class implements both the FirstInterface and SecondInterface.
 * It overrides the f method and uses the default implementation of the g method from the FirstInterface.
 */
private class SecondClass : FirstInterface, SecondInterface {
    override fun f() {
        println("Second")
    }

    override fun g() {
        super.g()
    }
}

/**
 * This is the third interface in the program.
 * It declares two methods, f and g. Both methods have a default implementation.
 */
private interface ThirdInterface {
    fun f() {
        println("First")
    }

    fun g() {
        println("not g")
    }
}

/**
 * This is the fourth interface in the program.
 * It declares two methods, f and g. Both methods have a default implementation.
 */
private interface FourthInterface {
    fun f() {
        println("Second")
    }

    fun g() {
        println("g")
    }
}

/**
 * This class implements both the FirstInterface and SecondInterface.
 * It overrides the f method to call the f method from both interfaces.
 * It uses the default implementation of the g method from the FirstInterface.
 */
private class ThirdClass : FirstInterface, SecondInterface {
    override fun f() {
        super<FirstInterface>.f()
        super<SecondInterface>.f()
    }

    override fun g() {
        super.g()
    }
}


/**
 * The main function is the entry point of the program.
 * It initializes instances of `FirstClass`, `SecondClass`, and `ThirdClass`,
 * and calls the `f()` and `g()` methods on each of them.
 */
fun main() {
    val firstClass = FirstClass()
    firstClass.f()
    firstClass.g()
    println()

    val secondClass = SecondClass()
    secondClass.f()
    secondClass.g()
    println()

    val thirdClass = ThirdClass()
    thirdClass.f()
    thirdClass.g()
}
