package day5

import kotlin.math.max
import kotlin.math.min

fun seeds(string: String): List<Long> = string.substringAfter(": ").split(" ").map(String::toLong)

fun minLocation(input: List<String>, seedRanges: Collection<LongRange>): Long {
    val rangeMappings = input.drop(2).joinToString("\n").split("\n\n").map(::rangeMapping)
    val locations = rangeMappings.fold(seedRanges, ::convert)
    return locations.minOf(LongRange::first)
}

private fun rangeMapping(input: String): List<RangeMapping> {
    val mappings = input.lines().drop(1).map(String::toRangeMapping).sortedBy { it.source.first }
    val dummyMappings = generateDummyRanges(mappings.map(RangeMapping::source)).map { RangeMapping(it, 0) }
    return (mappings + dummyMappings)
}

private fun String.toRangeMapping(): RangeMapping {
    val (destinationStart, sourceStart, length) = split(" ").map(String::toLong)
    return RangeMapping(sourceStart..<sourceStart + length, destinationStart - sourceStart)
}

private fun generateDummyRanges(sortedMappedRanges: List<LongRange>): List<LongRange> {
    val bounds = listOf(0L) + sortedMappedRanges.flatMap { listOf(it.first - 1, it.last + 1) } + Long.MAX_VALUE
    return bounds.chunked(2).map { (first, last) -> first..last }.filterNot(LongRange::isEmpty)
}

private fun convert(ranges: Collection<LongRange>, rangeMapping: List<RangeMapping>): Collection<LongRange> =
    ranges.flatMapTo(mutableSetOf()) { range -> rangeMapping.mapNotNull(range::convert) }

private fun LongRange.convert(mapping: RangeMapping): LongRange? =
    overlap(mapping.source)?.shift(mapping.destinationOffset)

private fun LongRange.overlap(other: LongRange): LongRange? {
    val first = max(first, other.first)
    val last = min(last, other.last)
    return (first..last).takeUnless(LongRange::isEmpty)
}

private fun LongRange.shift(offset: Long): LongRange = first + offset..last + offset

private data class RangeMapping(val source: LongRange, val destinationOffset: Long)