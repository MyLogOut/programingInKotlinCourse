package lambdas

fun main() {
    val values = listOf(24, 5, 10, 4)
    println(values.filter { it > 5 })

    val names = listOf("Sam", "Fred", "Samuel", "Alice")
    println(names.firstOrNull { it.length > 5 })

    val cities = listOf("Los Angeles", "San Francisco", "New York", "San Antonio")
    println(cities.any { it == "San Antonio" })
    println(cities.all { it.length > 6 })

}