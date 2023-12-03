package day3

fun engineNumbers(table: List<String>): Sequence<EngineNumber> =
    sequence {
        for ((rowIndex, row) in table.withIndex()) {
            for (match in numberRegex.findAll(row)) {
                val number = match.value.toInt()
                val columnsRange = match.range
                yield(EngineNumber(number, adjacentCells(table, rowIndex, columnsRange)))
            }
        }
    }

private fun adjacentCells(table: List<String>, row: Int, columns: IntRange): Collection<Cell> {
    val adjacentPositions = buildList {
        val adjacentColumns = columns.first - 1..columns.last + 1
        for (column in adjacentColumns) {
            add(Position(row - 1, column))
            add(Position(row + 1, column))
        }
        add(Position(row, adjacentColumns.first))
        add(Position(row, adjacentColumns.last))
    }
    return adjacentPositions
        .filter { (row, column) -> row in table.indices && column in table[0].indices }
        .map { Cell(table[it.row][it.column], it) }
}

data class EngineNumber(val value: Int, val adjacentCells: Collection<Cell>)
data class Cell(val value: Char, val position: Position)
data class Position(val row: Int, val column: Int)

private val numberRegex = Regex("\\d+")
