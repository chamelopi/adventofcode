package util

val sep = System.lineSeparator();

fun loadInput(filename: String): String {
    return object {}.javaClass.classLoader.getResource(filename)?.readText()
        ?: throw IllegalArgumentException("could not load input!")
}

fun <T : Any> T?.unwrap() : T {
    return this ?: throw IllegalStateException("expected not null")
}

fun <T : Any> List<T>.peek(c: (T) -> Unit) : List<T> {
    return this.map { c(it); it };
}
