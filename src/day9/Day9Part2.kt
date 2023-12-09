package day9

import println
import readInput

fun main() {
    check(part2(readInput("day9/Day9_test")) == 2)

    part2(readInput("day9/Day9")).println()
}

fun part2(strings: List<String>): Int = strings.map(String::toInts).sumOf(::prev)

fun prev(numbers: List<Int>): Int {
    val starts = diffs(numbers).map { it.first() }.toList().reversed()
    return starts.reduce { a, b -> b - a }
}