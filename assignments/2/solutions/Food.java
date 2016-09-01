import java.util.Scanner;

public class Food {
    private static Scanner reader = new Scanner(System.in).useDelimiter(
            System.getProperty("line.separator"));

    public static void main(String[] args) {
        System.out.println("What are at least four of your favorite foods?");

        String food = "";
        int num_foods = 0;
        int min_foods = 4;
        boolean tried_to_leave = false;
        // You can think about this like "under what conditions can I quit?"
        // Then put the opposite of those conditions AND-ed together
        // in the condition for the while loop to continue.
        //
        // Conditions where we stop:
        // - if the user types done and we're over the minimum number of foods
        // - if the user tried to quit earlier and we're over the minimum
        //   number of foods
        //
        // You could refactor this to simplify it if you wanted.
        while (!(food.equals("done") && num_foods >= min_foods) &&
               !(tried_to_leave && num_foods >= min_foods)) {
            System.out.print("Give me the name of a food: ");
            food = reader.next();
            if (food.equals("done")) {
                tried_to_leave = true;
            } else {
                num_foods += 1;
                System.out.println("One of your favorite foods is " + food);
            }
        }
    }
}
