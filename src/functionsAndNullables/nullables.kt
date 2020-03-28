package functionsAndNullables

fun main() {
    var nickname: String? = null
    println("My nickname is $nickname")
    nickname = "Suegro"
    println("My nickname is $nickname")

    val result: Int? = null
    println("Some random result: $result")
    println("Some random result + 1 ${result ?: result!! +1}")
}