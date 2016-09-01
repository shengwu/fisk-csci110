import java.util.Scanner;

public class Music {
    private static Scanner reader = new Scanner(System.in).useDelimiter(
            System.getProperty("line.separator"));

    public static void main(String[] args) {
        System.out.print("What's the name of your favorite genre? ");
        String genre = reader.next();

        // Music (part 1)
        //
        // TODO: Write a while loop to read in the names of songs
        // until the user has given 5 answers, or types "done". Print
        // "one of your favorite songs is ____" after each song.
        //
        // Use reader.next() to read in the name of a song. See above
        // or the assignment 2 pdf for examples.
        //
        // while (CONDITION) {
        //   CODE GOES HERE
        // }
    }
}
