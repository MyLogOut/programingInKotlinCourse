package propertiesAndMethods

import kotlin.properties.Delegates

//## Lazy properties
data class Courses(var className: String, val map: Map<String, Any?>?) {
    var delegateRoom: String by Delegates.observable("No room") {
        property, oldValue, newValue ->
        println("From this value: $oldValue, on this property [$property], to this new value: $newValue.")
    }
    val mapRoom: String by map
    val mapTeacher: String by map

    fun printingThis() {
        if (map != null) {
            println(map.entries)
        }
    }
}

val scienceCourse: Courses by lazy {
    Courses("Science", null)
}

fun main() {
    val newMap: Map<String, Any?>
            = mapOf(
        "mapRoom" to "Science",
        "mapTeacher" to "Mark Hanson")
    val coursesList = Courses("Science", newMap)
    coursesList.run { println(this) }
    println("______________________")
    coursesList.printingThis()
    coursesList.delegateRoom = "Laboratory"
    println(coursesList.map)
    println(coursesList.map?.entries)
    println(coursesList.mapRoom + coursesList.mapTeacher)
    println(coursesList.mapRoom)
}