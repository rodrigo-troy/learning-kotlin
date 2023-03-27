import org.junit.jupiter.api.*

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 27-03-23
 * Time: 11:14
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BetaTest {
    var number = 0

    init {
        number = 10
    }

    @BeforeAll
    fun method3() {
        number += 11
    }

    @AfterAll
    fun method4() {
        number /= 3
    }

    @BeforeEach
    fun method2() {
        number -= 4
    }

    @AfterEach
    fun method5() {
        println(number)
    }

    @Test
    fun method6() {
        number += 9
    }
}
