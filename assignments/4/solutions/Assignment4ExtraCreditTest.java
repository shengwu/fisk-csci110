package assignment4;

import static assignment4.Assignment4.Cat;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;

/**
 * Tests for the extra credit functions in Assignment4.java.
 */
public class Assignment4ExtraCreditTest {
    private static final double EPS = 0.000000000000001;
    private static final Random random = new Random();


    // getProduct

    @Test
    public void testGetProductEmpty() {
        assertEquals(1.0, Assignment4.getProduct(new ArrayList<Float>()), EPS);
    }

    @Test
    public void testGetProductSingle() {
        ArrayList<Float> testList = new ArrayList<Float>();
        testList.add(5.0f);
        assertEquals(5.0f, Assignment4.getProduct(testList), EPS);
    }

    @Test
    public void testGetProductBasic() {
        ArrayList<Float> testList = new ArrayList<Float>();
        testList.add(2.0f);
        testList.add(4.0f);
        testList.add(6.0f);
        assertEquals(48.0f, Assignment4.getProduct(testList), EPS);
    }

    @Test
    public void testGetProductRange() {
        ArrayList<Float> testList = new ArrayList<Float>();
        for (float f = 1.0f; f < (10.0f + EPS); f++) {
            testList.add(f);
        }
        assertEquals(3628800.0f, Assignment4.getProduct(testList), EPS);
    }

    @Test
    public void testGetProductNegatives() {
        ArrayList<Float> testList = new ArrayList<Float>();
        testList.add(-2.0f);
        testList.add(2.0f);
        testList.add(-2.0f);
        testList.add(2.0f);
        testList.add(-2.0f);
        assertEquals(-32.0f, Assignment4.getProduct(testList), EPS);
    }

    // getFibs

    @Test
    public void testGetFibsNone() {
        assertEquals(Arrays.asList(), Assignment4.getFibs(0));
    }

    @Test
    public void testGetFibsFirstTwo() {
        assertEquals(Arrays.asList(1, 1), Assignment4.getFibs(2));
    }

    @Test
    public void testGetFibsFirstTen() {
        assertEquals(Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55),
                     Assignment4.getFibs(10));
    }

    @Test
    public void testGetFibsNoneNegative() {
        assertEquals(Arrays.asList(), Assignment4.getFibs(-20000));
    }

    @Test
    public void testGetFibsMany() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        int prev = 0;
        int curr = 1;
        for (int i = 0; i < 500; i++) {
            expected.add(curr);
            int tmp = curr;
            curr += prev;
            prev = tmp;
        }
        assertEquals(expected, Assignment4.getFibs(500));
    }

    // getAlternatingCatList

    @Test
    public void testGetAlternatingCatListNone() {
        assertEquals(new ArrayList<Cat>(), Assignment4.getAlternatingCatList(0));
    }

    @Test
    public void testGetAlternatingCatListFirstIsCute() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(1);
        assertEquals(1, result.size());
        assertEquals(true, result.get(0).getIsCute());
    }

    @Test
    public void testGetAlternatingCatListTwo() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(2);
        assertEquals(2, result.size());
        assertEquals(true, result.get(0).getIsCute());
        assertEquals(false, result.get(1).getIsCute());
    }

    @Test
    public void testGetAlternatingCatListThree() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(3);
        assertEquals(3, result.size());
        assertEquals(true, result.get(0).getIsCute());
        assertEquals(false, result.get(1).getIsCute());
        assertEquals(true, result.get(2).getIsCute());
    }

    @Test
    public void testGetAlternatingCatListSeven() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(7);
        assertEquals(7, result.size());
        assertEquals(true, result.get(0).getIsCute());
        assertEquals(false, result.get(1).getIsCute());
        assertEquals(true, result.get(2).getIsCute());
        assertEquals(false, result.get(3).getIsCute());
        assertEquals(true, result.get(4).getIsCute());
        assertEquals(false, result.get(5).getIsCute());
        assertEquals(true, result.get(6).getIsCute());
    }

    @Test
    public void testGetAlternatingCatListBasic() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(10);
        assertEquals(10, result.size());

        boolean curr = true;
        for (int i = 0; i < 10; i++) {
            assertEquals(curr, result.get(i).getIsCute());
            curr = !curr;
        }
    }

    @Test
    public void testGetAlternatingCatListLots() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(1000);
        assertEquals(1000, result.size());

        boolean curr = true;
        for (int i = 0; i < 1000; i++) {
            assertEquals(curr, result.get(i).getIsCute());
            curr = !curr;
        }
    }

    @Test
    public void testGetAlternatingCatListManyAndOdd() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(20109);
        assertEquals(20109, result.size());

        boolean curr = true;
        for (int i = 0; i < 20109; i++) {
            assertEquals(curr, result.get(i).getIsCute());
            curr = !curr;
        }
    }

    @Test
    public void testGetAlternatingCatLucky() {
        ArrayList<Cat> result = Assignment4.getAlternatingCatList(777);
        assertEquals(777, result.size());

        boolean curr = true;
        for (int i = 0; i < 777; i++) {
            assertEquals(curr, result.get(i).getIsCute());
            curr = !curr;
        }
    }

    @Test
    public void testGetAlternatingCatListNegative() {
        assertEquals(new ArrayList<Cat>(), Assignment4.getAlternatingCatList(-500));
    }
}
