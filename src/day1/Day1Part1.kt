package day1

import println
import readInput

fun main() {
    val calibrationExtractor = CalibrationExtractor(charToDigit)

    check(calibrationExtractor.extract(readInput("day1/Day1_p1_test")) == 142)

    calibrationExtractor.extract(readInput("day1/Day1")).println()
}

val charToDigit: Map<String, Int> = (0..9).associateBy(Int::toString)
