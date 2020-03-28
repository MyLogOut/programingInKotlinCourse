package functionsAndNullables

fun main() {
    val multiplierOf: (Int, Int) -> Unit = ::printMultipleOf
    val printMyName = ::printMyName

    multiplierOf(5,3)
    printMyName()
}