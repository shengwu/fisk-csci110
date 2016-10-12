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

    // getThirdElements

    @Test
    public void testGetThirdElementsEmpty() {
        ArrayList<Integer> empty = new ArrayList<Integer>();
        ArrayList<Integer> empty2 = new ArrayList<Integer>();
        assertEquals(empty2, Assignment4.getThirdElements(empty));
    }

    @Test
    public void testGetThirdElementsTwo() {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(52);
        testArray.add(163);
        ArrayList<Integer> empty = new ArrayList<Integer>();
        assertEquals(empty, Assignment4.getThirdElements(testArray));
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
    public void testGetThirdElementsBasicNegative() {
        ArrayList<Integer> basic = new ArrayList<Integer>();
        for (int i = -10; i <= 10; i++) {
            basic.add(i);
        }
        assertEquals(Arrays.asList(-8, -5, -2, 1, 4, 7, 10),
                     Assignment4.getThirdElements(basic));
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

    // write your own tests for the extra credit
}
