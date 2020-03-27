package flowControl

fun main() {
    val count = 10
    var sum = 0

    for (valueHolder in 1..count) {
        sum += valueHolder
    }
    println("Sum: $sum")
    for (valueHolder in 0..count) print("Hodor! ")
    println()
    for (valueHolder in 1..count) if (valueHolder% 2 == 1) println("$valueHolder is an odd number")
    println()
    for (valueHolder in 1..count) { print("Hello! "); if (valueHolder == 3) continue; print("Good bye! | ") }
    println()
    for (row in 1..3) { for (column in 1..3) { print("$column") }; println() }
}