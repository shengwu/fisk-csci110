import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for the functions in Assignment3.java.
 *
 * Remember, extra test cases are 1 point extra each up to 20 points.
 */
public class Assignment3Test {
    private static final double EPS = 0.000000000000001;

    // Tests for getDistance

    @Test
    public void testGetDistanceNothing() {
        assertEquals(Assignment3.getDistance(0.0, 0.0, 0.0, 0.0),
                0.0,
                EPS);
    }

    @Test
    public void testGetDistanceRightTriangle() {
        assertEquals(Assignment3.getDistance(3.0, 0.0, 0.0, 4.0),
                5.0,
                EPS);
    }

    @Test
    public void testGetDistanceLine() {
        assertEquals(Assignment3.getDistance(0.0, 0.0, 10.0, 10.0),
                14.142135623730951, EPS);
    }

    // tests for isFactor

    @Test
    public void testIsFactorSelf() {
        assertEquals(Assignment3.isFactor(727347, 7273471), true);
    }

    @Test
    public void testIsFactorTwoAndTwenty() {
        assertEquals(Assignment3.isFactor(20, 2), true);
    }

    @Test
    public void testIsFactorTwentyNope() {
        assertEquals(Assignment3.isFactor(20, 7), false);
    }

    // tests for turnUpTo11

    @Test
    public void testTurnUpTo11Empty() {
        assertEquals(Assignment3.turnUpTo11(""), "");
    }

    @Test
    public void testTurnUpTo11Hello() {
        assertEquals(Assignment3.turnUpTo11("hello"),
                "hellohellohellohellohellohellohellohellohellohellohello");
    }

    // tests for inBetween

    @Test
    public void testIsBetweenOnes() {
        assertEquals(Assignment3.isBetween(1, 1, 1), true);
    }

    @Test
    public void testIsBetweenHundredsTrue() {
        assertEquals(Assignment3.isBetween(100, 200, 300), true);
    }

    @Test
    public void testIsBetweenHundredsFalse() {
        assertEquals(Assignment3.isBetween(100, 800, 500), false);
    }

    // tests for countZs

    @Test
    public void testCountZsNone() {
        assertEquals(Assignment3.countZs("apple"), 0);
    }

    @Test
    public void testCountZsOne() {
        assertEquals(Assignment3.countZs("Eazy-E"), 1);
    }

    @Test
    public void testCountZsLots() {
        assertEquals(Assignment3.countZs("bzzzzzbeez"), 6);
    }

    // tests for getThousandthDigit

    @Test
    public void testGetThousandthDigitNone() {
        assertEquals(Assignment3.getThousandthDigit(10), 0);
    }

    @Test
    public void testGetThousandthDigitOne() {
        assertEquals(Assignment3.getThousandthDigit(1000), 1);
    }

    @Test
    public void testGetThousandthDigitBig() {
        assertEquals(Assignment3.getThousandthDigit(9098765), 7);
    }

    // tests for countDivisibleBy7

    @Test
    public void testCountDivisibleBy7None() {
        assertEquals(Assignment3.countDivisibleBy7(10, 11), 0);
    }

    @Test
    public void testCountDivisibleBy7One() {
        assertEquals(Assignment3.countDivisibleBy7(10, 20), 1);
    }

    @Test
    public void testCountDivisibleBy7More() {
        assertEquals(Assignment3.countDivisibleBy7(77, 154), 12);
    }

    // tests for sumDivisibleBy7and4

    @Test
    public void testSumDivisibleBy7and4OneNumber() {
        assertEquals(Assignment3.sumDivisibleBy7and4(28, 28), 28);
    }

    @Test
    public void testSumDivisibleBy7and4AFewNumbers() {
        assertEquals(Assignment3.sumDivisibleBy7and4(200, 4000), 283500);
    }

    // tests for whizZap

    @Test
    public void testWhizZap1To3() {
        assertEquals(Assignment3.whizZap(1, 3), "123");
    }

    @Test
    public void testWhizZap1To15() {
        assertEquals(Assignment3.whizZap(1, 15),
                "12Whiz4ZapWhiz78WhizZap11Whiz1314WhizZap");
    }

    @Test
    public void testWhizZap100to105() {
        assertEquals(Assignment3.whizZap(100, 105),
                "Zap101Whiz103104WhizZap");
    }

    // write your own tests for the extra credit
}
