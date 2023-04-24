package test.mockk

import io.mockk.*

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 24-04-23
 * Time: 10:44
 */
class NumberCheckerTest {
 @Test
 fun `Test checkNumber function with even number`() {
  val numberChecker = NumberChecker()
  val userInput = mockk<Int>()
  every { userInput } returns 2

  val result = numberChecker.checkNumber(userInput)

  assertEquals("even", result)
 }

 @Test
 fun `Test checkNumber function with odd number`() {
  val numberChecker = NumberChecker()
  val userInput = mockk<Int>()
  every { userInput } returns 3

  val result = numberChecker.checkNumber(userInput)

  assertEquals("odd", result)
 }

 @Test
 fun `Test checkNumber function with zero`() {
  val numberChecker = NumberChecker()
  val userInput = mockk<Int>()
  every { userInput } returns 0

  val result = numberChecker.checkNumber(userInput)

  assertEquals("even", result)
 }

 @Test
 fun `Test checkNumber function with negative even number`() {
  val numberChecker = NumberChecker()
  val userInput = mockk<Int>()
  every { userInput } returns -2

  val result = numberChecker.checkNumber(userInput)

  assertEquals("even", result)
 }

 @Test
 fun `Test checkNumber function with negative odd number`() {
  val numberChecker = NumberChecker()
  val userInput = mockk<Int>()
  every { userInput } returns -3

  val result = numberChecker.checkNumber(userInput)

  assertEquals("odd", result)
 }
}
