package day3

import println
import readInput

fun main() {
    check(part1(readInput("day3/Day03_test")) == 4361)

    part1(readInput("day3/Day03")).println()
}

private fun part1(table: List<String>): Int =
    engineNumbers(table).filter(EngineNumber::isPartNumber).sumOf(EngineNumber::value)

private fun EngineNumber.isPartNumber(): Boolean = adjacentCells.any(Cell::isSymbol)

private fun Cell.isSymbol(): Boolean = value != '.' && !value.isDigit()
