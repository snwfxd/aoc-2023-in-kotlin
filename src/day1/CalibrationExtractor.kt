package day1

typealias DigitExtractor = (string: String, startIndex: Int) -> Int?

class CalibrationExtractor(private val digitExtractors: List<DigitExtractor>) {
    fun extract(lines: List<String>): Int = lines.sumOf(::extractCalibrationValue)

    private fun extractCalibrationValue(string: String): Int {
        val firstDigit = findFirstDigit(string)
        val lastDigit = findFirstDigit(string, reverseSearch = true)
        return firstDigit * 10 + lastDigit
    }

    private fun findFirstDigit(string: String, reverseSearch: Boolean = false): Int {
        val indicesToSearch = if (!reverseSearch) string.indices else string.indices.reversed()
        return indicesToSearch.firstNotNullOf { index -> extractDigit(string, index) }
    }

    private fun extractDigit(string: String, startIndex: Int): Int? =
        digitExtractors.firstNotNullOfOrNull { extract -> extract(string, startIndex) }
}
