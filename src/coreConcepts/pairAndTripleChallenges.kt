package coreConcepts

fun main() {

    val bornDate = Pair(10, 5)
    val (month, day) = bornDate

    print("You were born on month $month day $day")

    val bornDateWithYear = Triple (10, 5, 95)
    println(" of the year ${bornDateWithYear.third}")
    /* Pairs and Triples
    Declare a constant Pair that contains two Int values. Use this to represent a date (month, day).
 */

/*
 In one line, read the day and month values into two constants.
 */


/*
 Now create a Triple using the month, day and year */
}