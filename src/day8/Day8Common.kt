package day8

fun parse(strings: List<String>): Pair<Instructions, Nodes> {
    val instructions = instructions(strings[0])
    val nodes = buildMap {
        for (string in strings.drop(2)) {
            val (node, nextNodes) = string.split(" = ")
            val (left, right) = nextNodes.removeSurrounding("(", ")").split(", ")
            put(node, Pair(left, right))
        }
    }
    return Pair(instructions, nodes)
}

fun countSteps(startNode: String, instructions: Instructions, nodes: Nodes, isEndNode: (String) -> Boolean): Int {
    val nodePath = generateSequence(startNode) { node ->
        val (left, right) = nodes.getValue(node)
        if (instructions.next() == 'L') left else right
    }
    return nodePath.takeWhile { !isEndNode(it) }.count()
}

private fun instructions(steps: String): Instructions =
    iterator {
        while (true) {
            yieldAll(steps.asSequence())
        }
    }

typealias Instructions = Iterator<Char>
typealias Nodes = Map<String, NextNodes>
typealias NextNodes = Pair<String, String>