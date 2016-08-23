import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HypotenuseTest {
    private static final double DELTA = 1e-15;

    @Test
    public void solvesCommonTriangle1() {
        // 3-4-5 triangle
        double result = Hypotenuse.calculateHypotenuse(3, 4);
        assertEquals(5.0, result, DELTA);
    }

    @Test
    public void solvesCommonTriangle2() {
        // 5-12-13 triangle
        double result = Hypotenuse.calculateHypotenuse(5, 12);
        assertEquals(13.0, result, DELTA);
    }

    @Test
    public void solvesCommonTriangle3() {
        // 1-1-sqrt(2) triangle
        double result = Hypotenuse.calculateHypotenuse(1, 1);
        assertEquals(Math.sqrt(2), result, DELTA);
    }

    // Add additional test cases here!
}
