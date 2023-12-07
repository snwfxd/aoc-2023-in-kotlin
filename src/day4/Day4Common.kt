package day4

fun cards(strings: List<String>): List<Card> = strings.map(::card)

private fun card(string: String): Card {
    val (winningNumbers, currentNumbers) = string.substringAfter(":").split("|").map(::numbers)
    return Card(winningNumbers.intersect(currentNumbers).size)
}

private fun numbers(string: String): Set<Int> = numberRegex.findAll(string).mapTo(mutableSetOf()) { it.value.toInt() }

private val numberRegex = Regex("\\d+")

data class Card(val wins: Int)
