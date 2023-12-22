package delegate

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-03-23
 * Time: 13:20
 */
private interface ILogHolder {
    fun printLog()
    fun collectLog(log: String)
    var curLog: String
}

private class Logger : ILogHolder {
    override fun printLog() {
        println(curLog)
    }

    override fun collectLog(log: String) {
        curLog += "\n> $log"
    }

    override var curLog: String = "> Logger initialized."
}
// Do not change the code above

// Introduce the delegate here, following the argument declaration
private class ErrorHandler(base: ILogHolder) : ILogHolder by base {
    var errorMessage: String = ""
    fun getErrorMessage(msg: String) {
        errorMessage = msg
        logErrorMessage()
    }

    private fun logErrorMessage() {
        collectLog(errorMessage)
    }
}

private fun doSomething(handler: ErrorHandler) {
    handler.getErrorMessage("Access denied")
    handler.getErrorMessage("Out of memory")
    handler.getErrorMessage("I'm not an error")
}

private fun main() {
    val log = Logger()
    val handler = ErrorHandler(log)

    doSomething(handler)

    handler.printLog()
}
