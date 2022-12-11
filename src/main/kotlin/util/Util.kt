package util

val sep = System.lineSeparator()

fun loadInput(filename: String): String {
    return object {}.javaClass.classLoader.getResource(filename)?.readText()?.trim()
        ?: throw IllegalArgumentException("could not load input!")
}

fun <T : Any> T?.unwrap(msg: String?) : T {
    return this ?: throw IllegalStateException(msg ?: "expected not null")
}

fun <T : Any> List<T>.peek(c: (T) -> Unit) : List<T> {
    return this.map { c(it); it }
}

fun <T : Any> List<T>.inspect() : List<T> {
    return this.peek(::println)
}
