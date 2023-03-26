/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 26-03-23
 * Time: 19:17
 */
//classic aproach
interface Level {
    fun getLevel(): Int
}

interface Enemy {
    fun isEnemy(): Boolean
}

interface Class {
    fun getClass(): String
}

class DangerousEnemyWarrior : Level, Enemy, Class {
    override fun getLevel(): Int {
        return 10
    }

    override fun isEnemy(): Boolean {
        return true
    }

    override fun getClass(): String {
        return "Warrior"
    }
}

//Kotlin composition aproach
object Dangerous : Level {
    override fun getLevel(): Int {
        return 10
    }
}

object NotDangerous : Level {
    override fun getLevel(): Int {
        return 1
    }
}

object Foe : Enemy {
    override fun isEnemy(): Boolean {
        return true
    }
}

object Friend : Enemy {
    override fun isEnemy(): Boolean {
        return false
    }
}

object Warrior : Class {
    override fun getClass(): String {
        return "Warrior"
    }
}

object Wizard : Class {
    override fun getClass(): String {
        return "Wizard"
    }
}

class DangerousKotlinEnemyWarrior : Level by Dangerous, Enemy by Foe, Class by Warrior

class NotDangerousFriendlyWizard : Level by NotDangerous, Enemy by Friend, Class by Wizard

fun main() {
    val dangerousEnemyWarrior = DangerousEnemyWarrior()
    println("Level: ${dangerousEnemyWarrior.getLevel()}")
    println("Is enemy: ${dangerousEnemyWarrior.isEnemy()}")
    println("Class: ${dangerousEnemyWarrior.getClass()}")

    val dangerousKotlinEnemyWarrior = DangerousKotlinEnemyWarrior()
    println("Level: ${dangerousKotlinEnemyWarrior.getLevel()}")
    println("Is enemy: ${dangerousKotlinEnemyWarrior.isEnemy()}")
    println("Class: ${dangerousKotlinEnemyWarrior.getClass()}")

    val notDangerousFriendlyWizard = NotDangerousFriendlyWizard()
    println("Level: ${notDangerousFriendlyWizard.getLevel()}")
    println("Is enemy: ${notDangerousFriendlyWizard.isEnemy()}")
    println("Class: ${notDangerousFriendlyWizard.getClass()}")
}
