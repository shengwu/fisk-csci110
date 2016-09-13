import java.util.Scanner;

public class Food2 {
    private static Scanner reader = new Scanner(System.in).useDelimiter(
            System.getProperty("line.separator"));

    public static void main(String[] args) {
        System.out.println("What are at least four of your favorite foods?");

        String food = "";
        int num_foods = 0;
        int min_foods = 4;
        boolean tried_to_leave = false;

        while (!(food.equals("done") && num_foods >= min_foods) &&
               !(tried_to_leave && num_foods >= min_foods)) {
            System.out.print("Give me the name of a food: ");
            food = reader.next();
            if (food.equals("done")) {
                tried_to_leave = true;
            } else {
                num_foods += 1;
                System.out.println("One of your favorite foods is " + food);
                // Now get up to three recommendations
                int num_recs = 0;
                String recommendation = "";
                while (num_recs < 3 && !recommendation.equals("done")) {
                    System.out.print("What's a good place to get " + food + "? ");
                    recommendation = reader.next();
                    num_recs += 1;
                }
            }
        }
    }
}
