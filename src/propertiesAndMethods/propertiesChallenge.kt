package propertiesAndMethods

import kotlin.properties.Delegates

/**
 * Copy the Course class you created in the lateinit challenge
 * and add a courseDescription String that is created with the lazy function
 * Have the returned string contain the className and the teacherName
 */
/**
 *  add a room String variable that is an Observable, has a "No Room" initial value
 *  and prints out the new value
 */
// Your solution here
class PropertiesCourse(private val className: String) {
    var classRoom: String by Delegates.observable("Not assigned yet.") {
        classRoom, previousClassRoom, newClassRoom ->
        if (previousClassRoom != "Not assigned yet.") {
            println(
                "This class has moved from its previous classroom: $previousClassRoom" +
                        " to its new classroom: $newClassRoom"
            )
        }
        else println("$classRoom: This classroom has been assigned for the Course of $className: $newClassRoom")
    }
    private lateinit var teacher: String
    val courseDescription: String by lazy {
        "Course ${className}, taught by $teacher."
    }

    fun setTeacherName(name: String) {
        teacher = name
    }

    fun displayCourseDetails() = println(if (this::teacher.isInitialized) "Course: ${this.className}, taught by: $teacher" else "Course: $className, teacher not defined yet.")
}

/**
 * Add a main function, create a Course and set the teacher name,
 * room and print out the courseDescription
 */
fun main() {
// Your solution here
    val course = PropertiesCourse("Science")
    course.setTeacherName("Mark Hanson")
    println("Classroom: ${course.classRoom}")
    course.classRoom = "Laboratory #1"
        course.displayCourseDetails()
    println(course.courseDescription)

}