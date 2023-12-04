package day4

import println
import readInput

fun main() {
    check(part2(readInput("day4/Day04_test")) == 30)

    part2(readInput("day4/Day04")).println()
}

private fun part2(strings: List<String>): Int {
    val cards = cards(strings).map { CountedCard(it.wins) }

    for ((index, card) in cards.withIndex()) {
        for (nextCard in cards.slice(index.nextN(card.wins))) {
            nextCard.count += card.count
        }
    }

    return cards.sumOf(CountedCard::count)
}

private fun Int.nextN(n: Int): IntRange = this + 1..this + n

private class CountedCard(val wins: Int, var count: Int = 1)
