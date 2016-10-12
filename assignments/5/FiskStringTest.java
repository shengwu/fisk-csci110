import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Tests for your implementation of FiskString.
 *
 * Remember, extra test cases are 1 point extra each up to 20 points.
 */
public class FiskStringTest {

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
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsBasicPunctuation() {
        FiskString a = new FiskString('*', '/', '%', '#', ')');
        FiskString b = new FiskString('*', '/', '%', '#', ')');
        assertTrue(a.equals(b));
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


    // write your own tests for the extra credit
}
