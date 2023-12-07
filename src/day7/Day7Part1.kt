package day7

import println
import readInput

fun main() {
    check(part1(readInput("day7/Day7_test")) == 6440)

    part1(readInput("day7/Day7")).println()
}

private fun part1(strings: List<String>): Int = totalWinnings(strings, ::SimpleHand)

private class SimpleHand(cards: String) : Hand() {
    override val combinationRank: Comparable<*> =
        cards.groupingBy { it }.eachCount().values.sortedDescending().toComparable()

    override val cardsRank: Comparable<*> = cards.map(cardToRank::getValue).toComparable()
}

private val cardToRank = listOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
    .withIndex()
    .associateBy({ it.value }, { it.index })
