package classes

data class PodCast(
    val title: String, val description: String,
    val url: String
)

fun main() {
    val podCast = PodCast("Android Central", "The premier source for weekly news.", "https://feeds.feedburner.com/")
    val mutedPodCast = podCast.copy(title = "Developers Backstage")
    val (title, _, url) = mutedPodCast
    println("PodCast title: $title, url: $url")
}