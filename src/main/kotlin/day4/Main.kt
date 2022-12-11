package day4

import util.inspect
import util.loadInput

fun parseRange(elfPair: String): Pair<IntRange, IntRange> {
    val resultList = elfPair.split(",")
        .map { it.split("-").map(String::toInt) }
        .map { IntRange(it[0], it[1]) }

    if (resultList.size != 2) {
        throw IllegalArgumentException("group does not contain exactly two elves")
    }

    return Pair(resultList[0], resultList[1])
}

fun hasFullOverlap(p: Pair<IntRange, IntRange>): Boolean {
    return (p.first.contains(p.second.first) && p.first.contains(p.second.last))
            || (p.second.contains(p.first.first) && p.second.contains(p.first.last))
}

fun hasPartialOverlap(p: Pair<IntRange, IntRange>): Boolean {
    return (p.first.contains(p.second.first) || p.first.contains(p.second.last))
            || (p.second.contains(p.first.first) || p.second.contains(p.first.last))
}

fun main() {
    println(
        loadInput("day4-input.txt")
            .lines()
            .map(::parseRange)
            .filter(::hasPartialOverlap)
            .inspect()
            .size
    )
}
