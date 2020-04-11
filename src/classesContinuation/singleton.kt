package classesContinuation

object MySingleton {
    fun doMyStuff(data: String) {
        println("This is my data $data")
    }

    val myConstant = "This is my [Constant]"
    var data: String = "Empty data"

}

fun main() {
    val instanceOfSingleton = MySingleton
    instanceOfSingleton.doMyStuff("Hello there" + instanceOfSingleton.myConstant + instanceOfSingleton.data)
    val secondInstanceOfSingleton = MySingleton
    secondInstanceOfSingleton.data = "Filled data"
    instanceOfSingleton.doMyStuff("Updated data? "+ instanceOfSingleton.myConstant + " " + instanceOfSingleton.data)

}