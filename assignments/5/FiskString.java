/**
 * Assignment 5: Arrays and Strings
 * Due: Sunday, October 30 at 11:59 pm
 *
 * In this assignment, you'll write a version of Java's built-in String class.
 * Remember how with String objects, you can do things like this:
 *
 * String s = "hello";
 * boolean b = s.equals("goodbye");   // false
 * boolean b2 = s.contains("llo");    // true
 *
 * Now it's your job to implement these methods inside a class called
 * FiskString. Some of the setup has already been done for you. There's a
 * private member variable called "data" that is an array of char. The
 * constructor and the length() method have already been written.
 *
 * You cannot use any of the methods in the actual String class, ArrayList
 * class, Arrays class, or any other built-in libraries that help you
 * manipulate Strings or arrays.
 *
 * ---
 *
 * When you're done, the tests in FiskStringTest.java will make sure your code
 * works as expected. As before, compile and test like this:
 *
 *   javac FiskString.java FiskStringTest.java
 *   java org.junit.runner.JUnitCore FiskStringTest
 *
 * Or if you're doing this in the lab, see the instructions here:
 * https://sheng.io/fisk/tips/junit_in_lab/
 */
public class FiskString {
    // Holds the characters in this FiskString.
    private char[] data;

    /**
     * Constructs a new FiskString from a sequence of chars.
     *
     * Example usage:
     *
     * FiskString fs = new FiskString('h', 'e', 'l', 'l', 'o');
     *
     * // OR
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
     * EXAMPLE/TUTORIAL
     *
     * Returns the length of this FiskString.
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
        // TODO
        return 'z';
    }



    /**
     * Problem 2: 20 points
     *
     * Sets a character at a given index.
     *
     * Returns true if we were able to successfully set the char. Returns
     * false if the operation failed (i.e. the index was out of bounds).
     */
    public boolean setChar(int i, char c) {
        // TODO
        return false;
    }



    /**
     * Problem 3: 20 points
     *
     * Returns true if this FiskString has the same characters as the other
     * FiskString.
     */
    public boolean equals(FiskString other) {
        // TODO
        return false;
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
        // TODO
        return false;
    }



    /**
     * Problem 5: 20 points
     *
     * Changes this FiskString to have all uppercase letters.
     *
     * For example, if this FiskString contains "hElLo", after calling
     * this function this FiskString should contain "HELLO".
     *
     * HINT: Look at the numbers corresponding to lowercase letters
     * vs uppercase letters in an ASCII table
     * e.g. http://web.cs.mun.ca/~michael/c/ascii-table.html
     */
    public void makeUpperCase() {
        // TODO
    }



    /**
     * EXTRA CREDIT: 20 points
     *
     * Returns a copy of this FiskString. This means that changing a character
     * in the original FiskString should not change the contents of the copy.
     */
    public FiskString getCopy() {
        // TODO
        return new FiskString();
    }
}
