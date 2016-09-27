import java.util.Arrays;
import java.util.List;

/**
 * Assignment 3 (100 points)
 * Due: TODO
 *
 * Implement each of the following functions. Verify their correctness
 * using the tests in Assignment3Test.java.
 *
 * In addition to the bonus questions, extra credit is available by adding
 * tests: 1 point for each added test case up to 20 points.
 *
 * Please work with your assigned partner, but *do not* collaborate
 * with anyone else whatsoever. You will probably do better if you do not
 * split up the problems, but instead each do all of them and discuss.
 */
public class Assignment3 {

    /**
     * Problem 1 (10 points)
     *
     * Calculates the distance between the points (x1, y1) and (x2, y2).
     */
    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
        // Alternatively, Math.hypot(x1-x2, y1-y2);
    }

    /**
     * Problem 2 (10 points)
     *
     * Returns true if p is a factor of a.
     *
     * Examples:
     *   - if a = 12 and p = 3, returns true
     *   - if a = 12 and p = 5, returns false
     */
    public static boolean isFactor(int a, int p) {
        return a % p == 0;
    }

    /**
     * Problem 3 (10 points)
     *
     * Given a string, returns that string repeated eleven times.
     * (see https://www.youtube.com/watch?v=4xgx4k83zzc for more info)
     *
     * Example: turnUpTo11("a") == "aaaaaaaaaaa"
     */
    public static String turnUpTo11(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            builder.append(s);
        }
        return builder.toString();
    }

    /**
     * Problem 4 (10 points)
     *
     * Returns true if b is between a and b (inclusive) WITHOUT using if statements.
     *
     * Examples:
     * - isBetween(10, 10, 12) == true
     * - isBetween(5, 4, 7) == false
     */
    public static boolean isBetween(int a, int b, int c) {
        return a <= b && b <= c;
    }

    /**
     * Problem 5 (10 points)
     *
     * Count the number of 'z's in a String. Only count lowercase ones.
     *
     * Hints:
     * - use a loop
     * - strings start at index 0
     * - given a String s, s.substring(0, 1) returns the string at index 0.
     * - s.length() returns the length of the string
     *
     * Examples:
     * - countZs("zzz") == 3
     * - countZs("philz") == 1
     */
    public static int countZs(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.substring(i, i+1).equals("z")) {
                count++;
            }
        }
        return count;
    }

    /**
     * Problem 6 (10 points)
     *
     * Returns the thousandth digit in num. If there is no thousandth digit,
     * return 0.
     *
     * Example: getThousandthDigit(9876543) == 5
     */
    public static int getThousandthDigit(int num) {
        return (num % 10000) / 1000;
    }

    /**
     * Problem 7 (10 points)
     *
     * Returns the count of numbers that are evenly divisible by 7
     * in the range [lower, upper] (inclusive).
     *
     * Examples:
     * - countDivisibleBy7(7, 8) == 1
     * - countDivisibleBy7(6, 22) == 3
     */
    public static int countDivisibleBy7(int lower, int upper) {
        int count = 0;
        for (int i = lower; i <= upper; i++) {
            if (i % 7 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Problem 8 (10 points)
     *
     * Returns the SUM of numbers that are both evenly divisible by 7 and
     * evenly divisible by 4 in the range [lower, upper] (inclusive).
     *
     * Examples:
     * - sumDivisibleBy7and4(28, 28) == 28
     * - sumDivisibleBy7and4(28, 57) == 84 (28 plus 56)
     */
    public static long sumDivisibleBy7and4(long lower, long upper) {
        long sum = 0;
        for (long i = lower; i <= upper; i++) {
            if (i % 7 == 0 && i % 4 == 0) {
                sum += i;
            }
        }
        return sum;
    }


    /**
     * Problem 9 (20 points)
     *
     * Return a string with the numbers between [lower, upper] squashed together.
     * But for multiples of three use "Whiz" instead of the number and for
     * multiples of five use "Zap". For numbers which are multiples of both three
     * and five print "WhizZap".
     *
     * Don't print anything. Return the values concatenated together in a String.
     * 
     * Integer.toString(...) can be used to convert an int to a String.
     *
     * Examples:
     * - whizZap(1, 4) == "12Whiz4" (3 was replaced with Whiz)
     * - whizZap(1, 15) == "12Whiz4ZapWhiz78WhizZap11Whiz1314WhizZap"
     */
    public static String whizZap(int lower, int upper) {
        // I've used a StringBuilder here but you could add the Strings.
        //
        // Using a StringBuilder is slightly more efficient because when you
        // add Strings, a new copy of the String is created each time you add
        // and re-assign. This is because Strings are immutable.
        StringBuilder builder = new StringBuilder();
        for (int i = lower; i <= upper; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                builder.append("WhizZap");
            } else if (i % 3 == 0) {
                builder.append("Whiz");
            } else if (i % 5 == 0) {
                builder.append("Zap");
            } else {
                builder.append(Integer.toString(i));
            }
        }
        return builder.toString();
    }

    /**
     * Bonus A (10 points)
     *
     * Returns the nth digit in num. This is counting from the right, so 
     * n = 1 refers to the rightmost digit.
     *
     * Example: If num = 9876543 and n = 5, then output should be 7.
     */
    public static int getNthDigit(int num, int n) {
        // For the example, helper becomes 10**5 == 100000. It will
        // help us chop digits off of the front.
        //
        // 9876543 % 100000 == 76543, which we need the leading digit of.
        // Then 76543 / 10000 == 7
        //
        // Here we have to cast to int by writing (int)
        // This is because Math.round() returns a 'long', which is a
        // higher-precision integer than int. So we have to explicitly
        // tell the compiler "it's okay if we truncate some digits"
        int helper = (int) Math.round(Math.pow(10, n));
        return (num % helper) / (helper / 10);
    }

    /**
     * Bonus B (10 pts)
     *
     * Task: Convert the given time (which represents total minutes) into
     *       days/hours/minutes. Store your results in variables named days, hours,
     *       and minutes and return a list containing those values in that order
     *       (construction of the list is done for you).
     *  
     *   Example:
     *       If time = 15, then your result variables should be:
     *           days = 0, hours = 0, minutes = 15
     *       If time = 150, then your result variables should be:
     *           days = 0, hours = 2, minutes = 30
     *       If time = 1500, then your result variables should be:
     *           days = 1, hours = 1, minutes = 0
     */
    public static List<Integer> simplifyMinutes(int time_in_min) {
        int mins_in_hour = 60;
        int mins_in_day = mins_in_hour * 24;

        int days = time_in_min / mins_in_day;
        int hours = (time_in_min % mins_in_day) / mins_in_hour;
        int minutes = time_in_min % mins_in_hour;
        return Arrays.asList(days, hours, minutes);
    }
}
