
/**
 * The following class contains several compilation errors. Please
 * fix them and describe the errors in comments near where you
 * found the errors.
 */
public class One {

    // parameters should be of type double
    static void printIfGreater(double i, double limit) {
        if (i > limit) {
            System.out.println(i + " is greater than " + limit);
        }
    }

    public static void main(String[] args) {
        double[] nums = {5.6, 1.0, 8.8, 2.5, 2.0, 10.432, 12.4, 98.2, 1.2, 91.2};

        // the first part needs the 'int' keyword to complete the variable declaration
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.pow(nums[i], 2);
        }

        // math.sqrt only takes one parameter; removed the second
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.sqrt(nums[i]);
        }

        // should be j = 0, not j < 0 in first part
        for (int j = 0; j < nums.length; j++) {
            if (j < 4) {
                nums[j] -= 1.0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 5) {
                // wrong variable: j instead of i
                nums[i] += 2.0;
            }
        }

        // multiply, divide shorthand should put the symbol before the
        // assignment operator
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= 2;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 2;
        }

        for (int i = 1; i < nums.length; i++) {
            printIfGreater(nums[i], nums[i-1]);
        }

    }
}
