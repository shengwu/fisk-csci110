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




    // sample tests for length()

    /*

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

    */




    // charAt()

    @Test
    public void testCharAtEmpty() {
        FiskString s = new FiskString();
        try {
            s.charAt(10);
        } catch (ArrayIndexOutOfBoundsException e) {
            // we expect this exception; test passed
            return;
        }
        // if we reach here, the test failed
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
    public void testCharAtBasicOutOfBounds() {
        FiskString s = new FiskString('a', 'b', 'c');
        try {
            s.charAt(10);
        } catch (ArrayIndexOutOfBoundsException e) {
            // we expect this exception; test passed
            return;
        }
        // if we reach here, the test failed
        assertFalse(true);
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
    public void testCharAtEndsWithSpaces() {
        FiskString s = new FiskString('o', 'k', ' ', ' ', ' ');
        assertEquals('o', s.charAt(0));
        assertEquals('k', s.charAt(1));
        assertEquals(' ', s.charAt(2));
        assertEquals(' ', s.charAt(3));
        assertEquals(' ', s.charAt(4));
    }

    @Test
    public void testCharAtEndsWithSpacesOutOfBounds() {
        FiskString s = new FiskString('o', 'k', ' ', ' ', ' ');
        try {
            s.charAt(100);
        } catch (ArrayIndexOutOfBoundsException e) {
            // we expect this exception; test passed
            return;
        }
        // if we reach here, the test failed
        assertFalse(true);
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





    // setChar() method

    @Test
    public void testSetCharEmpty() {
        FiskString s = new FiskString();
        // setChar should return false if it was not possible to set the char
        // at the specified position
        assertFalse(s.setChar(0, 'z'));
    }

    @Test
    public void testSetCharOutOfBounds() {
        FiskString s = new FiskString('h', 'e' ,'l', 'l', 'o');
        assertFalse(s.setChar(5, 'z'));
        assertFalse(s.setChar(200, 'z'));
    }

    @Test
    public void testSetCharOutOfBoundsNegative() {
        FiskString s = new FiskString('h', 'e' ,'l', 'l', 'o');
        assertFalse(s.setChar(-2, 'B'));
        assertFalse(s.setChar(-10, 'B'));
    }

    @Test
    public void testSetCharBasic() {
        FiskString s = new FiskString('h', 'e' ,'l', 'l', 'o');
        assertTrue(s.setChar(0, 'H'));
        assertTrue(s.equals(new FiskString('H', 'e', 'l', 'l', 'o')));
        assertFalse(s.equals(new FiskString('h', 'e', 'l', 'l', 'o')));
    }

    @Test
    public void testSetCharBasic2() {
        FiskString s = new FiskString('z', 'o', 'i', 'n', 'k', 's');
        assertTrue(s.setChar(1, '0'));
        assertTrue(s.setChar(2, '1'));
        assertTrue(s.equals(new FiskString('z', '0', '1', 'n', 'k', 's')));
        assertFalse(s.equals(new FiskString('z', 'o', 'i', 'n', 'k', 's')));
    }

    @Test
    public void testSetCharRepeated() {
        FiskString s = new FiskString('h', 'e' ,'l', 'l', 'o');

        assertTrue(s.setChar(0, 'H'));
        assertTrue(s.equals(new FiskString('H', 'e', 'l', 'l', 'o')));
        assertFalse(s.equals(new FiskString('h', 'e', 'l', 'l', 'o')));

        assertTrue(s.setChar(0, 'h'));
        assertFalse(s.equals(new FiskString('H', 'e', 'l', 'l', 'o')));
        assertTrue(s.equals(new FiskString('h', 'e', 'l', 'l', 'o')));

        assertTrue(s.setChar(0, 'H'));
        assertTrue(s.equals(new FiskString('H', 'e', 'l', 'l', 'o')));
        assertFalse(s.equals(new FiskString('h', 'e', 'l', 'l', 'o')));
    }






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




    // tests for getCopy() extra credit method
    // uncomment to run

    /*

    @Test
    public void testGetCopyEmpty() {
        FiskString testString = new FiskString();
        FiskString copy = testString.getCopy();
        assertTrue(testString.equals(copy));
    }

    @Test
    public void testGetCopySameContents() {
        FiskString testString = new FiskString('m', 'n', 'o', 'p', 'q', 'r', 's');
        FiskString copy = testString.getCopy();
        assertTrue(testString.equals(copy));
    }

    @Test
    public void testGetCopyChangingOriginalDoesntAffectCopy() {
        FiskString testString = new FiskString('m', 'n', 'o', 'p', 'q', 'r', 's');
        FiskString savedOriginal = new FiskString('m', 'n', 'o', 'p', 'q', 'r', 's');
        FiskString copy = testString.getCopy();

        // change testString
        testString.setChar(3, 'z');
        testString.setChar(4, '%');

        assertTrue(savedOriginal.equals(copy));
        assertFalse(savedOriginal.equals(testString));
    }

    @Test
    public void testGetCopyChangingCopyDoesntAffectOriginal() {
        FiskString testString = new FiskString('m', 'n', 'o', 'p', 'q', 'r', 's');
        FiskString savedOriginal = new FiskString('m', 'n', 'o', 'p', 'q', 'r', 's');
        FiskString copy = testString.getCopy();

        // change the copy
        copy.setChar(1, '*');
        copy.setChar(5, '^');

        assertFalse(savedOriginal.equals(copy));
        assertTrue(savedOriginal.equals(testString));
    }

    */


}
