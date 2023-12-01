package day1

import println
import readInput

fun main() {
    val calibrationExtractor = CalibrationExtractor(listOf(::extractCharDigit, ::extractWordDigit))

    check(calibrationExtractor.extract(readInput("day1/Day01_p2_test")) == 281)

    calibrationExtractor.extract(readInput("day1/Day01")).println()
}

private fun extractWordDigit(string: String, startIndex: Int): Int? =
    wordToDigit.entries.firstOrNull { (word, _) -> string.startsWith(word, startIndex) }?.value

private val wordToDigit = mapOf(
    "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9
)
