package coreConcepts

fun main() {

    fun calculateTemperature(celsius: Double): Double {
        return 9.0 / 5.0 * celsius + 32.0
    }

    println("Temp = ${calculateTemperature(20.0)}")

    val intValue: Any = "32".toInt()
    println("It is ${intValue is Int} that $intValue is an Integer data type.")

    val intString: Any = 32.toString()
    println("It is ${intString is String} that $intValue is a String data type.")

    when (32) {
        in 0..30 -> {println("Really cold")}
        in 31..40 -> {println("Getting colder")}
        in 41..50 -> {println("Kind of cold")}
        in 51..60 -> {println("Nippy cold")}
        in 71..80 -> {println("Just right")}
    }

    val nullableName: String? = "null"
    val length = nullableName?.length ?: -1
    println(length)
}