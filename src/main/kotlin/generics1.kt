/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 26-03-23
 * Time: 20:02
 */

class MyClass<T>(t: T) {

    val item = t  // A field of "some type"

}

fun main() {
    val myClass = MyClass("Hello")
    println(myClass.item)

    val myClass2 = MyClass(1)
    println(myClass2.item)

    val myClass3 = MyClass(1.0)
    println(myClass3.item)

    val myClass4 = MyClass(true)
    println(myClass4.item)
}

class Foo {
    private fun <T> T.foo(that: T): T = throw Exception()

    init {
        val foo = "str".foo(42)
    }
}
