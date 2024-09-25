// Numan salahuddin - 251264939
/**
 * Represents an extended letter.
 */
public class ExtendedLetter extends Letter {
    private String content;            // Stores the content of the extended letter
    private int family;                // Represents the family/group identifier of the extended letter
    private boolean related;           // Indicates if the extended letter is related to other letters
    private static final int SINGLETON = -1;  // Constant representing a singleton family

    /**
     * Constructs an ExtendedLetter object with content only.
     *
     * @param s The content of the extended letter.
     */
    public ExtendedLetter(String s) {
        super(' ');                // Call the superclass constructor with a space character
        content = s;               // Assign the content passed to the constructor
        family = SINGLETON;        // Set the family as a singleton by default
        related = false;           // Set the related flag as false by default
    }

    /**
     * Constructs an ExtendedLetter object with content and family identifier.
     *
     * @param s   The content of the extended letter.
     * @param fam The family identifier of the extended letter.
     */
    public ExtendedLetter(String s, int fam) {
        super(' ');                // Call the superclass constructor with a space character
        content = s;               // Assign the content passed to the constructor
        family = fam;              // Assign the family identifier passed to the constructor
        related = false;           // Set the related flag as false by default
    }

    /**
     * Checks if two ExtendedLetter objects are equal.
     *
     * @param other The object to compare against.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object other) {
        if (!(other instanceof ExtendedLetter))
            return false;

        ExtendedLetter otherLetter = (ExtendedLetter) other;

        if (otherLetter.family == this.family) {
            this.related = true;   // If the families are equal, set the related flag as true
        }

        return this.content.equals(otherLetter.content);  // Check if the content of the extended letters is equal
    }

    /**
     * Returns a string representation of the extended letter.
     *
     * @return The string representation of the extended letter.
     */
    @Override
    public String toString() {
        if (this.isUnused() && related) {
            return "." + content + ".";     // Decorate the content with dots if unused and related
        } else {
            return super.decorator() + content + super.decorator();  // Decorate the content with its label/status
        }
    }

    /**
     * Creates an array of ExtendedLetter objects from given content and family identifiers.
     *
     * @param content The array of content for the ExtendedLetter objects.
     * @param codes   The array of family identifiers for the ExtendedLetter objects.
     * @return The array of ExtendedLetter objects.
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        if (codes == null) {
            for (int i = 0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i]);  // Create ExtendedLetter objects with content only
            }
        } else {
            for (int i = 0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);  // Create ExtendedLetter objects with content and family identifier
            }
        }
        return letters;  // Return the array of ExtendedLetter objects
    }
}