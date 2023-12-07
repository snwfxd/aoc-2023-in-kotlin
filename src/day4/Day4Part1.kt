package day4

import println
import readInput
import kotlin.math.pow

fun main() {
    check(part1(readInput("day4/Day4_test")) == 13)

    part1(readInput("day4/Day4")).println()
}

private fun part1(strings: List<String>): Int = cards(strings).sumOf(Card::points)

private fun Card.points(): Int = 2.0.pow(wins - 1).toInt()
