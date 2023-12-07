package day2

import println
import readInput

fun main() {
    check(part1(readInput("day2/Day2_test")) == 8)

    part1(readInput("day2/Day2")).println()
}

private fun part1(strings: List<String>): Int = parseGames(strings).filter(::isValid).sumOf(Game::id)

private fun isValid(game: Game): Boolean = game.rounds.all(::isValid)

private fun isValid(round: Round): Boolean = elfBag.all { (cube, bagCount) -> round.getOrDefault(cube, 0) <= bagCount }

private val elfBag = mapOf("red" to 12, "green" to 13, "blue" to 14)
