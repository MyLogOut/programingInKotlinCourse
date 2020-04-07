package classes

data class Student(val firstName: String, val lastName: String, val grades: Char)
fun main() {
    val sam = Student("Sam", "Gamgee", 'A')
    val samCopy = sam.copy(firstName = "Sam", lastName = "Copy")
    println("Sam: ${sam.toString()}.")
    println("Copied Sam: ${samCopy}")
}