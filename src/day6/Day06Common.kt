package day6

fun Game.waysToWin(): Long {
    val winTimeFirst = (1..<timeLimit).find(::isWinTime)!!
    val winTimeLast = (1..<timeLimit).reversed().find(::isWinTime)!!
    return winTimeLast - winTimeFirst + 1
}

private fun Game.isWinTime(time: Long): Boolean = time * (timeLimit - time) > record

data class Game(val timeLimit: Long, val record: Long)
