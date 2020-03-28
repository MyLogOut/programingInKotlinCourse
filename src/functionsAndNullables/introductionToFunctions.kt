package functionsAndNullables

fun main() {
    printMyName()
    printMultipleOfFive(10)
    //Named arguments:
    printMultipleOfNumber(10, mainValue = 2)

    //Default value for mainValue [2] parameter:
    printMultipleOfTwo(multiplier = 4)
    println(multiply(4,2))
    println(multiplyAndDivide(4,2))
}

fun printMyName() {
    println("My name is Patrick Duarte")
}
fun printMultipleOfFive(value: Int) {
    println("$value * 5 = ${value * 5}")
}
fun printMultipleOfNumber(multiplier: Int, mainValue: Int) {
    println("$multiplier * $mainValue = ${multiplier * mainValue}")
}
fun printMultipleOfTwo(multiplier: Int , mainValue: Int = 2) {
    println("$multiplier * $mainValue = ${multiplier * mainValue}")
}
fun multiply(number: Int, multiplier: Int) = number * multiplier
fun multiplyAndDivide(number: Int, factor: Int) = Pair(number*factor, number/factor)