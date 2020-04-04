package lambdas

// Sum all the integers in the list that are
// greater than 5 and print out the result.
fun firstChallenge() {
    val values = listOf(24, 5, 10, 4)
    val printPassedArgument: (Int) -> Unit = { println("$it")}
    val sumPassedArgument: (Int, Int) -> Int = { accumulator, addition -> println("${accumulator + addition}");accumulator+addition }
    fun printing(item: Int, operation: (Int) -> Unit) {
        operation(item)
    }
    values.filter { it > 5 }.forEach { printing(it, printPassedArgument)}
    values.filter { it > 5 }.reduce(sumPassedArgument)
    values.filter { it > 5 }.sum().let(printPassedArgument)

}

// Given the Person class below, destructuring
// the name and age.
fun secondChallenge() {
    data class Person(val name: String, val age: Int)
    val patrick = Person("Patrick", 24)
    val (personName, personAge) = patrick
    println("By saying this process: $patrick\nIs equal to say: personName: $personName, personAge: $personAge")
}
fun main() {
    firstChallenge()
    secondChallenge()
}