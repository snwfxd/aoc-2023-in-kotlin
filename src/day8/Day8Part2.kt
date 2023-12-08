package day8

import println
import readInput

fun main() {
    check(part2(readInput("day8/Day8_p2_test")) == 6L)

    part2(readInput("day8/Day8")).println()
}

private fun part2(strings: List<String>): Long {
    val (instructions, nodes) = parse(strings)
    val startNodes = nodes.keys.filter { it.endsWith('A') }
    val stepCounts = startNodes.map { countSteps(it, instructions, nodes) { node -> node.endsWith('Z') } }
    return stepCounts.map(Int::toLong).reduce(::lcm)
}

private fun lcm(n1: Long, n2: Long): Long = n1 / n1.toBigInteger().gcd(n2.toBigInteger()).toLong() * n2
