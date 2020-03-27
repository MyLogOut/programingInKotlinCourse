package flowControl

fun main() {
    outer@ for (row in 1..3) {
        for (column in 1..3) {
            if (row == 2 && column == 2) {
                println()
                continue@outer
            }
            println(column)
        }
        println()
    }
}