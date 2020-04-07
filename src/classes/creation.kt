package classes

class Person(val firstName: String, val lastName: String = "D")

fun main() {
    val person = Person("Patrick")
    val person1 = Person("Patrick", "D")

    println("${person.firstName} ${person.lastName}")
    println("${person1.firstName} ${person1.lastName}")
}