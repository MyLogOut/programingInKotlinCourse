package lambdas

interface Repository<T>{
    fun addItem(item: T?)
    fun removeItem(item: T)
}

class Person(val name: String?)

class PersonRepository : Repository<Person> {
    val crowdList: MutableList<Person?> = mutableListOf()
    override fun addItem(item: Person?) {
        crowdList.add(item)
    }

    override fun removeItem(item: Person) {
        crowdList.remove(item)
    }

}

fun main() {
    val crowd = PersonRepository()
    val patrick = Person("Patrick")
    crowd.addItem(patrick)
    crowd.addItem(null)
    printItem(randomizeElements(crowd.crowdList))
    crowd.removeItem(patrick)
    printMyItem(crowd)
}
fun randomizeElements(list: List<Any?>) {
    list.indices
    list[(list.indices).random()]
}


fun <T> printItem(item: T?) {
    println("This item has the following [" + when (item) {
        is Any -> {"Any"}
        is String -> {"String"}
        is Int -> {"Int"}
        is Person -> {"Person"}
        is PersonRepository -> {"PersonRepository"}
        is List<Any?> -> {"List<?>"}
        else -> {"No matches"}
    } + "]: ")
    try {
        val person = item as PersonRepository?
        person?.crowdList?.forEach { println(it?.name) } ?: println("$item is not a valid parameter.")
    }
    catch (e:  TypeNotPresentException){ println(e) }
}

fun <MyItem> printMyItem(item: MyItem) = println("Memory allocation of this: ${item.toString()} .")