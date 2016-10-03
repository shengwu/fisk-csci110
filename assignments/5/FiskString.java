/**
 * Assignment 5: Arrays and Strings
 * Due: TODO
 *
 * Implement a FiskString class using an array of chars. FiskString
 * is a replica of Java's String class.
 *
 * Do not use Java's String class.
 */
public class FiskString {
    private char[] data;

    /**
     * Constructs a new FiskString from a char[].
     */
    public FiskString(char[] data) {
        this.data = data;
    }

    /**
     * EXAMPLE: Returns the length of this FiskString.
     *
     * This problem would have looked something like this:

    public int length() {
        // TODO
        return 0;
    }

     * The solution is below. 
     *
     * The length of the string is the length of the char[] named data, which
     * is what we use to store the information in this FiskString.
     */
    public int length() {
        return data.length;
    }

    /**
     * Returns the char in this FiskString at index i.
     *
     * Example: if you had a FiskString named s with the contents "hello",
     * calling s.charAt(1) would return 'e'.
     */
    public char charAt(int i) {
        // TODO
        return 'z';
    }

    /**
     * Returns true if this FiskString has the same
     * characters as the other FiskString.
     */
    public boolean equals(FiskString other) {
        // TODO
        return false;
    }
}
