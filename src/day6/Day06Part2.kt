package day6

import println
import readInput

fun main() {
    check(part2(readInput("day6/Day06_test")) == 71503L)

    part2(readInput("day6/Day06")).println()
}

private fun part2(input: List<String>): Long = Game(input[0].toNumber(), input[1].toNumber()).waysToWin()

private fun String.toNumber(): Long = substringAfter(":").replace(" ", "").toLong()
