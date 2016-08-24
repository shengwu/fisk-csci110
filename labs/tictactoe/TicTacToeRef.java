import java.util.Scanner;

// Scroll to the bottom to see the part you need to change.
public class TicTacToeRef {
    private static final Scanner reader =
        new Scanner(System.in).useDelimiter("\n");

    /**
     * Reads in a character from the user. Aborts the program if the input is
     * longer than a single character. If the input is empty, returns a space.
     */
    public static String getSingleCharOrSpace() {
        String s = reader.next();
        if (s.length() > 1) {
            System.out.println("Error: Expected a single character");
            System.exit(0);
        }
        if (s.isEmpty()) {
            return " ";
        }
        return s;
    }

    public static void main(String[] args) {
        // Read in the board
        // (don't change this part)
        System.out.print("top row, left: ");
        String topRowLeft = getSingleCharOrSpace();
        System.out.print("top row, middle: ");
        String topRowMiddle = getSingleCharOrSpace();
        System.out.print("top row, right: ");
        String topRowRight = getSingleCharOrSpace();
        System.out.print("middle row, left: ");
        String middleRowLeft = getSingleCharOrSpace();
        System.out.print("middle row, middle: ");
        String middleRowMiddle = getSingleCharOrSpace();
        System.out.print("middle row, right: ");
        String middleRowRight = getSingleCharOrSpace();
        System.out.print("bottom row, left: ");
        String bottomRowLeft = getSingleCharOrSpace();
        System.out.print("bottom row, bottom: ");
        String bottomRowMiddle = getSingleCharOrSpace();
        System.out.print("bottom row, right: ");
        String bottomRowRight = getSingleCharOrSpace();

        // Print the board
        // (don't change this part)
        System.out.println("\nThe board:");
        System.out.println(topRowLeft + " | " + topRowMiddle + " | " + topRowRight);
        System.out.println("---------");
        System.out.println(middleRowLeft + " | " + middleRowMiddle + " | " + middleRowRight);
        System.out.println("---------");
        System.out.println(bottomRowLeft + " | " + bottomRowMiddle + " | " + bottomRowRight);

        System.out.println("\nThe winner:");
        // TODO: write code to print the winner if there is one,
        // or print "there is no winner"
        //
        // hint: use the variables topRowLeft, etc with if statements
    }
}
