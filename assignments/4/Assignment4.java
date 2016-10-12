import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Assignment 4: ArrayLists (100 points)
 * Due: Monday, October 17 at 11:59 pm
 *
 * Implement each of the following functions. Verify their correctness
 * using the tests in Assignment4Test.java.
 *
 * In addition to the bonus questions, extra credit is available by adding
 * tests: 1 point for each added test case up to 20 points.
 *
 * Please work with your assigned partner, but *do not* collaborate
 * with anyone else whatsoever. You will probably do better if you do not
 * split up the problems, but instead each do all of them and discuss.
 */
public class Assignment4 {

    /**
     * Getting started
     * ---------------
     *
     * Say you had a problem like this:
     *

    public static ArrayList<Integer> getOneThruFive() {
        // TODO: implement this.
        return new ArrayList<Integer>();
    }

     *
     * The documentation above the function says "Returns an ArrayList
     * containing the numbers 1 through 5." To solve this problem, you would
     * write something like this:
     *

    public static ArrayList<Integer> getOneThruFive() {
        ArrayList<Integer> oneThruFive = new ArrayList<Integer>();
        oneThruFive.add(1);
        oneThruFive.add(2);
        oneThruFive.add(3);
        oneThruFive.add(4);
        oneThruFive.add(5);
        return oneThruFive;
    }

     *
     * After implementing the function, you would run the tests to make sure
     * the tests for this function pass. Run the tests by running the following
     * two commands on the command line:
     *
     * javac Assignment4.java Assignment4Test.java
     * java org.junit.runner.JUnitCore Assignment4Test
     *
     * If you're not using jUnit installed on your own computer, please see
     * these instructions for running jUnit in the lab:
     *      https://sheng.io/fisk/tips/junit_in_lab/
     */





    /**
     * Problem 1 (10 points)
     *
     * Returns an ArrayList containing the seventh element in nums. Does not
     * modify nums.
     *
     * For example, if nums is [1 2 3 4 5 6 7 8 9 10], then this function
     * should return [7].
     *
     * If nums is [3], this function should return [-1] since there is no
     * seventh element.
     */
    public static ArrayList<Integer> getSeventh(ArrayList<Integer> nums) {
        // TODO
        return new ArrayList<Integer>();
    }


    /**
     * Problem 2 (20 points)
     *
     * Returns an ArrayList containing every third element in nums. Does not
     * modify nums.
     *
     * For example, if nums is [1 2 3 4 5 6 7 8 9 10], then this function
     * should return [3 6 9].
     *
     * If nums is [1], this function should return [] since there are no
     * third elements.
     */
    public static ArrayList<Integer> getThirdElements(ArrayList<Integer> nums) {
        // TODO
        return new ArrayList<Integer>();
    }


    /**
     * Problem 3 (10 points)
     * 
     * Replaces each element in bools with false.
     *
     * Example:
     * If bools starts out as [true false true true], bools should contain
     * [false false false false] after calling this function with bools as a
     * parameter.
     */
    public static void makeAllFalse(ArrayList<Boolean> bools) {
        // TODO
    }


    /**
     * Problem 4 (10 points)
     * 
     * Returns the sum of every fourth element in doubles.
     *
     * For example, if doubles is [1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0], this
     * function should return 12.0.
     */
    public static double sumEveryFourth(ArrayList<Double> doubles) {
        // TODO
        return 0.0;
    }


    /**
     * Problem 5 (10 points)
     *
     * 'fortunes' contains a list of fortune cookie fortunes that will
     * be used by a cookie manufacturer. Play a prank on the manufacturer
     * by appending " in bed" to each fortune.
     *
     * For example, if fortunes is ["You will receive an unexpected windfall"],
     * your function should return ["You will receive an unexpected windfall in bed"].
     */
    public static void playPrank(ArrayList<String> fortunes) {
        // TODO
    }


    /**
     * Problem 6 (20 points)
     *
     * Returns true if every element in nums is greater than or equal to
     * a minimum value 'min'.
     *
     * For example, if nums is [5 6 7 8] and min is 6, then this function should
     * return false. If nums is [6 6 7 6] and min is 6, it should return true.
     *
     * If nums is empty this function should return true.
     */
    public static boolean allMeetMinimum(ArrayList<Long> nums, long min) {
        // TODO
        return false;
    }


    /**
     * Defines a cat. For problems 7 and 8.
     *
     * Example usage:
     *
     * Cat c = new Cat(true);
     * c.getIsCute();  // returns true since we instantiated a cute cat
     *
     * c.setIsCute(false);
     * c.getIsCute();  // returns false since we set the cute attribute to false
     */
    static class Cat {
        boolean isCute;

        public Cat(boolean isCute) {
            this.isCute = isCute;
        }

        public boolean getIsCute() {
            return isCute;
        }

        public void setIsCute(boolean isCute) {
            this.isCute = isCute;
        }
    }


    /**
     * Problem 7 (10 points)
     *
     * Counts the number of cute cats in 'cats'.
     */
    public static int countCuteCats(ArrayList<Cat> cats) {
        // TODO
        return 0;
    }


    /**
     * Problem 8 (10 points)
     *
     * Shave all of the cats in 'cats' (i.e. make them not cute). 
     */
    public static void shaveCats(ArrayList<Cat> cats) {
        // TODO
    }


    /**
     * Extra credit (20 points)
     *
     * Modifies the ArrayList by swapping the first and second, the third and fourth,
     * elements. If there's an odd number of elements, the final element should be
     * untouched.
     *
     * For example, if list is originally [1 2 3 4 5], after calling this function
     * list should be [2 1 4 3 5].
     */
    public static void swapEveryOther(ArrayList<Integer> list) {
        // TODO
    }


    /**
     * Extra credit (10 points)
     *
     * Returns the product of all of the elements in nums.
     */
    public static float getProduct(ArrayList<Float> nums) {
        // TODO
        return 0.0f;
    }


    /**
     * Extra credit (10 points)
     *
     * Returns an ArrayList containing the first n digits of the fibonacci sequence.
     */
    public static ArrayList<Long> getFibs(int n) {
        // TODO
        return new ArrayList<Long>();
    }


    /**
     * Extra credit (20 points)
     *
     * Returns an ArrayList containing n cats. Cats should be cute or non-cute in
     * alternating order.
     *
     * For example, if n is 5, this function should return an ArrayList of Cats:
     * [ CUTE_CAT  NON_CUTE_CAT  CUTE_CAT  NON_CUTE_CAT  CUTE_CAT ]
     */
    public static ArrayList<Cat> getAlternatingCatList(int n) {
        // TODO
        return new ArrayList<Cat>();
    }
}
