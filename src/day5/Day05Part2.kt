package day5

import println
import readInput

fun main() {
    check(part2(readInput("day5/Day05_test")) == 46L)

    part2(readInput("day5/Day05")).println()
}

private fun part2(input: List<String>): Long = minLocation(input, seedRanges(input[0]))

private fun seedRanges(string: String) = seeds(string).chunked(2).map { (start, length) -> start..<start + length }