package day6

import println
import readInput

fun main() {
    check(part1(readInput("day6/Day6_test")) == 288L)

    part1(readInput("day6/Day6")).println()
}

private fun part1(input: List<String>): Long {
    val times = input[0].toNumbers()
    val records = input[1].toNumbers()
    val games = times.zip(records, ::Game)
    return games.map(Game::waysToWin).reduce(Long::times)
}

private fun String.toNumbers(): Sequence<Long> = numberRegex.findAll(this).map { it.value.toLong() }

private val numberRegex = Regex("\\d+")
