package collections

fun main() {
    val names = listOf("Anna", "Brian", "Craig", "Donna")
    println(names)

    val teamNames = mutableListOf<String>()
    teamNames.addAll(names)
    println(teamNames)

    teamNames.add("Sam")
    teamNames.add("Jan")
    println(teamNames)

    println(teamNames[0])
    println(teamNames.indexOf("Brian"))

    teamNames.remove("Craig")
    println(teamNames)
}