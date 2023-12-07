package day3

import println
import readInput

fun main() {
    check(part2(readInput("day3/Day3_test")) == 467835)

    part2(readInput("day3/Day3")).println()
}

private fun part2(table: List<String>): Int = stars(table).mapNotNull(Star::toGear).sumOf(Gear::ratio)

private fun stars(table: List<String>): Collection<Star> =
    buildMap<Cell, MutableList<Int>> {
        for (number in engineNumbers(table)) {
            for (starCell in number.adjacentStars()) {
                getOrPut(starCell) { mutableListOf() }.add(number.value)
            }
        }
    }.values

private fun EngineNumber.adjacentStars(): List<Cell> = adjacentCells.filter { it.value == '*' }

private fun Star.toGear(): Gear? = if (size == 2) Gear(this[0], this[1]) else null

private fun Gear.ratio(): Int = first * second

private typealias Star = List<Int>
private typealias Gear = Pair<Int, Int>
