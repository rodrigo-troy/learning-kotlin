package design.pattern.command

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 21-10-24
 * Time: 18:06
 */
interface Command {
    fun execute()
}

class GreetUserCommand() : Command {
    override fun execute() {
        println("Hello! My name is Aid.")
        println("I was created in 2020.")
        println("Please, remind me your name.")
        val name = readln()
        println("What a great name you have, $name!")
    }
}

class GuessAgeCommand() : Command {
    override fun execute() {
        println("Let me guess your age.")
        println("Enter remainders of dividing your age by 3, 5, and 7.")
        val age = ((readln().toIntOrNull()?.times(70) ?: 0) + (readln().toIntOrNull()?.times(21)
            ?: 0) + (readln().toIntOrNull()?.times(15) ?: 0)) % 105
        println("Your age is $age; that's a good time to start programming!")
    }
}

class CountCommand : Command {
    override fun execute() {
        println("Now I will prove to you that I can count to any number you want.")

        val number = readln().toIntOrNull() ?: 0
        repeat(number + 1) {
            println("$it!")
        }

        println("Completed, have a nice day!")
    }
}

class ChatBot {
    private val commands = mutableListOf<Command>()

    fun start() {
        for (command in commands) {
            command.execute()
        }
    }

    class Builder {
        private val commands = mutableListOf<Command>()

        fun addCommand(command: Command) = apply {
            commands.add(command)
        }

        fun build() = ChatBot().apply { commands.addAll(this@Builder.commands) }
    }
}

fun main() {
    ChatBot.Builder()
        .addCommand(GreetUserCommand())
        .addCommand(GuessAgeCommand())
        .addCommand(CountCommand())
        .build()
        .start()
}