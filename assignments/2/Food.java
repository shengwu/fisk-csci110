import java.util.Scanner;

public class Food {
    private static Scanner reader = new Scanner(System.in).useDelimiter(
            System.getProperty("line.separator"));

    public static void main(String[] args) {
        System.out.println("What are at least four of your favorite foods?");

        // Food (part 2)
        //
        // TODO: Write a while loop to read in the names of foods
        // until the user types "done". However, if the user hadn't yet
        // typed in four foods, keep asking the user for foods until
        // you have the names of four foods. (hint: think about what
        // condition would enforce both of these things) Print out
        // "One of your favorite foods is ______" after each input.
        //
        // Use reader.next() to read in the name of a food. See Music.java
        // or the assignment 2 pdf for examples.
    }
}
