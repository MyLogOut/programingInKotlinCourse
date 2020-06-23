package propertiesAndMethods

class Collaborator(
    private var firstName: String? = null,
    private var lastName: String? = null) {
    private val salutation = "Mr."
    val fullName: String
        get() = "$salutation $firstName $lastName + $otherName"

    var otherName: String = ""
        private set
}

//var itemList: ArrayList<String> = ArrayList()
//    set(value) {
//        field = value
//        // Do something else
//    }

fun main() {
    val person = Collaborator("Tron", "Seagull")
    println("Person: ${person.fullName + person.otherName}")
}