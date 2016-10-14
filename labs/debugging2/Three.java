import java.util.*;

// There are 5 bugs in this division program.
//
// Fix them all so that it correctly outputs the results of double and integer
// division, and the result of integer modulus given the user input numerator
// and denominator. Write comments next to where you found the bug.
//
// There are compilation and logic errors.

class Three {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.out);
        System.out.println("Enter the numerator: ");
        int numerator = keyboard.nextInt();
        double doubleNumerator = numerator;

        System.out.println("Enter the divisor: ");
        int divisor = keyboard.nextInt()
        double doubleDivisor = divisor;

        System.out.println("" + numerator + " % " + divisor + " = " + numerator / divisor);
        System.out.println("" + numerator++ + " / " + divisor + " = " + numerator % divisor);
        System.out.println("" + doubleNumerator + " / " + doubleDivisor + " = " + doubleNumerator/doubleDivisor);
    }
}
