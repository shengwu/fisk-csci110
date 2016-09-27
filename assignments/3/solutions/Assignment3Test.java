import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

/**
 * Tests for the functions in Assignment3.java.
 *
 * Remember, extra test cases are 1 point extra each up to 20 points.
 */
public class Assignment3Test {
    private static final double EPS = 0.00000000000001;

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

    @Test
    public void testGetDistanceNegatives() {
        assertEquals(Assignment3.getDistance(0.0, -30.0, -40.0, 0.0),
                50.0, EPS);
    }

    @Test
    public void testGetDistanceMix() {
        assertEquals(Assignment3.getDistance(46.0, 30.0, -40.0, 10.0),
                88.29496021857646, EPS);
    }

    // tests for isFactor

    @Test
    public void testIsFactorSelf() {
        assertEquals(Assignment3.isFactor(727347, 727347), true);
    }

    @Test
    public void testIsFactorTwoAndTwenty() {
        assertEquals(Assignment3.isFactor(20, 2), true);
    }

    @Test
    public void testIsFactorTwentyNope() {
        assertEquals(Assignment3.isFactor(20, 7), false);
    }

    @Test
    public void testIsFactorThreeHundred() {
        assertEquals(Assignment3.isFactor(3000, 300), true);
    }

    @Test
    public void testIsFactorPerfectSquareNot() {
        assertEquals(Assignment3.isFactor(36, 7), false);
    }

    // tests for turnUpTo11

    @Test
    public void testTurnUpTo11Empty() {
        assertEquals(Assignment3.turnUpTo11(""), "");
    }

    @Test
    public void testTurnUpTo11One() {
        assertEquals(Assignment3.turnUpTo11("1"), "11111111111");
    }

    @Test
    public void testTurnUpTo11Woop() {
        assertEquals(Assignment3.turnUpTo11("Woop"),
                "WoopWoopWoopWoopWoopWoopWoopWoopWoopWoopWoop");
    }

    @Test
    public void testTurnUpTo11Hello() {
        assertEquals(Assignment3.turnUpTo11("hello"),
                "hellohellohellohellohellohellohellohellohellohellohello");
    }

    @Test
    public void testTurnUpTo11Goodbye() {
        assertEquals(Assignment3.turnUpTo11("goodbye"),
                "goodbyegoodbyegoodbyegoodbyegoodbyegoodbyegoodbyegoodbyegoodbyegoodbyegoodbye");
    }

    // tests for inBetween

    @Test
    public void testIsBetweenOnes() {
        assertEquals(Assignment3.isBetween(1, 1, 1), true);
    }

    @Test
    public void testIsBetweenNegatives() {
        assertEquals(Assignment3.isBetween(-20, -19, -18), true);
    }

    @Test
    public void testIsBetweenNegatives2() {
        assertEquals(Assignment3.isBetween(-400, -400, -400), true);
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

    @Test
    public void testCountZsAlt() {
        assertEquals(Assignment3.countZs("zazbzczdz"), 5);
    }

    @Test
    public void testCountZsLong() {
        assertEquals(Assignment3.countZs("ooasohhhoghioaffgsofogogoookkkkkkkzzzzaz"),
                5);
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
        assertEquals(Assignment3.getThousandthDigit(9098765), 8);
    }

    @Test
    public void testGetThousandthDigitTwo() {
        assertEquals(Assignment3.getThousandthDigit(11112111), 2);
    }

    @Test
    public void testGetThousandthDigitAlt() {
        assertEquals(Assignment3.getThousandthDigit(1010101010), 1);
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

    @Test
    public void testCountDivisibleBy7More2() {
        assertEquals(Assignment3.countDivisibleBy7(1, 49), 7);
    }

    @Test
    public void testCountDivisibleBy7More3() {
        assertEquals(Assignment3.countDivisibleBy7(5678, 234567), 32698);
    }

    // tests for sumDivisibleBy7and4

    @Test
    public void testSumDivisibleBy7and4Nothing() {
        assertEquals(Assignment3.sumDivisibleBy7and4(10, 20), 0);
    }

    @Test
    public void testSumDivisibleBy7and4OneNumber() {
        assertEquals(Assignment3.sumDivisibleBy7and4(28, 28), 28);
    }

    @Test
    public void testSumDivisibleBy7and4AFewNumbers() {
        assertEquals(Assignment3.sumDivisibleBy7and4(200, 4000), 283500);
    }

    @Test
    public void testSumDivisibleBy7and4MoreNumbers() {
        assertEquals(Assignment3.sumDivisibleBy7and4(5678, 234567), 981981000);
    }

    @Test
    public void testSumDivisibleBy7and4Again() {
        assertEquals(Assignment3.sumDivisibleBy7and4(1, 100), 168);
    }

    // tests for whizZap

    @Test
    public void testWhizZap0To1() {
        assertEquals("WhizZap1", Assignment3.whizZap(0, 1));
    }

    @Test
    public void testWhizZap1To3() {
        assertEquals("12Whiz", Assignment3.whizZap(1, 3));
    }

    @Test
    public void testWhizZap11to15() {
        assertEquals("11Whiz1314WhizZap", Assignment3.whizZap(11, 15));
    }

    @Test
    public void testWhizZap30To50() {
        assertEquals(
                "WhizZap3132Whiz34ZapWhiz3738WhizZap41Whiz4344WhizZap4647Whiz49Zap",
                Assignment3.whizZap(30, 50));
    }

    @Test
    public void testWhizZap50To100() {
        assertEquals(
                "ZapWhiz5253WhizZap56Whiz5859WhizZap6162Whiz64ZapWhiz6768WhizZap71Whiz7374WhizZap7677Whiz79ZapWhiz8283WhizZap86Whiz8889WhizZap9192Whiz94ZapWhiz9798WhizZap",
                Assignment3.whizZap(50, 100));
    }


    @Test
    public void testWhizZap1To15() {
        assertEquals("12Whiz4ZapWhiz78WhizZap11Whiz1314WhizZap",
                Assignment3.whizZap(1, 15));
    }

    @Test
    public void testWhizZap100to105() {
        assertEquals("Zap101Whiz103104WhizZap",
                Assignment3.whizZap(100, 105));
    }

    @Test
    public void testWhizZapNothing() {
        assertEquals("", Assignment3.whizZap(100, 99));
    }

    @Test
    public void testWhizZapSingle() {
        assertEquals("Whiz", Assignment3.whizZap(10677, 10677));
    }

    @Test
    public void testWhizZapSingleNotWord() {
        assertEquals("10678", Assignment3.whizZap(10678, 10678));
    }

    // Uncomment to test extra credit problems

    /*
    // getNthDigit

    @Test
    public void testGetNthDigitNotInRange() {
        assertEquals(0, Assignment3.getNthDigit(1000, 5));
    }

    @Test
    public void testGetNthDigitNine() {
        assertEquals(9, Assignment3.getNthDigit(9876543, 7));
    }

    @Test
    public void testGetNthDigitSix() {
        assertEquals(6, Assignment3.getNthDigit(9876543, 4));
    }

    @Test
    public void testGetNthDigitFour() {
        assertEquals(4, Assignment3.getNthDigit(9876543, 2));
    }

    @Test
    public void testGetNthDigitThree() {
        assertEquals(3, Assignment3.getNthDigit(9876543, 1));
    }



    // simplifyMinutes tests

    @Test
    public void testSimplifyMinutes4() {
        assertEquals(Arrays.asList(0, 0, 4), Assignment3.simplifyMinutes(4));
    }

    @Test
    public void testSimplifyMinutes45() {
        assertEquals(Arrays.asList(0, 0, 45), Assignment3.simplifyMinutes(45));
    }

    @Test
    public void testSimplifyMinutes450() {
        assertEquals(Arrays.asList(0, 7, 30), Assignment3.simplifyMinutes(450));
    }

    @Test
    public void testSimplifyMinutes4500() {
        assertEquals(Arrays.asList(3, 3, 0), Assignment3.simplifyMinutes(4500));
    }

    @Test
    public void testSimplifyMinutes45000() {
        assertEquals(Arrays.asList(31, 6, 0), Assignment3.simplifyMinutes(45000));
    }

    */
}
