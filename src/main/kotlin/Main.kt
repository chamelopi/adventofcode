fun loadInput(): String {
    return object {}.javaClass.classLoader.getResource("day1-input.txt")?.readText()
        ?: throw IllegalArgumentException("could not load input!")
}


fun main(args: Array<String>) {
    val sep = System.lineSeparator()
    val input = loadInput()

    println(input
        .trim()
        .split(sep.repeat(2))
        .map { it.split(sep).map(Integer::parseInt).sum() }
        .sortedDescending()
        .take(3)
        .sum()
    )
}