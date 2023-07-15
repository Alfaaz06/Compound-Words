# Compound-Words

This Java program finds the longest and second longest compound words in a given list of words using a Trie data structure.

### How it Works

1. The program reads a list of words from a file (`Input_02.txt`).
2. It constructs a Trie data structure by inserting each word into the Trie using the `insert` method.
3. For each word, it finds all the prefixes that are also words in the Trie using the `prefixes` method.
4. It creates a list of compound words by combining the original word with the remaining substring after each prefix.
5. The program iterates through the list of compound words and finds the longest and second longest compound words based on their lengths.
6. Finally, it prints out the longest compound word, second longest compound word, and the execution time.

### How to Use

1. Ensure that you have a text file named `Input_02.txt` containing the list of words. Place the file in the same directory as the Java source code file (`index.java`).
2. Compile the Java source code using the Java compiler: `javac index.java`.
3. Run the compiled program using the Java Virtual Machine: `java index`.

### Note: Upate the path of the input file in index.java

### Dependencies

This program does not have any external dependencies. It uses standard Java libraries only.

### File Structure

- `index.java`: The main Java source code file.
- `Input_01.txt`: The first input file containing the list of words.
- `Input_02.txt`: The second input file containing the list of words.
