package day2

import println
import readInput
import kotlin.math.max

fun main() {
    check(part2(readInput("day2/Day02_test")) == 2286)

    part2(readInput("day2/Day02")).println()
}

private fun part2(strings: List<String>): Int = parseGames(strings).map(::calculateMinBag).sumOf(::power)

private fun calculateMinBag(game: Game): Bag =
    buildMap {
        for (round in game.rounds) {
            for ((cube, count) in round) {
                merge(cube, count, ::max)
            }
        }
    }

private fun power(bag: Bag): Int = bag.values.reduce(Int::times)

private typealias Bag = Map<String, Int>
