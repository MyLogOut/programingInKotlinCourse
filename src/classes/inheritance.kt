package classes

fun main() {
    data class Grade(var letter: Char, var points: Double, var credits: Double)
    open class Person(var firstName: String, var lastName: String)
    open class Student(firstName: String, lastName: String,
                       var grades: ArrayList<Grade> = ArrayList())
        : Person(firstName, lastName){
        open fun recordGrade(grade: Grade) {
            grades.add(grade)
        }
    }

    val john = Person("John", "Travolta")
    val jane = Student("Merry", "Jane")

    println(john.firstName)
    println(jane.firstName)

    val janeGrade = Grade('B', points = 9.0, credits = 3.0)
    jane.recordGrade(janeGrade)

    open class BandMember(firstName: String, lastName: String) : Student(firstName, lastName) {
        open var minimumPracticeTime = 2
    }

    class GuitarPlayer(firstName: String, lastName: String) : BandMember(firstName, lastName) {
        override var minimumPracticeTime: Int
            get() = super.minimumPracticeTime * 2
            set(value) {
                super.minimumPracticeTime = value / 2
            }
    }

    fun phoneBookName(person: Person): String {
        return "${person.lastName}, ${person.firstName}"
    }

    val person = Person(firstName = "Patrick", lastName = "D")
    val guitarPlayer = GuitarPlayer("Adam", "Sand")

    println(phoneBookName(person))
    println(phoneBookName(guitarPlayer))

    //var gradesMonitor = Grade('A', 0.5, 0.4)
    val hallMonitor: Student
    hallMonitor = guitarPlayer
    //hallMonitor = gradesMonitor

    (guitarPlayer as BandMember).minimumPracticeTime = 4

    (hallMonitor as? BandMember)?.let {
        println("""This hall monitor is a band member and practices at least
        |${hallMonitor.minimumPracticeTime} hours per week
    """.trimMargin()) }

    fun afterClassActivity(student: Student): String {
        return "${student.firstName} goes home!"
    }
    fun afterClassActivity(student: BandMember): String {
        return "${student.firstName} goes to practice!"
    }

    println(afterClassActivity(guitarPlayer))
    println(afterClassActivity(guitarPlayer as Student))

    class StudentAthlete(firstName: String, lastName: String) : Student(firstName, lastName) {
        var failedCourses = ArrayList<Grade>()

        override fun recordGrade(grade: Grade) {
            super.recordGrade(grade)
            if (grade.letter == 'F') failedCourses.add(grade)
        }

        val isEligible : Boolean
            get() = failedCourses.size < 3
    }

    val studentAthlete = StudentAthlete("Myron", "George")
    val reprovedGrade = Grade('F', 5.0,10.0)
    studentAthlete.recordGrade(reprovedGrade)
    studentAthlete.recordGrade(reprovedGrade)
    studentAthlete.recordGrade(reprovedGrade)
    println("Is ${studentAthlete.firstName} eligible to participate in any sport? ${studentAthlete.isEligible}")
}