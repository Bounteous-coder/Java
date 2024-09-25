// Numan Salahuddin - 251264939

/**
 Represents a linked list or nodes of words for a guessing game.
 --The WordLL class is designed to store and manage a list of guessed words. It is used in a guessing game where players try to guess a secret word.
 The class keeps track of the history of guessed words.
 --Approach of the Design:
 --For implementing the WordLL class, we used a linked list to store the guessed words.
 Each guessed word is added to the front of the list, so the latest guess is always at the beginning.
 --Challenges to face:
 --One challenge we faced was updating the history of guessed words correctly. To overcome this, we used a linked list to maintain the order of the guesses.
 --Testing cases:
 --To test the WordLL class, we created different test cases.
 We checked
 if the history is updated correctly after each guess.
 if the labeling of correct and unused letters works properly.
 if the toString() method gives the right representation of the guessed word history and the secret word.
 We tested various scenarios to ensure the WordLL class works well.
 --The WordLL class is designed with simplicity and a clear understanding of its functionality.
 The best approach, challenges faced, and testing process ensure the class works reliably in a guessing game.
 */

public class WordLL {
    private Word mysteryWord;             // Stores the secret word
    private LinearNode<Word> history;     // Stores the history of guessed words

    public WordLL(Word mystery) {
        mysteryWord = mystery;
        history = null;                   // Start with an empty history
    }

    public boolean tryWord(Word guess) {
        guess.labelWord(mysteryWord);     // Label the guess based on the secret word
        LinearNode<Word> current = new LinearNode<>(guess);   // Create a new guess node
        current.setNext(history);         // Set the next node as the previous history
        history = current;                 // Update history to the current guess

        return guess.toString().equals(mysteryWord.toString());  // Check if the guess matches the secret word
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<Word> current = history;
        while (current != null) {
            sb.insert(0, current.getElement().toString() + "\n");   // Add the guessed word to the history
            current = current.getNext();        // Move to the next node in the history
        }
        sb.append("Secret Word: ").append(mysteryWord.toString());   // Append the secret word to the history
        return sb.toString();
    }
}