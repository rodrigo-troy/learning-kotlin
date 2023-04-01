/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 01-04-23
 * Time: 17:46
 */
fun main() {
 val list = listOf(1,
                   2,
                   3,
                   4,
                   5,
                   6,
                   7,
                   8,
                   9,
                   10)

 val drop = list.drop(5)
 println("drop: $drop")
 val droplast = list.dropLast(5)
 println("dropLast: $droplast")
 println(list.dropWhile { it < 5 })
 println(list.dropWhile { it == 1 })
 println(list.dropWhile { it == 2 })
 val dropWhile12 = list.dropWhile { it == 1 || it == 2 }
 println("dropWhile: $dropWhile12")
 println(list.dropLastWhile { it > 5 })
}
