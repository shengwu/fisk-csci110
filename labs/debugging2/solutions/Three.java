import java.util.*;

// There are 5 bugs in this Division program. 
//
// Fix them all so that it correctly outputs the results of double and integer
// division, and the result of integer modulus given the user input numerator
// and denominator.
//
// There are compilation and logic errors.

class Three {
    public static void main(String[] args) {
        // System.out should be System.in
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the numerator: ");
        int numerator = keyboard.nextInt();
        double doubleNumerator = numerator;

        System.out.println("Enter the divisor: ");
        // missing semicolon
        int divisor = keyboard.nextInt();
        double doubleDivisor = divisor;

        // This prints the result of numerator / divisor. It should be
        // numerator % divisor to match the label.
        System.out.println("" + numerator + " % " + divisor + " = " + numerator % divisor);
        // This prints the result of numerator % divisor. It should be
        // numerator / divisor to match the label.
        //
        // Also, there's an extra ++ after numerator which increments the value.
        System.out.println("" + numerator + " / " + divisor + " = " + numerator / divisor);
        System.out.println("" + doubleNumerator + " / " + doubleDivisor + " = " + doubleNumerator/doubleDivisor);
    }
}
