package propertiesAndMethods


/**
 * Create a class named Course that takes a className String parameter
 * Add a private lateinit variable for the Teacher's name
 * Then create a setTeacherName function that sets that variable
 */

// Your solution here
class Course(private val className: String) {
    private lateinit var teacher: String
    fun setTeacherName(name: String) {
        teacher = name
    }
    fun displayCourseDetails() = println(if (this::teacher.isInitialized) "Course: ${this.className}, taught by: $teacher" else "Course: $className, teacher not defined yet.")
}

/**
 * Add a main function, create a Course and set the teacher name
 */

fun main() {
// Your solution here
    val spanishCourse = Course("Spanish")
    spanishCourse.displayCourseDetails()
    spanishCourse.setTeacherName("Patrick")
    spanishCourse.displayCourseDetails()
}

