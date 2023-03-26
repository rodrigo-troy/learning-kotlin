/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 26-03-23
 * Time: 19:13
 */
interface FirstInterface {
    fun f() {
        print("First")
    }

    fun g()
}

interface SecondInterface {
    fun f() {
        print("Second")
    }

    fun g() {
        print("g")
    }
}

class FirstClass : FirstInterface {
    override fun g() {
        print("g")
    }
}

class SecondClass : FirstInterface, SecondInterface {
    override fun f() {
        print("Class")
    }

    override fun g() {
        super.g()
    }
}

interface ThirdInterface {
    fun f() {
        print("First")
    }

    fun g() {
        print("not g")
    }
}

interface FourthInterface {
    fun f() {
        print("Second")
    }

    fun g() {
        print("g")
    }
}

class ThirdClass : FirstInterface, SecondInterface {
    override fun f() {
        super<FirstInterface>.f()
        super<SecondInterface>.f()
    }

    override fun g() {
        super.g()
    }
}
