import java.util.Scanner;

public class Greeter {
    /**
     * year1, month1, day1 is person1's birthday
     * year2, month2, day2 is person2's birthday
     *
     * Returns:
     *   -1 if person1 is older
     *   1 if person2 is older
     *   0 if both people are the same age
     * 
     * Don't change the method parameters or the tests won't work.
     */
    public static int whoIsOlder(int year1, int month1, int day1,
            int year2, int month2, int day2) {
        // TODO: delete this comment and write your code here
        //
        // Right now this is incorrect since it always says that person1 and
        // person2 are the same age
        return 0;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in).useDelimiter(
                System.getProperty("line.separator"));

        // This part asks the user for his/her name and birthday, and a friend's
        // name and birthday. Then it calls whoIsOlder to determine who is older.
        //
        // You don't need to change anything here.
        System.out.print("Enter your name: ");
        String myName = reader.next();
        System.out.print("What year were you born? ");
        int myYear = reader.nextInt();
        System.out.print("What month were you born? ");
        int myMonth = reader.nextInt();
        System.out.print("What day were you born? ");
        int myDay = reader.nextInt();

        System.out.print("Enter another person's name: ");
        String otherName = reader.next();
        System.out.print("What year was he/she born? ");
        int otherYear = reader.nextInt();
        System.out.print("What month was he/she born? ");
        int otherMonth = reader.nextInt();
        System.out.print("What day was he/she born? ");
        int otherDay = reader.nextInt();

        System.out.println("---");
        int result = whoIsOlder(myYear, myMonth, myDay,
                otherYear, otherMonth, otherDay);
        if (result == -1) {
            System.out.println("Congratulations " + myName + ", you're older!");
        } else if (result == 1) {
            System.out.println("Great job " + otherName + ", you're older!");
        } else {
            System.out.println(myName + " and " + otherName + " are the same age!");
        }
    }
}
