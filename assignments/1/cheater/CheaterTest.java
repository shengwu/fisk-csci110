import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CheaterTest {
    @Test
    public void testEquilateral() {
        int result = Cheater.getTriangleType(5, 5, 5);
        assertEquals(2, result);
    }

    @Test
    public void testEquilateral2() {
        int result = Cheater.getTriangleType(778, 778, 778);
        assertEquals(2, result);
    }

    @Test
    public void testIsosceles() {
        int result = Cheater.getTriangleType(5, 5, 10);
        assertEquals(1, result);
    }

    @Test
    public void testIsosceles2() {
        int result = Cheater.getTriangleType(4, 1, 4);
        assertEquals(1, result);
    }

    @Test
    public void testNeither() {
        int result = Cheater.getTriangleType(1, 2, 3);
        assertEquals(0, result);
    }

    // Add additional test cases here!
}
