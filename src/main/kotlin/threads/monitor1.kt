class SomeClass {

    @Synchronized
    fun method1() {
        println("a thread entered method1")
        method2()
        println("a thread left method1")
    }

    @Synchronized
    fun method2() {
        println("a thread entered method2")
        println("a thread left method2")
    }

    @Synchronized
    fun method3() {
        println("a thread entered method3")
        println("a thread left method3")
    }
}

fun main() {
    val someClass = SomeClass()
    val t1 = Thread { someClass.method1() }
    val t2 = Thread { someClass.method3() }
    t1.start()
    t2.start()
}
