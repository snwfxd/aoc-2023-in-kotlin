package day9

fun String.toInts(): List<Int> = split(" ").map(String::toInt)

fun diffs(numbers: List<Int>): Sequence<List<Int>> =
    generateSequence(numbers) { nums -> nums.zipWithNext { n1, n2 -> n2 - n1 } }
        .takeWhile { nums -> nums.any { it != 0 } }