package day1

import println
import readInput

fun main() {
    val calibrationExtractor = CalibrationExtractor(listOf(::extractCharDigit))

    check(calibrationExtractor.extract(readInput("day1/Day01_p1_test")) == 142)

    calibrationExtractor.extract(readInput("day1/Day01")).println()
}

fun extractCharDigit(string: String, index: Int): Int? = string[index].digitToIntOrNull()
