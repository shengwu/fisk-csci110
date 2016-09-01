import java.util.Scanner;

public class Music {
    private static Scanner reader = new Scanner(System.in).useDelimiter(
            System.getProperty("line.separator"));

    public static void main(String[] args) {
        System.out.print("What's the name of your favorite genre? ");
        String genre = reader.next();

        int num_answers = 0;
        String song = "";
        while (num_answers < 5 && !song.equals("done")) {
            System.out.print("What's one of your favorite songs? ");
            song = reader.next();
            // Don't print this out of the user just typed "done"
            if (!song.equals("done")) {
                System.out.println("One of your favorite " + genre +
                        " songs is " + song);
                num_answers++;
            }
        }
    }
}
