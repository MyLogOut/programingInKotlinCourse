package collections

fun main() {
    val prices = arrayOf(1,2,3,4)
    val removeFirst = prices.drop(1)
    println(removeFirst)
    println(prices.drop(2))
    println(prices.dropLast(2))
}