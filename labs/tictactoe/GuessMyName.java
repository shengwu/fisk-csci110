import java.util.Scanner;
public class GuessMyName {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Last name? ");
        String lastName = reader.next();
        System.out.print("First name? ");
        String firstName = reader.next();

        if (lastName.equals("ever") && firstName.equals("greatest")) {
            System.out.println("Your name is Drake!");
        } else if (firstName.equals("yeezy")) {
            System.out.println("Your name is Kanye!");
        } else if (lastName.equals("dogg") && firstName.equals("snoop")) {
            System.out.println("Your name is Cordozar Calvin Broadus, Jr.!");
        } else if (lastName.equals("chainz") && firstName.equals("2")) {
            System.out.println("Your name is Tauheed Epps!");
        } else if (lastName.equals("mane") && firstName.equals("gucci")) {
            System.out.println("Your name is Radric Delantic Davis!");
        } else if (lastName.equals("minaj") && firstName.equals("nicki")) {
            System.out.println("Your name is Onika Tanya Maraj!");
        } else {
            System.out.println("who dat");
        }


        System.out.println("thanks for playing");
    }
}
