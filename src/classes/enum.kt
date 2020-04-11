package classes

import java.lang.IllegalArgumentException

private enum class Direction {
    NORTH, SOUTH, WEST, EAST;

    fun printDirection(): Unit = println("I'm going $this")
}

/*enum class Color(red: Double, green: Double, blue: Double) {
    RED(red = 255.0, green = 0.0, blue = 0.0),
    GREEN(red = 0.0, green = 255.0, blue = 0.0),
    BLUE(red = 0.0, green = 0.0, blue = 255.0)
}*/

private fun drive(direction: Direction?): Unit? = when (direction) {
    Direction.NORTH -> println("I'm driving north")
    Direction.SOUTH -> println("I'm driving south")
    Direction.WEST -> println("I'm driving west")
    Direction.EAST -> println("I'm driving east")
    else -> println("This direction doesn't exist.")
}

fun main() {
    Direction.NORTH.printDirection()
    println(Direction.NORTH.ordinal)
    drive(Direction.WEST)
    drive(Direction.EAST)
    drive(Direction.NORTH)
    drive(Direction.valueOf("SOUTH"))
    drive(
        try {Direction.valueOf("South")}
        catch (exception: IllegalArgumentException) { println(exception); null})
}