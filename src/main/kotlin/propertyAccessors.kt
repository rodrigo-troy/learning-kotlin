class Client {
    val name = "Unknown"
        get() {
            return "$field!"
        }
}

class IntegerRepository {
    private val _list = mutableListOf<Int>()

    /**
     * A read-only list of integers that provides access to the stored integers.
     * It returns a copy of the internal mutable list to ensure immutability.
     */
    val list: List<Int>
        get() {
            /* backing property with a read-only copy of the internal mutable list */
            return _list
        }
}

/**
 * A class that represents a client with a name and age.
 *
 * @param name The full name of the client.
 * @param age The age of the client.
 */
class Client2(name: String, age: Int) {
    /**
     * The full name of the client.
     *
     * When setting a new value, a message is printed to indicate the change.
     */
    var fullName: String = name
        set(value) {
            println("The name is changing. Old value is $field. New value is $value.")
            field = value
        }

    /**
     * this is a new property, not a property from the constructor.
     *
     * When setting a new value, a message is printed to indicate the change.
     */
    var age: Int = age
        set(value) {
            println("The age is changing. Old value is $field. New value is $value.")
            field = value
        }
}

fun main() {
    val client = Client()
    println(client.name)

    val repository = IntegerRepository()
    // repository.list.add(1) // error: the setter is private in 'IntegerRepository'
    println(repository.list)

    val client2 = Client2("Rodrigo",
                          30)
    client2.fullName = "Rodrigo Troy"
    client2.age = 31
    println("client2.fullName: ${client2.fullName} - client2.age: ${client2.age}")

}
