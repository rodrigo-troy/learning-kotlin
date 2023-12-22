package `interface`.composition

/**
 * Created with IntelliJ IDEA.
$ Project: learning-kotlin
 * User: rodrigotroy
 * Date: 26-03-23
 * Time: 19:17
 */
//classic approach
private interface Level {
    fun getLevel(): Int
}

private interface Enemy {
    fun isEnemy(): Boolean
}

private interface Class {
    fun getClass(): String
}

private class DangerousEnemyWarrior : Level, Enemy, Class {
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

//Kotlin composition approach******************************************************
private object Dangerous : Level {
    override fun getLevel(): Int {
        return 10
    }
}

private object NotDangerous : Level {
    override fun getLevel(): Int {
        return 1
    }
}

private object Foe : Enemy {
    override fun isEnemy(): Boolean {
        return true
    }
}

private object Friend : Enemy {
    override fun isEnemy(): Boolean {
        return false
    }
}

private object Warrior : Class {
    override fun getClass(): String {
        return "Warrior"
    }
}

private object Wizard : Class {
    override fun getClass(): String {
        return "Wizard"
    }
}

private class DangerousKotlinEnemyWarrior : Level by Dangerous, Enemy by Foe, Class by Warrior

private class NotDangerousFriendlyWizard : Level by NotDangerous, Enemy by Friend, Class by Wizard

private fun main() {
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
