package classes

/**
 * Given the Student data class below, create a StudentRegistry
 * singleton that has a list of students and can add and remove a
 * student from that list.
 *
 */

data class Scholar(val firstName: String, val lastName: String)

// Add the StudentRegistry class here

object ScholarRegistry {
    private val archive: ArrayList<Scholar> = arrayListOf()

    fun addScholar(scholar: Scholar?) {
        try {
            println("[$scholar] was ${if (archive.add(scholar!!)) "successfully" else "not"} added")
        } catch (exception: NullPointerException) {
            println("There were an error [#${exception.localizedMessage} - ${exception.cause}: ${exception.message}, $exception] trying to add [$scholar]?")
        }
    }

    fun removeScholar(scholar: Scholar?) =
        if (archive.remove(scholar)) println("Successfully removed [$scholar]")
        else println("$scholar were not removed. Exist: ${archive.contains(scholar)}.")

    fun displayRegistry() {
        println("Currently registered: ")
        archive.forEach(::println)
    }
}

// Your Solution Here

/**
 * Add 2 students to the registry and then print out the list
 */

// Add main function and print out the students

/**
 * Add 2 students to the registry and then print out the list
 */

fun main(args: Array<String>) {
    // Your Solution Here
    val steve = Scholar("Steve", "Johnson")
    val rob = Scholar("Rob", "32")

    ScholarRegistry.addScholar(steve)
    ScholarRegistry.addScholar(rob)
    ScholarRegistry.addScholar(null)
    ScholarRegistry.displayRegistry()
    ScholarRegistry.removeScholar(steve)
    ScholarRegistry.removeScholar(null)
    ScholarRegistry.displayRegistry()
}