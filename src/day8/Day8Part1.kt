package day8

import println
import readInput

fun main() {
    check(part1(readInput("day8/Day8_test")) == 2)
    check(part1(readInput("day8/Day8_test2")) == 6)

    part1(readInput("day8/Day8")).println()
}

private fun part1(strings: List<String>): Int {
    val (instructions, nodes) = parse(strings)
    return countSteps("AAA", instructions, nodes) { it == "ZZZ" }
}
