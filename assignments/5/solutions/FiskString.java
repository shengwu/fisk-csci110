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
        return data[i];
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
        if (i < 0 || i >= length()) {
            // index was out of bounds
            return false;
        }
        data[i] = c;
        return true;
    }



    /**
     * Problem 3: 20 points
     *
     * Returns true if this FiskString has the same characters as the other
     * FiskString.
     */
    public boolean equals(FiskString other) {
        // Two FiskStrings cannot be equal if they have different lengths.
        //
        // This also lets us avoid dealing with uneven FiskStrings in the loop
        // below.
        if (this.length() != other.length()) {
            return false;
        }

        // Compare this FiskString to the other character-by-character. As soon
        // as we find a pair that are different, we know the FiskStrings are not
        // equal.
        for (int i = 0; i < length(); i++) {
            if (this.charAt(i) != other.charAt(i)) {
                return false;
            }
        }
        return true;

        // Alternatively, you could solve this with:
        //   return this.startsWith(other) && other.startsWith(this);
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
            // If the other FiskString is longer, then it's impossible for this
            // FiskString to start with it.
            return false;
        }
        // Go along "other" and make sure that each of the characters are in
        // the beginning of this FiskString.
        for (int i = 0; i < other.length(); i++) {
            if (this.charAt(i) != other.charAt(i)) {
                return false;
            }
        }
        return true;
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

    // Here are a couple of constants so that we don't have "magic numbers"
    // i.e. numbers that don't mean anything to people reading the code.
    private static final char lowercaseA = 97;
    private static final char lowercaseZ = 122;

    public void makeUpperCase() {
        for (int i = 0; i < data.length; i++) {
            // If you look at the ASCII table, 'a' is represented by 97 and 'z'
            // is represented by 122. And 'A' is represented by 65 and 'Z' is
            // represented by 90. This is no accident: A is 32 less than a, B
            // is 32 less than b, etc.
            //
            // To convert all letters to uppercase, we iterate along the
            // characters in 'data'. If the character is a lowercase letter,
            // then we subtract 32 to turn the character into an uppercase
            // character.
            if (data[i] >= lowercaseA && data[i] <= lowercaseZ) {
                data[i] -= 32;
            }
        }
    }



    /**
     * EXTRA CREDIT: 20 points
     *
     * Returns a copy of this FiskString. This means that changing a character
     * in the original FiskString should not change the contents of the copy.
     */
    public FiskString getCopy() {
        // One errorneus implementation would be:
        //
        //   return new FiskString(this.data);
        //
        // This creates a new FiskString that's the same, but the new FiskString
        // also points to the data inside this FiskString. This means if we alter
        // the new FiskString, it also changes this FiskString.
        //
        // To avoid this, we create a new data array of the same size and copy
        // the old one into it character-by-character.
        char[] copy = new char[this.length()];
        for (int i = 0; i < this.length(); i++) {
            copy[i] = data[i];
        }
        return new FiskString(copy);
    }
}
