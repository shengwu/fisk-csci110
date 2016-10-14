import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Random;
import org.junit.Test;

/**
 * Tests for your implementation of FiskString.
 *
 * Remember, extra test cases are 1 point extra each up to 20 points.
 */
public class FiskStringTest {
    private static final Random random = new Random();

    // length() method

    @Test
    public void testLengthEmpty() {
        FiskString s = new FiskString();
        assertEquals(0, s.length());
    }

    @Test
    public void testLengthBasic() {
        FiskString s = new FiskString('a', 'b', 'c');
        assertEquals(3, s.length());
    }

    // charAt() method

    @Test
    public void testCharAtEmpty() {
        FiskString s = new FiskString();
        try {
            s.charAt(10);
        } catch (RuntimeException e) {
            // TODO fix exception type
            // test passed
            return;
        }
        assertFalse(true);
    }

    @Test
    public void testCharAtBasic() {
        FiskString s = new FiskString('a', 'b', 'c');
        assertEquals('a', s.charAt(0));
        assertEquals('b', s.charAt(1));
        assertEquals('c', s.charAt(2));
    }

    @Test
    public void testCharAtStartsWithSpaces() {
        FiskString s = new FiskString(' ', ' ', ' ', 'o', 'k');
        assertEquals(' ', s.charAt(0));
        assertEquals(' ', s.charAt(1));
        assertEquals(' ', s.charAt(2));
        assertEquals('o', s.charAt(3));
        assertEquals('k', s.charAt(4));
    }

    @Test
    public void testCharAtPunctuation() {
        FiskString s = new FiskString('&', '!', '@', '>');
        assertEquals('&', s.charAt(0));
        assertEquals('!', s.charAt(1));
        assertEquals('@', s.charAt(2));
        assertEquals('>', s.charAt(3));
    }

    // equals() method

    @Test
    public void testEqualsEmpty() {
        FiskString a = new FiskString();
        FiskString b = new FiskString();
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsOneEmpty() {
        FiskString a = new FiskString();
        FiskString b = new FiskString('h', 'e', 'l', 'l', 'o');
        assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsOtherEmpty() {
        FiskString a = new FiskString('h', 'e', 'l', 'l', 'o');
        FiskString b = new FiskString();
        assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsBasic() {
        FiskString a = new FiskString('h', 'e', 'l', 'l', 'o');
        FiskString b = new FiskString('h', 'e', 'l', 'l', 'o');
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsBasicFalse() {
        FiskString a = new FiskString('h', 'e', 'l', 'l', 'o');
        FiskString b = new FiskString('h', 'o', 'l', 'a');
        assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsBasicPunctuation() {
        FiskString a = new FiskString('*', '/', '%', '#', ')');
        FiskString b = new FiskString('*', '/', '%', '#', ')');
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsBasicPunctuationFalse() {
        FiskString a = new FiskString('*', '/', '%', '#', ' ');
        FiskString b = new FiskString('*', '/', '^', '#', '*');
        assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsWithSpace() {
        FiskString a = new FiskString('h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd');
        FiskString b = new FiskString('h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd');
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsWithSpaceFalse() {
        FiskString a = new FiskString('h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd');
        FiskString b = new FiskString('f', 'o', 'o', ' ', 'b', 'a', 'r');
        assertFalse(a.equals(b));
    }

    // setChar() method
    // TODO


    // startsWith() method

    @Test
    public void testStartsWithEmpty() {
        FiskString a = new FiskString();
        FiskString b = new FiskString();
        // startsWith should return true because technically every FiskString
        // starts with an empty FiskString
        assertTrue(a.startsWith(b));
    }

    @Test
    public void testStartsWithFirstEmpty() {
        FiskString a = new FiskString();
        FiskString b = new FiskString('h', 'e', 'l', 'l', 'o');
        assertFalse(a.startsWith(b));
    }

    @Test
    public void testStartsWithOtherEmpty() {
        FiskString a = new FiskString('h', 'e', 'l', 'l', 'o');
        FiskString b = new FiskString();
        assertTrue(a.startsWith(b));
    }

    @Test
    public void testStartsWithBasic() {
        FiskString a = new FiskString('g', 'r', 'e' ,'e', 't', 'i', 'n', 'g', 's');
        FiskString b = new FiskString('g', 'r', 'e', 'e', 't');
        assertTrue(a.startsWith(b));
    }

    @Test
    public void testStartsWithBasicFalse() {
        FiskString a = new FiskString('g', 'r', 'e' ,'e', 't', 'i', 'n', 'g', 's');
        FiskString b = new FiskString('h', 'e', 'l', 'l', 'o');
        assertFalse(a.startsWith(b));
    }

    @Test
    public void testStartsWithBasicNotAtBeginning() {
        FiskString a = new FiskString('g', 'r', 'e', 'e', 't', 'i', 'n', 'g', 's');
        FiskString b = new FiskString('t', 'i', 'n', 'g', 's');
        assertFalse(a.startsWith(b));
    }

    @Test
    public void testStartsWithRandom() {
        char[] first = new char[10];
        for (int i = 0; i < 10; i++) {
            first[i] = (char) random.nextInt(256);
        }
        // Copy the first half into another char[]
        char[] second = new char[5];
        for (int i = 0; i < 5; i++) {
            second[i] = first[i];
        }
        FiskString a = new FiskString(first);
        FiskString b = new FiskString(second);
        assertTrue(a.startsWith(b));
    }

    @Test
    public void testStartsWithRandomFalse() {
        char[] first = new char[10];
        for (int i = 0; i < 10; i++) {
            first[i] = (char) random.nextInt(256);
        }
        char[] second = new char[5];
        for (int i = 0; i < 5; i++) {
            // put in some values that we know are different
            second[i] = (char) ((int) first[i] +  1);
        }
        FiskString a = new FiskString(first);
        FiskString b = new FiskString(second);
        assertFalse(a.startsWith(b));
    }

    @Test
    public void testStartsWithRandomLong() {
        char[] first = new char[500];
        for (int i = 0; i < 500; i++) {
            first[i] =  (char) random.nextInt(256);
        }
        char[] second = new char[50];
        for (int i = 0; i < 50; i++) {
            second[i] = first[i];
        }
        FiskString a = new FiskString(first);
        FiskString b = new FiskString(second);
        assertTrue(a.startsWith(b));
    }

    @Test
    public void testStartsWithRandomLongFalse() {
        char[] first = new char[500];
        for (int i = 0; i < 500; i++) {
            first[i] = (char) random.nextInt(256);
        }
        char[] second = new char[50];
        for (int i = 0; i < 50; i++) {
            second[i] = (char) ((int) first[i] +  1);
        }
        FiskString a = new FiskString(first);
        FiskString b = new FiskString(second);
        assertFalse(a.startsWith(b));
    }


    // makeUpperCase method

    @Test
    public void testMakeUpperCaseEmpty() {
        FiskString testString = new FiskString();
        testString.makeUpperCase();

        FiskString expected = new FiskString();
        assertTrue(expected.equals(testString));
    }

    @Test
    public void testMakeUpperCaseBasic() {
        FiskString testString = new FiskString('h', 'e', 'l', 'l', 'o');
        testString.makeUpperCase();

        FiskString expected = new FiskString('H', 'E', 'L', 'L', 'O');
        assertTrue(expected.equals(testString));
    }

    @Test
    public void testMakeUpperCaseMixedCase() {
        FiskString testString = new FiskString('h', 'E', 'l', 'L', 'O');
        testString.makeUpperCase();

        FiskString expected = new FiskString('H', 'E', 'L', 'L', 'O');
        assertTrue(expected.equals(testString));
    }

    @Test
    public void testMakeUpperCaseNumbersOk() {
        FiskString testString = new FiskString('4', '3', 'l', 'L', '0');
        testString.makeUpperCase();

        FiskString expected = new FiskString('4', '3', 'L', 'L', '0');
        assertTrue(expected.equals(testString));
    }

    @Test
    public void testMakeUpperCasePunctuationOk() {
        FiskString testString = new FiskString('&', '#', 'l', 'L', '@', '!');
        testString.makeUpperCase();

        FiskString expected = new FiskString('&', '#', 'L', 'L', '@', '!');
        assertTrue(expected.equals(testString));
    }



    // getCopy() extra credit method
    // TODO

    @Test
    public void testGetCopySameContents() {
    }


    // write your own tests for the extra credit
}
