package day2

fun parseGames(strings: List<String>): List<Game> = strings.map(::parseGame)

private fun parseGame(string: String): Game {
    val (idStr, roundsStr) = string.split(": ")
    val id = idStr.removePrefix("Game ").toInt()
    val rounds = roundsStr.split("; ").map(::parseRound)
    return Game(id, rounds)
}

private fun parseRound(string: String): Round = string.split(", ").associate(::parseCubeCount)

private fun parseCubeCount(string: String): CubeCount {
    val (count, cube) = string.split(" ")
    return cube to count.toInt()
}

data class Game(val id: Int, val rounds: List<Round>)

typealias Round = Map<String, Int>

private typealias CubeCount = Pair<String, Int>
