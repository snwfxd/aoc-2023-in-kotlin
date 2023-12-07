package day7

fun totalWinnings(strings: List<String>, createHand: (String) -> Hand): Int =
    strings.map { it.toHandBid(createHand) }
        .sortedBy(HandBid::hand)
        .withIndex()
        .sumOf { it.value.bid * (it.index + 1) }

private fun String.toHandBid(createHand: (String) -> Hand): HandBid {
    val (hand, bid) = split(" ")
    return HandBid(createHand(hand), bid.toInt())
}

abstract class Hand : Comparable<Hand> {
    abstract val combinationRank: Comparable<*>
    abstract val cardsRank: Comparable<*>

    override fun compareTo(other: Hand): Int = compareBy(Hand::combinationRank, Hand::cardsRank).compare(this, other)
}

fun <T : Comparable<T>> List<T>.toComparable(): Comparable<*> = ComparableList(this)

@JvmInline
private value class ComparableList<T : Comparable<T>>(private val list: List<T>) : Comparable<ComparableList<T>> {
    override fun compareTo(other: ComparableList<T>): Int {
        for ((elem1, elem2) in list.zip(other.list)) {
            if (elem1 != elem2) {
                return compareValues(elem1, elem2)
            }
        }
        return list.size - other.list.size
    }
}

private data class HandBid(val hand: Hand, val bid: Int)
