package types

class Date(val dateString: String) {
    init {
        val regex = """\d{2}\.\d{2}\.\d{4}""".toRegex()
        if (!dateString.matches(regex)) {
            throw IllegalArgumentException()
        }
    }
}