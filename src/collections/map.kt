package collections

fun main() {
    val namesAndScores = mapOf("Anna" to 2, "Brian" to 2, "Craig" to 8, "Donna" to 6)

    println(namesAndScores)
    println(namesAndScores["Anna"])
    println(namesAndScores["Greg"])
    println(namesAndScores.isEmpty())
    println(namesAndScores.count())

    for ((player, score) in namesAndScores) {
        println("$player - $score")
    }

    for (player in namesAndScores.keys) println("$player, ${namesAndScores[player]}")
}