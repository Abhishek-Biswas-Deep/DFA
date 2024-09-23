<img src="https://github.com/user-attachments/assets/2ad86f70-12b4-4500-997d-9f8c1874a9b5" alt="Dal logo" width="80"/>
<h1>Associated with Dalhousie University</h1>

### CSCI2115

### DFA
This project is a simple Deterministic Finite Automaton (DFA) simulator written in Kotlin. It reads DFA configuration from a file, takes an input string from the user, and checks if the input string is accepted by the DFA based on its transition table.

### Features
- Reads DFA configuration (states, alphabet, start state, accept states, transitions) from a file.
- Allows the user to input a string to test.
- Determines if the input string is accepted or rejected by the DFA.
- Simple, easy-to-understand file format for defining DFAs.

### How to Run
Clone the repository and run the project.

### DFA Configuration File Format
The DFA configuration file should contain the following sections:
- States: Comma-separated list of states.
- Alphabet: Comma-separated list of input symbols.
- Start state: The starting state of the DFA.
- Accept states: Comma-separated list of accept states.
- Transitions: Transitions between states based on input symbols in the format currentState,inputSymbol->nextState.

### Example DFA Configuration (dfa.txt):
```
states: q0,q1,q2
alphabet: 0,1
start: q0
accept: q2
transitions:
q0,0->q1
q0,1->q0
q1,0->q2
q1,1->q1
q2,0->q2
q2,1->q2
```

### Example Execution:
```
Enter the name of the DFA configuration file: dfa.txt
Enter the input string (consisting of the alphabet symbols): 0010
Input string is ACCEPTED by the DFA.
```

### How It Works
1. DFA Definition: The DFA is defined by states, alphabet, start state, accept states, and transitions.
2. Input String: The user inputs a string consisting of symbols from the DFA's alphabet.
3. Processing: The program processes the string according to the DFA's transition table, moving between states based on the input symbols.
4. Result: After processing the string, the DFA checks if it ends in an accept state. If so, the string is accepted; otherwise, it is rejected.

### Contributing
Feel free to fork this repository, make improvements, and submit pull requests.
