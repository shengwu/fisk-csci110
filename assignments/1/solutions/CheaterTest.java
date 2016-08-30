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
    public void testIsosceles3() {
        int result = Cheater.getTriangleType(1, 200, 200);
        assertEquals(1, result);
    }

    @Test
    public void testIsosceles4() {
        int result = Cheater.getTriangleType(2, 2, 90);
        assertEquals(1, result);
    }

    @Test
    public void testIsosceles5() {
        int result = Cheater.getTriangleType(5886, 20, 5886);
        assertEquals(1, result);
    }

    @Test
    public void testIsosceles6() {
        int result = Cheater.getTriangleType(100512, 100513, 100513);
        assertEquals(1, result);
    }

    @Test
    public void testNeither() {
        int result = Cheater.getTriangleType(1, 2, 3);
        assertEquals(0, result);
    }

    @Test
    public void testNeither2() {
        int result = Cheater.getTriangleType(355, 899234, 1990);
        assertEquals(0, result);
    }
}
