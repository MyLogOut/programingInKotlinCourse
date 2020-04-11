package classesContinuation

sealed class Expression
data class Num(val number: Double): Expression()
data class Sum(val value: Expression, val addition: Expression?): Expression()
object NotANumber: Expression()

fun evaluate(expression: Expression): Double = when (expression) {
    is Num -> expression.number
    is Sum -> evaluate(expression.value) + evaluate(expression.addition ?: Num(1.0))
    NotANumber -> Double.NaN
}
fun main() {
    val value = Num(10.5)
    val addition = Num(5.0)

    println("The values in question are: ${evaluate(value)} and ${evaluate(addition)}")
    println("Starting from that point the sum of $value and $addition is ${evaluate(Sum(value = value, addition = addition))}")
    println("If we change the [addition] to null, the sum of $value and null would be ${evaluate(Sum(value = value, addition = NotANumber))}")
}