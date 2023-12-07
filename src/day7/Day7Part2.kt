package day7

import println
import readInput

fun main() {
    check(part2(readInput("day7/Day7_test")) == 5905)

    part2(readInput("day7/Day7")).println()
}

private fun part2(strings: List<String>) = totalWinnings(strings, ::JokerAwareHand)

private class JokerAwareHand(val cards: String) : Hand() {
    override val combinationRank: Comparable<*> = run {
        val countsWithJoker = cards.groupingBy { it }.eachCount()
        val jokerCount = countsWithJoker[joker] ?: 0
        val countsWithoutJoker = countsWithJoker.minus(joker).values.sortedDescending().toMutableList()
        if (countsWithoutJoker.isEmpty()) {
            countsWithoutJoker.add(jokerCount)
        } else {
            countsWithoutJoker[0] += jokerCount
        }
        countsWithoutJoker.toComparable()
    }

    override val cardsRank: Comparable<*> = cards.map(cardToRank::getValue).toComparable()
}

private const val joker = 'J'

private val cardToRank = listOf(joker, '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A')
    .withIndex()
    .associateBy({ it.value }, { it.index })
