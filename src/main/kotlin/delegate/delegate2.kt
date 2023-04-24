package delegate

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 31-03-23
 * Time: 13:20
 */
// First interface, specifies contract for callbacks
interface ICallbackReceiver {
    fun onBeforeAction()
    fun onAfterAction()
    fun action(function: () -> Unit) {
        onBeforeAction()
        function()
        onAfterAction()
    }
}

// Second interface, specifies contract for logger
interface ILogger {
    fun getStubDateTime() = "05.11.2022-14:31:04" // stub

    val format: String
        get() = "[${getStubDateTime()}]: "

    fun print(s: String)
}

/**
 *  Simple implementation of ILogger interface
 */
class BasicLogger : ILogger {
    override fun print(s: String) = println(format + s)
}

/** Implementation of first interface, which defines callback actions,
setting them to simply print to console each time they are called.
However! For printing, it utilizes delegated BasicLogger, which
in this example prints info with date and time markers.
 */
class ConsoleNotifier(logger: ILogger) : ICallbackReceiver, ILogger by logger {
    val onBeforeStr = "OnBefore!"
    val onAfterStr = "OnAfter!"

    // "print" is delegated to "logger"
    override fun onBeforeAction() = print(onBeforeStr)
    override fun onAfterAction() = print(onAfterStr)
}

fun main() {
    val logger = BasicLogger()
    val notifier = ConsoleNotifier(logger)

    notifier.action {
        println("Action!")
    }
}
