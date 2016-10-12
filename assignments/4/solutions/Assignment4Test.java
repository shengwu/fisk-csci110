import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;

/**
 * Tests for the functions in Assignment4.java.
 *
 * How to read these tests:
 * ------------------------
 * When there's a line like:
 *      assertEquals(Arrays.asList(7), Assignment4.getSeventh(basic));
 * the first value is what we want your code to produce. The call to
 * Arrays.asList(7) is a shortcut to create an ArrayList<Integer> with
 * one element, the integer 7. The second part,
 * Assignment4.getSeventh(basic), calls the getSeventh() method and
 * runs the code you've written.
 *
 * Remember, extra test cases are 1 point extra each up to 20 points.
 */
public class Assignment4Test {
    private static final double EPS = 0.000000000000001;
    private static final Random random = new Random();

    @Test
    public void testGetSeventhEmpty() {
        ArrayList<Integer> empty = new ArrayList<Integer>();
        assertEquals(Arrays.asList(-1), Assignment4.getSeventh(empty));
    }

    @Test
    public void testGetSeventhBasic() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            basic.add(i);
        }
        assertEquals(Arrays.asList(7), Assignment4.getSeventh(basic));
    }

    @Test
    public void testGetSeventhBasic2() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        basic.add(8);
        basic.add(3);
        basic.add(5);
        basic.add(6);
        basic.add(1);
        basic.add(8);
        basic.add(0);
        basic.add(5);
        assertEquals(Arrays.asList(0), Assignment4.getSeventh(basic));
    }

    @Test
    public void testGetSeventhLarge() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = 555; i < 2000; i++) {
            basic.add(i);
        }
        assertEquals(Arrays.asList(561), Assignment4.getSeventh(basic));
    }

    @Test
    public void testGetSeventhLarge2() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = 135233; i < 135687; i++) {
            basic.add(i);
        }
        assertEquals(Arrays.asList(135239), Assignment4.getSeventh(basic));
    }


    // getThirdElements

    @Test
    public void testGetThirdElementsEmpty() {
        ArrayList<Integer> empty = new ArrayList<Integer>();
        assertEquals(Arrays.asList(), Assignment4.getThirdElements(empty));
    }

    @Test
    public void testGetThirdElementsBasic() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            basic.add(i);
        }
        assertEquals(Arrays.asList(3, 6, 9), Assignment4.getThirdElements(basic));
    }

    @Test
    public void testGetThirdElementsBasic2() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = 50; i <= 70; i++) {
            basic.add(i);
        }
        assertEquals(Arrays.asList(52, 55, 58, 61, 64, 67, 70),
                     Assignment4.getThirdElements(basic));
    }

    @Test
    public void testGetThirdElementsLong() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = 1; i < 200; i++) {
            basic.add(i);
        }
        ArrayList<Integer> expected = new ArrayList<Integer>();
        for (int i = 3; i < 200; i += 3) {
            expected.add(i);
        }
        assertEquals(expected, Assignment4.getThirdElements(basic));
    }

    @Test
    public void testGetThirdElementsLong2() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = 57786; i < 90000; i++) {
            basic.add(i);
        }
        ArrayList<Integer> expected = new ArrayList<Integer>();
        for (int i = 57788; i < 90000; i += 3) {
            expected.add(i);
        }
        assertEquals(expected, Assignment4.getThirdElements(basic));
    }

    // makeAllFalse

    @Test
    public void testMakeAllFalseEmpty() {
        ArrayList<Boolean> testArray = new ArrayList<Boolean>();
        Assignment4.makeAllFalse(testArray);

        ArrayList<Boolean> expected = new ArrayList<Boolean>();
        assertEquals(expected, testArray);
    }

    @Test
    public void testMakeAllFalseTwo() {
        ArrayList<Boolean> testArray = new ArrayList<Boolean>();
        testArray.add(true);
        testArray.add(false);
        Assignment4.makeAllFalse(testArray);

        ArrayList<Boolean> expected = new ArrayList<Boolean>();
        expected.add(false);
        expected.add(false);
        assertEquals(expected, testArray);
    }

    @Test
    public void testMakeAllFalseAlreadyFalse() {
        ArrayList<Boolean> testArray = new ArrayList<Boolean>();
        testArray.add(false);
        testArray.add(false);
        testArray.add(false);
        testArray.add(false);
        testArray.add(false);
        Assignment4.makeAllFalse(testArray);

        ArrayList<Boolean> expected = new ArrayList<Boolean>();
        expected.add(false);
        expected.add(false);
        expected.add(false);
        expected.add(false);
        expected.add(false);
        assertEquals(expected, testArray);
    }

    @Test
    public void testMakeAllFalseRandom() {
        ArrayList<Boolean> testArray = new ArrayList<Boolean>();
        for (int i = 0; i < 10; i++) {
            testArray.add(random.nextDouble() > 0.5);
        }
        Assignment4.makeAllFalse(testArray);

        ArrayList<Boolean> expected = new ArrayList<Boolean>();
        for (int i = 0; i < 10; i++) {
            expected.add(false);
        }
        assertEquals(expected, testArray);
    }

    @Test
    public void testMakeAllFalseLargeRandom() {
        ArrayList<Boolean> testArray = new ArrayList<Boolean>();
        for (int i = 0; i < 1000; i++) {
            testArray.add(random.nextDouble() > 0.5);
        }
        Assignment4.makeAllFalse(testArray);

        ArrayList<Boolean> expected = new ArrayList<Boolean>();
        for (int i = 0; i < 1000; i++) {
            expected.add(false);
        }
        assertEquals(expected, testArray);
    }

    // sumEveryFourth

    @Test
    public void testSumEveryFourthEmpty() {
        assertEquals(0.0, Assignment4.sumEveryFourth(new ArrayList<Double>()), EPS);
    }

    @Test
    public void testSumEveryFourthLessThanFour() {
        ArrayList<Double> testArray = new ArrayList<Double>();
        testArray.add(5.0);
        testArray.add(10.0);
        testArray.add(15.0);
        assertEquals(0.0, Assignment4.sumEveryFourth(testArray), EPS);
    }

    @Test
    public void testSumEveryFourthSingle() {
        ArrayList<Double> testArray = new ArrayList<Double>();
        testArray.add(5.0);
        testArray.add(10.0);
        testArray.add(15.0);
        testArray.add(25.0);
        assertEquals(25.0, Assignment4.sumEveryFourth(testArray), EPS);
    }

    @Test
    public void testSumEveryFourthBasic() {
        ArrayList<Double> testArray = new ArrayList<Double>();
        for (double d = 1.0; d <= (10.0 + EPS); d += 1.0) {
            testArray.add(d);
        }
        assertEquals(12.0, Assignment4.sumEveryFourth(testArray), EPS);
    }

    @Test
    public void testSumEveryFourthLarge() {
        ArrayList<Double> testArray = new ArrayList<Double>();
        for (double d = 3456.0; d <= (6677.0 + EPS); d += 1.0) {
            testArray.add(d);
        }
        assertEquals(4078935.0, Assignment4.sumEveryFourth(testArray), EPS);
    }

    // playPrank

    @Test
    public void testPlayPrankEmpty() {
        ArrayList<String> testArray = new ArrayList<String>();
        Assignment4.playPrank(testArray);

        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, testArray);
    }

    @Test
    public void testPlayPrankSingle() {
        ArrayList<String> testArray = new ArrayList<String>();
        testArray.add("You will do the bernie");
        Assignment4.playPrank(testArray);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("You will do the bernie in bed");
        assertEquals(expected, testArray);
    }

    @Test
    public void testPlayPrankBasic() {
        ArrayList<String> testArray = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            testArray.add("fortune" + i);
        }
        Assignment4.playPrank(testArray);

        ArrayList<String> expected = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            expected.add("fortune" + i + " in bed");
        }
        assertEquals(expected, testArray);
    }

    @Test
    public void testPlayPrankLarge() {
        ArrayList<String> testArray = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            testArray.add("random_fortune 123 qwer " + i);
        }
        Assignment4.playPrank(testArray);

        ArrayList<String> expected = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            expected.add("random_fortune 123 qwer " + i + " in bed");
        }
        assertEquals(expected, testArray);
    }

    @Test
    public void testPlayPrankCaseSensitive() {
        ArrayList<String> testArray = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            testArray.add("AdFsRetNz9532j%@#%" + i);
        }
        Assignment4.playPrank(testArray);

        ArrayList<String> expected = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            expected.add("AdFsRetNz9532j%@#%" + i + " in bed");
        }
        assertEquals(expected, testArray);
    }


    // allMeetMinimum

    @Test
    public void testAllMeetMinimumEmpty() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        assertEquals(true,
                     Assignment4.allMeetMinimum(testArray, 10000));
    }

    @Test
    public void testAllMeetMinimumSingle() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        testArray.add(50000l);
        assertEquals(true,
                     Assignment4.allMeetMinimum(testArray, 50000l));
    }

    @Test
    public void testAllMeetMinimumSingleFalse() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        testArray.add(50000l);
        assertEquals(false,
                     Assignment4.allMeetMinimum(testArray, 50009));
    }

    @Test
    public void testAllMeetMinimumBasicFalse() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        for (long i = 0; i < 10; i++) {
            testArray.add(i);
        }
        assertEquals(false, Assignment4.allMeetMinimum(testArray, 5));
    }

    @Test
    public void testAllMeetMinimumBasicTrue() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        for (long i = 15; i < 25; i++) {
            testArray.add(i);
        }
        assertEquals(true, Assignment4.allMeetMinimum(testArray, 15));
    }

    @Test
    public void testAllMeetMinimumBasicLargeFalse() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        for (long i = 638454; i < 700000; i++) {
            testArray.add(i);
        }
        assertEquals(false, Assignment4.allMeetMinimum(testArray, 690000));
    }

    @Test
    public void testAllMeetMinimumNegative() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        for (long i = -3000; i < -2500; i++) {
            testArray.add(i);
        }
        assertEquals(true, Assignment4.allMeetMinimum(testArray, -3000));
    }

    @Test
    public void testAllMeetMinimumNegativeFalse() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        for (long i = -80420; i < -80000; i++) {
            testArray.add(i);
        }
        assertEquals(false, Assignment4.allMeetMinimum(testArray, -80200));
    }

    @Test
    public void testAllMeetMinimumNegativeLarge() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        for (long i = -30000; i < -2500; i++) {
            testArray.add(i);
        }
        assertEquals(true, Assignment4.allMeetMinimum(testArray, -30000));
    }

    @Test
    public void testAllMeetMinimumNegativeLargeFalse() {
        ArrayList<Long> testArray = new ArrayList<Long>();
        for (long i = -80420; i < -60000; i++) {
            testArray.add(i);
        }
        assertEquals(false, Assignment4.allMeetMinimum(testArray, -70200));
    }

    // countCuteCats

    @Test
    public void testCountCuteCatsNoCats() {
        assertEquals(0, Assignment4.countCuteCats(new ArrayList<Assignment4.Cat>()));
    }

    @Test
    public void testCountCuteCatsOneCatNotCute() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        cats.add(new Assignment4.Cat(false));
        assertEquals(0, Assignment4.countCuteCats(cats));
    }

    @Test
    public void testCountCuteCatsTwoCatsBothCute() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        cats.add(new Assignment4.Cat(true));
        cats.add(new Assignment4.Cat(true));
        assertEquals(2, Assignment4.countCuteCats(cats));
    }

    @Test
    public void testCountCuteCatsTwoCatsBasic() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        cats.add(new Assignment4.Cat(true));
        cats.add(new Assignment4.Cat(false));
        cats.add(new Assignment4.Cat(true));
        cats.add(new Assignment4.Cat(false));
        cats.add(new Assignment4.Cat(false));
        cats.add(new Assignment4.Cat(false));
        cats.add(new Assignment4.Cat(true));
        cats.add(new Assignment4.Cat(true));
        cats.add(new Assignment4.Cat(false));
        cats.add(new Assignment4.Cat(true));
        assertEquals(5, Assignment4.countCuteCats(cats));
    }

    @Test
    public void testCountCuteCatsTwoCatsLarge() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        for (int i = 0; i < 50; i++) {
            cats.add(new Assignment4.Cat(false));
        }
        for (int i = 0; i < 40; i++) {
            cats.add(new Assignment4.Cat(true));
        }
        for (int i = 0; i < 30; i++) {
            cats.add(new Assignment4.Cat(false));
        }
        for (int i = 0; i < 40; i++) {
            cats.add(new Assignment4.Cat(true));
        }
        assertEquals(80, Assignment4.countCuteCats(cats));
    }

    // shaveCats

    @Test
    public void testShaveCatsOne() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        cats.add(new Assignment4.Cat(true));
        Assignment4.shaveCats(cats);

        // Look at the single cat in 'cats' to make sure it's no longer cute
        assertEquals(1, cats.size());
        assertEquals(false, cats.get(0).getIsCute());
    }

    @Test
    public void testShaveCatsFew() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        cats.add(new Assignment4.Cat(true));
        cats.add(new Assignment4.Cat(false));
        cats.add(new Assignment4.Cat(true));
        Assignment4.shaveCats(cats);

        assertEquals(3, cats.size());
        assertEquals(false, cats.get(0).getIsCute());
        assertEquals(false, cats.get(1).getIsCute());
        assertEquals(false, cats.get(2).getIsCute());
    }

    @Test
    public void testShaveCatsTen() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        for (int i = 0; i < 10; i++) {
            cats.add(new Assignment4.Cat(true));
        }
        Assignment4.shaveCats(cats);

        // Look at all of the cats in 'cats' to make sure they're no longer cute
        assertEquals(10, cats.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(false, cats.get(i).getIsCute());
        }
    }

    @Test
    public void testShaveCatsTenRandom() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        for (int i = 0; i < 10; i++) {
            cats.add(new Assignment4.Cat(random.nextDouble() > 0.5));
        }
        Assignment4.shaveCats(cats);

        // Look at all of the cats in 'cats' to make sure they're no longer cute
        assertEquals(10, cats.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(false, cats.get(i).getIsCute());
        }
    }

    @Test
    public void testShaveCatsManyRandom() {
        ArrayList<Assignment4.Cat> cats = new ArrayList<Assignment4.Cat>();
        for (int i = 0; i < 10000; i++) {
            cats.add(new Assignment4.Cat(random.nextDouble() > 0.5));
        }
        Assignment4.shaveCats(cats);

        // Look at all of the cats in 'cats' to make sure they're no longer cute
        assertEquals(10000, cats.size());
        for (int i = 0; i < 10000; i++) {
            assertEquals(false, cats.get(i).getIsCute());
        }
    }

    // write your own tests for the extra credit
}
