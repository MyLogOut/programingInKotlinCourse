package classes

fun String.lastChar() = this[this.length-1]

val MovieList.movieSize: Int
    get() = movieList.size

fun main() {
    println("The last char in this 'text chain' is: [${"text chain".lastChar()}]")

    val actionMovies = mutableListOf("Rambo", "Saving private Ryan", "Hacksaw Ridge")
    val dramaMovies = mutableListOf("SpotLight", "Little Women", "Roma", "RocketMan")
    val comedyMovies = mutableListOf("BookSmart", "Good Boys", "Game Night", "Blockers", "22 Jump Street")

    val moviesGallery = mutableMapOf(
        Genre.ACTION.toString() to actionMovies,
        Genre.DRAMA.toString() to dramaMovies,
        Genre.COMEDY.toString() to comedyMovies)

    val moviesCollection = MovieGoer()
    automaticallyAddMovies(moviesCollection, moviesGallery)

    println("Number of movies currently in favorites: ${moviesCollection.favoriteMovies.values.firstOrNull()?.movieSize}")
}