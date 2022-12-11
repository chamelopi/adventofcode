package day1

import util.loadInput
import util.sep


fun main() {
    val input = loadInput("day1-input.txt")

    println(input
        .split(sep.repeat(2))
        .map { it.lines().map(Integer::parseInt).sum() }
        .sortedDescending()
        .take(3)
        .sum()
    )
}