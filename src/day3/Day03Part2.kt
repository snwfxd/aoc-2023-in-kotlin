package day3

import println
import readInput

fun main() {
    check(part2(readInput("day3/Day03_test")) == 467835)

    part2(readInput("day3/Day03")).println()
}

private fun part2(table: List<String>): Int = gears(table).sumOf(Gear::ratio)

private fun gears(table: List<String>): Collection<Gear> {
    val starToAdjacentNumbers = buildMap<Cell, MutableList<Int>> {
        for (number in engineNumbers(table)) {
            for (starCell in number.adjacentStars()) {
                getOrPut(starCell) { mutableListOf() }.add(number.value)
            }
        }
    }
    return starToAdjacentNumbers.values.mapNotNull(List<Int>::toGear)
}

private fun EngineNumber.adjacentStars(): List<Cell> = adjacentCells.filter { it.value == '*' }

private fun List<Int>.toGear(): Gear? = if (size == 2) Gear(this[0], this[1]) else null

private data class Gear(val number1: Int, val number2: Int) {
    fun ratio(): Int = number1 * number2
}
