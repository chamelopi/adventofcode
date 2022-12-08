package day1

import util.loadInput
import util.sep


fun main() {
    val input = loadInput("day1-input.txt")

    println(input
        .trim()
        .split(sep.repeat(2))
        .map { it.split(sep).map(Integer::parseInt).sum() }
        .sortedDescending()
        .take(3)
        .sum()
    )
}