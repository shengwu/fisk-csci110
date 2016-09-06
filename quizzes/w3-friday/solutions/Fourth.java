import java.util.Scanner;

public class Fourth {
    private static Scanner reader = new Scanner(System.in);

    /**
     * Asks the user for a number with the given message.
     */
    static int printAndAsk(String message) {
        System.out.print(message);
        return reader.nextInt();
    }

    /**
     * Returns the result of "base" raised to the "power" power.
     */
    static int exponent(int base, int power) {
        if (power == 0) {
            return 1;
        }
        int result = base;
        int curr = 1;
        while (curr < power) {
            result *= base;
            curr += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int myBase = printAndAsk("Enter the base: ");
        int myPower = printAndAsk("Enter the power: ");
        int result = exponent(myBase, myPower);
        System.out.println("Here's the value of " + myBase +
                " raised to the " + myPower + " power: " + result);
    }
}
