package day1

class CalibrationExtractor(private val strToDigit: Map<String, Int>) {
    fun extract(strings: List<String>): Int = strings.sumOf(::extractCalibrationValue)

    private fun extractCalibrationValue(string: String): Int {
        val firstDigit = extractDigit(string::findAnyOf)
        val lastDigit = extractDigit(string::findLastAnyOf)
        return firstDigit * 10 + lastDigit
    }

    private fun extractDigit(searchAnyOf: (Collection<String>) -> Pair<Int, String>?): Int {
        val (_, foundKey) = searchAnyOf(strToDigit.keys)!!
        return strToDigit.getValue(foundKey)
    }
}
