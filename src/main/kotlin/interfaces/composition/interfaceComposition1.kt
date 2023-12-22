package interfaces.composition

/**
 * The Level interface.
 *
 * This interface represents a level and provides a method to get the level value.
 */
//classic approach
private interface Level {
    fun getLevel(): Int
}

/**
 * The Enemy interface represents an enemy in a game.
 *
 * To implement this interface, a class must provide a way to determine if it is an enemy or not.
 */
private interface Enemy {
    fun isEnemy(): Boolean
}

/**
 * The `Class` interface is a private interface that provides a method for retrieving the class name.
 * It is implemented by classes that represent different types of enemies or allies in a game.
 *
 * Example usage:
 * ```
 * private class DangerousEnemyWarrior : Level, Enemy, Class {
 *     override fun getLevel(): Int {
 *         return 10
 *     }
 *
 *     override fun isEnemy(): Boolean {
 *         return true
 *     }
 *
 *     override fun getClass(): String {
 *         return "Warrior"
 *     }
 * }
 * ```
 * ```
 * private class DangerousKotlinEnemyWarrior : Level by Dangerous, Enemy by Foe, Class by Warrior
 * ```
 * ```
 * private class NotDangerousFriendlyWizard : Level by NotDangerous, Enemy by Friend, Class by Wizard
 * ```
 *
 * @see Level
 * @see Enemy
 */
private interface Class {
    fun getClass(): String
}

/**
 * Represents a dangerous enemy warrior in the game.
 *
 * This class implements the [Level], [Enemy], and [Class] interfaces, which define the behavior of the warrior.
 * The warrior has a level of 10, is considered an enemy, and belongs to the "Warrior" class.
 *
 * This class is private and should not be accessed from outside the package.
 */
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

/**
 * The `Dangerous` class is an implementation of the `Level` interface. It represents a dangerous level and provides
 * functionality to get the level value.
 *
 * Example usage:
 * ```
 * val dangerousLevel: Level = Dangerous
 * val level = dangerousLevel.getLevel()
 * ```
 *
 * @see Level
 */
//Kotlin composition approach******************************************************
private object Dangerous : Level {
    override fun getLevel(): Int {
        return 10
    }
}

/**
 * Represents a non-dangerous level.
 *
 * This class implements the [Level] interface and provides a non-dangerous level value of 1.
 *
 * @see Level
 */
private object NotDangerous : Level {
    override fun getLevel(): Int {
        return 1
    }
}

/**
 * Foe is an object that represents an enemy in the system.
 */
private object Foe : Enemy {
    override fun isEnemy(): Boolean {
        return true
    }
}

/**
 * This class represents a Friend, which is an implementation of the Enemy interface.
 */
private object Friend : Enemy {
    override fun isEnemy(): Boolean {
        return false
    }
}

/**
 * The `Warrior` class implements the `Class` interface and represents a warrior character in a game.
 *
 * @see Class
 */
private object Warrior : Class {
    override fun getClass(): String {
        return "Warrior"
    }
}

/**
 * The `Wizard` class represents a wizard character in a game.
 * It implements the `Class` interface and provides the `getClass` method to get the class name of the wizard.
 *
 * Example usage:
 *
 * ```
 * val wizard = NotDangerousFriendlyWizard()
 * val className = wizard.getClass()*/
private object Wizard : Class {
    override fun getClass(): String {
        return "Wizard"
    }
}

/**
 * This class represents a dangerous enemy warrior. It implements the `Level` interface to get the level,
 * the `Enemy` interface to determine if it's an enemy, and the `Class` interface to get the class of the warrior.
 *
 * @property level The level of the warrior.
 * @property isEnemy Indicates if the warrior is an enemy.
 * @property className The class of the warrior.
 */
private class DangerousKotlinEnemyWarrior : Level by Dangerous, Enemy by Foe, Class by Warrior

/**
 * Implementation of the NotDangerousFriendlyWizard class.
 * This class combines the behaviors of NotDangerous, Friend, and Wizard to create a friendly wizard character
 * that is not dangerous.
 *
 * @see Level
 * @see Enemy
 * @see Class
 */
private class NotDangerousFriendlyWizard : Level by NotDangerous, Enemy by Friend, Class by Wizard

/**
 * The `main` function is the entry point for the application. It instantiates objects of various classes
 * and calls their methods to print the corresponding information.
 */
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
