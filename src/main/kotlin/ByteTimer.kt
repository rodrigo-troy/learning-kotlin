/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 28-01-23
 * Time: 18:42
 */
class ByteTimer(_time: Int) {
    val time: Int

    init {
        time = if (_time < -128) -128 else if (_time > 127) 127 else _time
    }
}
