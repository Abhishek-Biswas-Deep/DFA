import java.io.File

// Data class to hold the DFA structure
data class DFA(
    val states: Set<String>,
    val alphabet: Set<Char>,
    val startState: String,
    val acceptStates: Set<String>,
    val transitions: Map<Pair<String, Char>, String>
) {
    // Process the input string and return if it's accepted by the DFA
    fun isAccepted(input: String): Boolean {
        var currentState = startState
        for (symbol in input) {
            val key = Pair(currentState, symbol)
            if (!transitions.containsKey(key)) {
                return false // Invalid transition
            }
            currentState = transitions[key]!!
        }
        return currentState in acceptStates
    }
}

fun main() {
    // Ask the user for the file name
    print("Enter the name of the DFA configuration file: ")
    val fileName = readLine()

    if (fileName != null) {
        val dfa = readDFAFromFile(fileName)

        if (dfa != null) {
            // Ask the user for an input string
            print("Enter the input string (consisting of the alphabet symbols): ")
            val inputString = readLine()

            if (inputString != null) {
                // Process the input string using the DFA
                val result = dfa.isAccepted(inputString)
                if (result) {
                    println("Input string is ACCEPTED by the DFA.")
                } else {
                    println("Input string is REJECTED by the DFA.")
                }
            }
        } else {
            println("Error: Could not read the DFA configuration from the file.")
        }
    }
}

// Function to read the DFA configuration from a file
fun readDFAFromFile(fileName: String): DFA? {
    try {
        val file = File(fileName)
        val lines = file.readLines()

        val states = lines[0].substringAfter("states: ").split(",").toSet()
        val alphabet = lines[1].substringAfter("alphabet: ").toCharArray().toSet()
        val startState = lines[2].substringAfter("start: ")
        val acceptStates = lines[3].substringAfter("accept: ").split(",").toSet()

        val transitions = mutableMapOf<Pair<String, Char>, String>()
        for (i in 5 until lines.size) {
            val (from, to) = lines[i].split("->")
            val (state, symbol) = from.split(",")
            transitions[Pair(state, symbol[0])] = to
        }

        return DFA(states, alphabet, startState, acceptStates, transitions)
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        return null
    }
}
