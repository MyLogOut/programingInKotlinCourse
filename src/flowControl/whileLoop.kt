package flowControl

fun main() {
    var acumulator = 1

    while (acumulator < 10) {
        print(acumulator); acumulator+=1}
    println()
    acumulator = 1
    do { print(acumulator); acumulator+=1 } while (acumulator<10)
    println()
    acumulator = 1
    do { print(acumulator); acumulator+=1; if (acumulator==5) break } while (acumulator < 10)
}