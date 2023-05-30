package types

class States(val statesOfMind: String?) {
    init {
        require(statesOfMind in setOf("value1", "value2", "value3", "value4", "value5")) {
            "Invalid value: $statesOfMind"
        }
    }
}
