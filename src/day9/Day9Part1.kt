package day9

import println
import readInput

fun main() {
    check(part1(readInput("day9/Day9_test")) == 114)

    part1(readInput("day9/Day9")).println()
}

private fun part1(strings: List<String>): Int = strings.map(String::toInts).sumOf(::next)

private fun next(numbers: List<Int>): Int {
    val ends = diffs(numbers).map { it.last() }
    return ends.sum()
}
