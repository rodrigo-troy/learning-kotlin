package threads

/**
 * This method cooks a vegan pizza by performing a series of steps in a specific order.
 *
 * The steps are as follows:
 * 1. Cook the base by creating a new instance of the `Base` class and starting it as a separate thread. The `Base`
 *    class extends the `Thread` class and overrides the `run` method to print "cook base".
 * 2. Slice the tomatoes by creating a new instance of the `Tomatoes` class and starting it as a separate thread. The `Tomatoes`
 *    class extends the `Thread` class and overrides the `run` method to print "slice tomatoes X" where X is the current
 *    number of tomato slices.
 * 3. Fry the tofu by creating a new instance of the `Tofu` class and starting it as a separate thread. The `Tofu`
 *    class extends the `Thread` class and overrides the `run` method to print "fry tofu".
 * 4. Bake the pizza by creating a new instance of the `Bake` class and starting it as a separate thread. The `Bake`
 *    class extends the `Thread` class and overrides the `run` method to print "to bake...X min" where X is the current
 *    remaining baking time. Once the baking time reaches 0, the message "Your pizza is ready!" is printed.
 *
 * After creating and starting each step, the method waits for each step to complete by calling `join` on each thread.
 * This ensures that the steps are executed in the desired order and the pizza is cooked properly.
 *
 * This method does not return anything and is intended to be called as a standalone function to cook a vegan pizza.
 *
 * @see Base
 * @see Tomatoes
 * @see Tofu
 * @see Bake
 */
fun cookVeganPizza() {
    val base = Base()
    val tomatoes = Tomatoes()
    val tofu = Tofu()
    val bake = Bake()

    val stepOfCook: MutableList<Thread> = mutableListOf()
    stepOfCook.add(base)
    stepOfCook.add(tomatoes)
    stepOfCook.add(tofu)
    stepOfCook.add(bake)

    for (step in stepOfCook) {
        step.start()
        step.join()
    }
}

/**
 * Base class represents a thread that is responsible for cooking the base of a vegan pizza.
 *
 * This class extends the Thread class and overrides the run() method to provide custom implementation
 * for cooking the base.
 */
class Base : Thread() {
    override fun run() {
        println("cook base")
    }
}

/**
 * A class representing the slicing of tomatoes for cooking.
 * Extends the Thread class to enable concurrent execution.
 */
class Tomatoes : Thread() {
    override fun run() {
        for (i in 3 downTo 1) {
            println("slice tomatoes $i")
        }
    }
}

/**
 * The Tofu class represents a thread that fries tofu.
 *
 * Example Usage:
 * ```
 * val tofu = Tofu()
 * tofu.start()
 * ```
 */
class Tofu : Thread() {
    override fun run() {
        println("fry tofu")
    }
}

/**
 * The `Bake` class is a subclass of `Thread` and represents the baking process of a pizza.
 * When an instance of `Bake` is started using the `start()` method, it runs in a separate thread,
 * counting down from 4 minutes to 0. Once the countdown reaches 0, it prints "Your pizza is ready!"
 *
 * Example usage:
 *
 * ```
 * val bake = Bake()
 * bake.start()
 * ```
 *
 * @see Thread
 */
class Bake : Thread() {
    override fun run() {
        for (i in 4 downTo 0) {
            if (i == 0) {
                println("Your pizza is ready!")
                break
            }
            println("to bake...$i min")
        }
    }
}


/**
 * This is the main entry point of the application. It executes the `cookVeganPizza` function.
 */
fun main() {
    cookVeganPizza()
}

