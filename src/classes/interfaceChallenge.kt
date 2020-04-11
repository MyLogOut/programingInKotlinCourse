package classes





/**
 * Create a Shape interface with 2 integer properties named:
 * width, height.
 * Add a function named draw
 */

// Your Solution Here
interface Shape {
    val with: Double
    val height: Double
    fun draw()
}

/**
 * Create a Circle that takes these values in the constructor and implements the Shape
 * Interface
 */
// Your Solution Here
class Circle(
    override var with: Double = 0.0,
    override var height: Double = 0.0
) : Shape {
    override fun draw() {
        println("Drawing a circle...")
    }
}

/**
 * Create a Line that takes these values in the constructor and implements the Shape
 * Interface
 */
// Your Solution Here
class Line : Shape {
    override var with: Double = 0.0
    override var height: Double = 0.0

    override fun draw() {
        println("Drawing a line...")
    }
}

/**
 * Create a function named printShape that takes a shape and calls the draw method
 */
// Your Solution Here
fun printShape(shape: Shape) {
    shape.draw()
}

/**
 * Create a circle and a line and call printShape on both
 */

fun main(args: Array<String>) {
    // Your Solution Here
    val circle = Circle()
    val line = Line()
    printShape(circle)
    printShape(line)
}
