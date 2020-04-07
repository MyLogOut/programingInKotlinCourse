package classes

fun main() {
    @Suppress("JoinDeclarationAndAssignment")
    class Person(firstName: String, lastName: String) {
        var fullName: String
        init {
            fullName = "$firstName $lastName"
        }
    }

    val person = Person("Patrick", "D")
    println(person.fullName)
}