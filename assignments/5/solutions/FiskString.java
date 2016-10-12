/**
 * Assignment 5: Arrays and Strings
 * Due: TODO
 *
 * Your job is to create a version of Java's built-in String class using an
 * array of chars. This means you cannot use any of the methods in the actual
 * String class, ArrayList class, or any built-in libraries that help you
 * manipulate Strings or arrays.
 *
 *
 * When you're done, the tests in FiskStringTest.java will make sure your code
 * works as expected.
 *
 * Two methods have already been written:
 * - the constructor
 * - the length() method
 */
public class FiskString {
    // Holds the characters in this FiskString.
    private char[] data;

    /**
     * Constructs a new FiskString from a sequence of chars.
     *
     * Example use:
     *
     * FiskString fs = new FiskString('h', 'e', 'l', 'l', 'o');
     *
     * OR
     *
     * char[] chars = new char[3];
     * chars[0] = 'a';
     * chars[1] = 'b';
     * chars[2] = 'c';
     * FiskString fs = new FiskString(chars);
     */
    public FiskString(char... chars) {
        this.data = chars;
    }


    /**
     * EXAMPLE/TUTORIAL: Returns the length of this FiskString.
     *
     * This problem would have looked something like this:

    public int length() {
        // TODO
        return 0;
    }

     * What is this question asking? Well, the documentation says "returns
     * the length of this FiskString." That means we have to tell the caller
     * how many characters are contained in this FiskString.
     *
     * Where do we store the characters in this FiskString? In the char[]
     * named "data". How do we get the number of elements in "data"? With
     * the length attribute.
     */
    public int length() {
        return data.length;
    }


    /**
     * Problem 1: 20 points
     *
     * Returns the char in this FiskString at index i.
     *
     * Example: if you had a FiskString named s with the contents "hello",
     * calling s.charAt(1) would return 'e'.
     */
    public char charAt(int i) {
        return data[i];
    }



    /**
     * Problem 2: 20 points
     *
     * Returns true if this FiskString has the same characters as the other
     * FiskString.
     */
    public boolean equals(FiskString other) {
        if (this.length() != other.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (this.charAt(i) != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }



    /**
     * Problem 3: 20 points
     *
     * Sets a character at a certain position.
     *
     * Returns true if we were able to successfully set the char. Returns
     * false if the operation failed (i.e. the index was out of bounds).
     */
    public boolean setChar(int i, char c) {
        if (i < 0 || i >= length()) {
            return false;
        }
        data[i] = c;
        return true;
    }


    /**
     * Problem 4: 20 points
     *
     * Returns true if this FiskString starts with the characters in another
     * FiskString.
     *
     * Examples:
     *
     * FiskString a = new FiskString('g', 'r', 'e', 'e', 't', 'i', 'n', 'g', 's');
     * FiskString b = new FiskString('g', 'r', 'e', 'e', 't');
     * a.startsWith(b);  // returns true
     *
     * FiskString a = new FiskString('g', 'r', 'e', 'e', 't');
     * FiskString b = new FiskString('g', 'r', 'e', 'e', 't');
     * a.startsWith(b);  // returns true
     *
     * FiskString a = new FiskString('g', 'r', 'e', 'e', 't', 'i', 'n', 'g', 's');
     * FiskString b = new FiskString('t', 'i', 'n', 'g', 's');
     * a.startsWith(b);  // returns false
     *
     * FiskString a = new FiskString('g', 'r', 'e', 'e', 't', 'i', 'n', 'g', 's');
     * FiskString b = new FiskString('h', 'e', 'l', 'l', 'o');
     * a.startsWith(b);  // returns false
     */
    public boolean startsWith(FiskString other) {
        if (other.length() > this.length()) {
            // If the other FiskString is longer, then it's impossible
            // for this FiskString to start with it.
            return false;
        }
        for (int i = 0; i < other.length(); i++) {
            if (this.charAt(i) != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }



    /**
     * Problem 5: 20 points
     * TODO
     */



    /**
     * EXTRA CREDIT: 20 points
     *
     * Returns a copy of this FiskString. This means that changing a character
     * in the original FiskString should not change the contents of the copy.
     */
    public FiskString getCopy() {
        char[] copy = new char[this.length()];
        for (int i = 0; i < this.length(); i++) {
            copy[i] = data[i];
        }
        return new FiskString(copy);
    }
}
