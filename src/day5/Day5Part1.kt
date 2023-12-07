package day5

import println
import readInput

fun main() {
    check(part1(readInput("day5/Day5_test")) == 35L)

    part1(readInput("day5/Day5")).println()
}

private fun part1(input: List<String>): Long = minLocation(input, seedRanges(input[0]))

private fun seedRanges(string: String): List<LongRange> = seeds(string).map { it..it }
