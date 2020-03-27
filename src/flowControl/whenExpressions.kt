package flowControl

fun main() {
    var number = 9
    number +=1
    val string = when (number) {
        0 -> "Zero"
        10 -> "It's ten!"
        else -> "Non-zero"
    }
    println(string)
}