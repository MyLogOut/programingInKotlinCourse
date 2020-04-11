package classes

interface Animal {
    fun eat()
    fun producedSound()
}

class Dog() : Animal {
    override fun eat() {
        println("Dog eating loudly")
    }

    override fun producedSound() {
        println("Wof, Wof!")
    }
}

class Cat() : Animal {
    override fun eat() {
        println("Cat eating softly")
    }

    override fun producedSound() {
        println("Meow, meow")
    }
}

fun main() {
    val dog = Dog()
    val cat = Cat()

    dog.producedSound()
    dog.eat()
    dog.producedSound()

    cat.producedSound()
    cat.eat()
}
