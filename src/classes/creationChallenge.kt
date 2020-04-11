package classes

class MovieList(private val genre: String?) {
    val movieList = ArrayList<String?>()
    fun addMovie(movie: String?) = movieList.add(movie)

    fun printMovies() {
        println(genre)
        movieList.withIndex().forEach {
            print("${it.index}. ${it.value}")
            if (it.index == movieList.withIndex().last().index)
                println(".\r")
            else
                print(", ")}
    }
}
class MovieGoer {
    val favoriteMovies: MutableMap<String, MovieList> = mutableMapOf()

    fun addGenre(genre: String) {
        favoriteMovies[genre] = MovieList(genre)
    }

    fun movieListFor(genre: String): MovieList? {
        return favoriteMovies.getOrDefault(genre, null)
    }

    fun addMovie(genre: String, movie: String?) {
        genre.toLowerCase().capitalize()
        if (!favoriteMovies.keys.contains(genre)) addGenre(genre)
        favoriteMovies[genre]?.addMovie(movie)
    }
}

enum class Genre {
    ACTION, DRAMA, COMEDY, TERROR;

    override fun toString(): String {
        return super.toString().toLowerCase().capitalize()
    }
}

fun automaticallyAddMovies(to: MovieGoer, from: MutableMap<String, MutableList<String>>) {
    for (genre in Genre.values()) to.addGenre(genre.toString())
    for (genre in Genre.values()) {
        from[genre.toString()]?.forEach { to.addMovie(genre.toString(), it) }
    }
}

fun main() {

    val actionMovies = mutableListOf("Rambo", "Saving private Ryan", "Hacksaw Ridge")
    val dramaMovies = mutableListOf("SpotLight", "Little Women", "Roma", "RocketMan")
    val comedyMovies = mutableListOf("BookSmart", "Good Boys", "Game Night", "Blockers", "22 Jump Street")

    val moviesGallery = mutableMapOf(
        Genre.ACTION.toString() to actionMovies,
        Genre.DRAMA.toString() to dramaMovies,
        Genre.COMEDY.toString() to comedyMovies)

    val moviesCollection = MovieGoer()
    automaticallyAddMovies(moviesCollection, moviesGallery)

    val john = MovieGoer()
    val jane = MovieGoer()
    john.addMovie(Genre.ACTION.toString(), "Underworld")
    jane.addMovie(Genre.ACTION.toString(), "Underworld II")

    println("Movies for John: ")
    john.movieListFor(Genre.ACTION.toString())?.printMovies() ?: println("List not found")

    println("Movies for Jane: ")
    jane.movieListFor(Genre.ACTION.toString())?.printMovies() ?: println("List not found")

    println("\rmoviesGallery: ")
//    println("${Genre.ACTION} movies: ")
    moviesCollection.movieListFor(Genre.ACTION.toString())?.printMovies() ?: println("List not found")
    moviesCollection.addMovie(Genre.ACTION.toString(), "Rambo II")
    println("Modified ${Genre.ACTION.toString().decapitalize()} movies: ")
    moviesCollection.movieListFor(Genre.ACTION.toString())?.printMovies() ?: println("List not found")

//    println("Terror movies: ")
    moviesCollection.addMovie("Terror", "The Ring")
    moviesCollection.movieListFor(Genre.TERROR.toString())?.printMovies() ?: println("List not found")

    println(moviesCollection.favoriteMovies.values.firstOrNull()?.movieSize)

}