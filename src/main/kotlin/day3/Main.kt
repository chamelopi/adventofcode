package day3

fun getCompartments(rucksack: String): Pair<String, String> {
    val half = rucksack.length / 2;
    return Pair(rucksack.substring(0, half), rucksack.substring(half))
}

fun getSharedItems(compartments: Pair<String, String>): List<Char> {
    return compartments.first.filter { compartments.second.contains(it) }
        .toCharArray().toList()
}

val keys = ('a' .. 'z') + ('A' .. 'z')
val values = (1..52)
val itemPriorities = keys.zip(values).toMap()

fun getPriorityOfItem(item: Char): Int {
    return itemPriorities.getValue(item)
}

fun main() {
    // TODO
}