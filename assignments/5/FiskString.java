/**
 * Assignment 5: Arrays and Strings
 * Due: TODO
 *
 * Your job is to recreate Java's built-in String class using
 * an array of char. This means you cannot use any of the methods
 * in the actual String class or the related TODO libraries.
 *
 * When you're done, the tests in FiskStringTest.java will
 * make sure your code works as expected.
 *
 * Please write the following methods:
 * - 
 *
 * Two methods have already been written:
 * - the constructor
 * - the length() method
 */
public class FiskString {
    private char[] data;

    /**
     * Constructs a new FiskString from a sequence of chars.
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
     * Returns the char in this FiskString at index i.
     *
     * Example: if you had a FiskString named s with the contents "hello",
     * calling s.charAt(1) would return 'e'.
     */
    public char charAt(int i) {
        // TODO
        return 'Z';
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
