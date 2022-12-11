package day3

import util.loadInput

fun getCompartments(rucksack: String): Pair<String, String> {
    val half = rucksack.length / 2
    return Pair(rucksack.substring(0, half), rucksack.substring(half))
}

// This could have been simplified because we assume there is only one shared item
fun getSharedItems(compartments: Pair<String, String>): List<Char> {
    return compartments.first.toList().filter { compartments.second.contains(it) }
        .distinct()
}

fun getSharedItems(rucksacks: Triple<String, String, String>): Char {
    return rucksacks.first.toList()
        .filter { rucksacks.second.contains(it) }
        .firstOrNull { rucksacks.third.contains(it) } ?: throw NoSuchElementException("could not find shared item!")
}


val keys = ('a'..'z') + ('A'..'Z')
val values = (1..52)
val itemPriorities = keys.zip(values).toMap()

fun getPriorityOfItem(item: Char): Int {
    return itemPriorities.getValue(item)
}

fun part1(): Int {
    return loadInput("day3-input.txt")
        .lines()
        .map(::getCompartments)
        .map(::getSharedItems)
        .sumOf { it.map(::getPriorityOfItem).sum() }
}

fun <T> toTriple(l: List<T>): Triple<T, T, T> {
    if (l.size != 3) {
        throw IllegalArgumentException("list does not have 3 elements!")
    }
    return Triple(l[0], l[1], l[2])
}

// Every set of three lines is one group, find the item that is in all three rucksacks
fun part2(): Int {
    return loadInput("day3-input.txt")
        .lines()
        .chunked(3)
        .map(::toTriple)
        .map(::getSharedItems)
        .sumOf { getPriorityOfItem(it) }
}

fun main() {
    println(part2())
}