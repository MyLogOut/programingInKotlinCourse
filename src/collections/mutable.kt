package collections

fun main() {
    val name = ArrayList<String>()
    name.add("Sam")
    name.add("Fred")
    printNames(name)
    println(name)
    printNames(name)
    val countHolder = mutableMapOf("first" to 10, "second" to 8, "third" to 5)
    println(countHolder)
    addOne(countHolder)
    println("Outside: $countHolder")
}

fun addOne(value: MutableMap<String, Int>) {
    value.forEach(::println)
    println("before remove: $value, after remove: ${value.remove("first")} }")
    value.forEach(::println)
    value["forth"] = 3
}

fun printNames(names: ArrayList<String>) {
    names.withIndex().forEach(::println)
    names.removeAt(0)
}