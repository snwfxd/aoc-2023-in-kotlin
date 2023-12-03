package day1

class CalibrationExtractor(private val strToDigit: Map<String, Int>) {
    fun extract(strings: List<String>): Int = strings.sumOf(::extractCalibrationValue)

    private fun extractCalibrationValue(string: String): Int {
        val firstDigit = string.findAnyOf(strToDigit.keys).getValue()
        val lastDigit = string.findLastAnyOf(strToDigit.keys).getValue()
        return firstDigit * 10 + lastDigit
    }

    private fun Pair<Int, String>?.getValue(): Int {
        val (_, foundKey) = this!!
        return strToDigit.getValue(foundKey)
    }
}
