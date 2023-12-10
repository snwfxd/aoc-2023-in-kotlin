package day9

fun String.toInts(): List<Int> = split(" ").map(String::toInt)

fun next(numbers: List<Int>): Int {
    val ends = generateSequence(numbers) { nums -> nums.zipWithNext { n1, n2 -> n2 - n1 } }
        .takeWhile { nums -> nums.any { it != 0 } }
        .map { it.last() }
    return ends.sum()
}