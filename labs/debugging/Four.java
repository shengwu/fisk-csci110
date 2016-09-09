import java.util.Scanner;

public class Four {
    private static Scanner reader = new Scanner(System.in).useDelimiter(
            System.getProperty("line.separator"));

    public static void main(String[] args) {
        // This program asks the user for up to FOUR of their
        // favorite times of day. 
        //
        // At any time, the user can type BORED. Then the program
        // will stop asking and quit.
        //
        // But something's funky about this program.

        String time = new String("");
        String bored = new String("BORED");
        int num = 0;

        while (time != bored && num <= 4) {
            System.out.print("What's one of your favorite times of day? ");
            time = reader.next();

            System.out.println("One of your favorite times of day is " + time);
            num += 1;
        }
    }
}
