package test.mockk

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 24-04-23
 * Time: 11:50
 */
class NumberChecker {
    fun checkNumber(number: Int): String {
        return if (number % 2 == 0) "even" else "odd"
    }
}
