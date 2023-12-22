package delegate

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-03-23
 * Time: 13:20
 */
private interface IIndex {
    fun print()
    val index: Int
}

private interface IValue {
    fun print()
    val value: Int
}

private class IndexData(override val index: Int) : IIndex {
    override fun print() = print(index)
}

private class ValueData(override val value: Int) : IValue {
    override fun print() = print(value)
}

private fun getDateTime() = "03-05-2021-14:33"

private class LogDataCollector(index: IIndex, value: IValue) : IIndex by index, IValue by value {
    override fun print() = print("[${getDateTime()}]: $index, $value")
}

private fun main() {
    val index = IndexData(5)
    val value = ValueData(10)
    val logDataCollector = LogDataCollector(
        index,
        value
    )
    logDataCollector.print()
}
