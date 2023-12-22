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
    private fun method3() {
        LOG.info("BeforeAll")
        number += 11
    }

    @AfterAll
    private fun method4() {
        LOG.info("AfterAll")
        number /= 3
    }

    @BeforeEach
    private fun method2() {
        LOG.info("BeforeEach")
        number -= 4
    }

    @AfterEach
    private fun method5() {
        LOG.info("AfterEach")
        LOG.info(number.toString())
    }

    @Test
    private fun method6() {
        LOG.info("Test1")
        number += 9
    }
}
