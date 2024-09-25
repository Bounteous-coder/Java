// Numan Salahuddin - 251264939
/**
 * Represents a single letter.
 */
public class Letter {
    public char letter;  // Stores the character value of the letter
    private int label;    // Represents the label of the letter
    private static final int UNSET = 1;    // Letter is unset
    private static final int UNUSED = 2;   // Letter is unused
    private static final int USED = 3;     // Letter is used
    public static final int CORRECT = 4;   // Letter is correct

    /**
     * Constructs a Letter object with a character value.
     *
     * @param c The character value of the letter.
     */
    public Letter(char c) {
        label = UNSET;   // Setting the label of the letter as unset
        letter = c;      // Assigning the character value passed to the constructor
    }

    /**
     * Checks if the letter is unused.
     *
     * @return True if the letter is unused, false otherwise.
     */
    public boolean isUnused() {
        return label == UNUSED;
    }

    /**
     * Checks if the letter is equal to another object.
     *
     * @param otherObject The object to compare against.
     * @return True if the letter is equal to the other object, false otherwise.
     */
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {  // Check if the other object is an instance of the Letter class
            Letter otherLetter = (Letter) otherObject;
            return this.letter == otherLetter.letter;
        }
        return false;
    }

    /**
     * Returns a string decorator based on the label of the letter.
     *
     * @return The decorator string representing the label of the letter.
     */
    public String decorator() {
        // Returns a string decorator based on the label of the letter
        if (label == USED) {
            return "+";   // Used letter is represented by '+'
        } else if (label == UNUSED) {
            return "-";   // Unused letter is represented by '-'
        } else if (label == CORRECT) {
            return "!";   // Correct letter is represented by '!'
        } else {
            return " ";   // Unset letter or other cases are represented by a space in the decorator
        }
    }

    /**
     * Returns a string representation of the letter.
     *
     * @return The string representation of the letter.
     */
    public String toString() {
        String toPrint = this.decorator() + letter + this.decorator();  // Decorate the letter with its status
        return toPrint;
    }

    /**
     * Sets the label of the letter as unused.
     */
    public void setUnused() {
        label = UNUSED;   // Set the label of the letter as unused
    }

    /**
     * Sets the label of the letter as used.
     */
    public void setUsed() {
        label = USED;     // Set the label of the letter as used
    }

    /**
     * Sets the label of the letter as correct.
     */
    public void setCorrect() {
        label = CORRECT;  // Set the label of the letter as correct
    }

    /**
     * Returns the label of the letter.
     *
     * @return The label of the letter.
     */
    public int getLabel() {
        return label;     // Return the label of the letter
    }

    /**
     * Creates an array of Letter objects from a string.
     *
     * @param s The string to create the Letter objects from.
     * @return The array of Letter objects.
     */
    public static Letter[] fromString(String s) {
        Letter[] array = new Letter[s.length()];  // Creating an array to store Letter objects
        for (int i = 0; i < s.length(); i++) {
            array[i] = new Letter(s.charAt(i));   // Creating a Letter object for each character in the string
        }
        return array;
    }


}
