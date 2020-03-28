package functionsAndNullables

fun main() {
    printMultipleOf(1,2)
    printMultipleOf(2,2,3)
    printMultipleOf(1,2,3,4)
}

fun printMultipleOf(multiplier: Int, addValue: Int) { println(multiplier*addValue) }
fun printMultipleOf(multiplier: Int, addValue: Int, thirdValue: Int) { println(multiplier*addValue*thirdValue) }
fun printMultipleOf(multiplier: Int, addValue: Int, thirdValue: Int, forthValue: Int) { println(multiplier*addValue*thirdValue*forthValue) }
