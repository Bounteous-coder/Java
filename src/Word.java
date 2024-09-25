// Numan Salahuddin - 251264939
public class Word {
    private LinearNode<Letter> firstLetter;
    // Represents the first letter node of the word
    // LinearNode is a class that represents a node in a linked list
    // Letter is another class representing a single letter
    public Word(Letter[] letters) {
        // Constructor method that takes an array of letters as input

        if (letters.length < 1)
            firstLetter = null;
            // If the array is empty, set the first letter as null (indicating an empty word)

        else {
            // Otherwise, create a linked list of letter nodes

            LinearNode<Letter> next = new LinearNode<>();
            // Create a temporary node for iteration

            firstLetter = new LinearNode<>(letters[0]);
            // Create the first letter node using the first letter from the input array

            next = firstLetter;
            // Set the temporary node as the first letter node

            // Iterate through the remaining letters and create corresponding nodes
            for (int i = 1; i < letters.length; i++) {
                next.setNext(new LinearNode<>(letters[i]));
                next = next.getNext();
            }
        }
    }

    public String toString() {
        // Method that returns a string representation of the word

        String toPrint = "Word: ";
        // Create a string variable to hold the word

        LinearNode<Letter> next = new LinearNode<>();
        next = firstLetter;
        // Create a temporary node and set it as the first letter node

        // Iterate through each letter node and concatenate their string representation
        while (next != null) {
            toPrint += next.getElement().toString() + " ";
            // Get the letter from the current node and add it to the string representation of the word

            next = next.getNext();
            // Move to the next letter node
        }

        return toPrint;
        // Return the string representation of the word
    }

    public boolean labelWord(Word mystery) { // Method that compares two words and labels the letters
        boolean result = true; // Create a boolean variable to track the result (true by default)
        LinearNode<Letter> currentM = mystery.firstLetter;
        LinearNode<Letter> currentG = this.firstLetter;

        // Create temporary nodes for iteration, one for each word
        // Iterate through the letters of the given word

        while (currentG != null) {
            Letter letterG = currentG.getElement();
            // Get the letter from the current node of the given word

            if (currentM == null) {
                letterG.setUnused();
                break;
                // If there are no more letters in the mystery word or the letters don't match,
                // label the letter from the given word as unused
            } else if (currentM.getElement().equals(letterG)) {
                if (letterG.getLabel() != 2) {
                    letterG.setCorrect();
                }
            } else {
                boolean found = false;
                result = false;
                LinearNode<Letter> mysteryTemp = mystery.firstLetter;

                while (mysteryTemp != null) {
                    Letter mysteryTempLetter = mysteryTemp.getElement();
                    if (mysteryTempLetter.letter == letterG.letter) {
                        letterG.setUsed();
                        found = true;
                        break;
                    }

                    mysteryTemp = mysteryTemp.getNext();
                }

                if (!found) {
                    letterG.setUnused();
                }
            }
            currentM = currentM.getNext(); // Move to the next letter in the mystery word
            currentG = currentG.getNext(); // Move to the next letter in the given word
        }

        if (currentM != null) {
            result = false; // If there are remaining letters in the mystery word, set the result as false
        }

        return result; // Return the result of the labeling process
    }
}

