package day9

import println
import readInput

fun main() {
    check(part2(readInput("day9/Day9_test")) == 2)

    part2(readInput("day9/Day9")).println()
}

fun part2(strings: List<String>): Int = strings.map { it.toInts().reversed() }.sumOf(::next)
