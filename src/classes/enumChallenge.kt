package classes

enum class Animals {
    CAT, DOG, RAT, BIRD, HAMSTER
}

enum class Cage {
    SMALL, MEDIUM, LARGE
}

fun addAnimalToCage(animals: Animals, cage: Cage) {
    println("The $animals is in the $cage cage")
}

fun main() {
    addAnimalToCage(Animals.CAT, Cage.MEDIUM)
    addAnimalToCage(Animals.DOG, Cage.LARGE)
    addAnimalToCage(Animals.RAT, Cage.SMALL)
    addAnimalToCage(Animals.BIRD, Cage.SMALL)
    addAnimalToCage(Animals.HAMSTER, Cage.SMALL)
}