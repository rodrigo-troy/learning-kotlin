import org.junit.jupiter.api.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 27-03-23
 * Time: 11:14
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BetaTest {
    private val LOG: Logger = LoggerFactory.getLogger(BetaTest::class.java)

    private var number = 0

    init {
        LOG.info("Init")
        number = 10
    }

    @BeforeAll
    fun method3() {
        LOG.info("BeforeAll")
        number += 11
    }

    @AfterAll
    fun method4() {
        LOG.info("AfterAll")
        number /= 3
    }

    @BeforeEach
    fun method2() {
        LOG.info("BeforeEach")
        number -= 4
    }

    @AfterEach
    fun method5() {
        LOG.info("AfterEach")
        LOG.info(number.toString())
    }

    @Test
    fun method6() {
        LOG.info("Test1")
        number += 9
    }
}
