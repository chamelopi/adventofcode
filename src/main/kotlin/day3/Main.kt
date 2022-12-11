package day3

import util.loadInput
import util.sep

fun getCompartments(rucksack: String): Pair<String, String> {
    val half = rucksack.length / 2;
    return Pair(rucksack.substring(0, half), rucksack.substring(half))
}

fun getSharedItems(compartments: Pair<String, String>): List<Char> {
    return compartments.first.toList().filter { compartments.second.contains(it) }
        .distinct()
}

val keys = ('a' .. 'z') + ('A' .. 'Z')
val values = (1..52)
val itemPriorities = keys.zip(values).toMap()

fun getPriorityOfItem(item: Char): Int {
    return itemPriorities.getValue(item)
}

fun part1(): Int {
    return loadInput("day3-input.txt")
        .split(sep)
        .map(::getCompartments)
        .map(::getSharedItems)
        .sumOf { it.map(::getPriorityOfItem).sum() }
}

fun main() {
    println(part1())
}