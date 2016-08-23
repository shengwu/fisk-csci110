// TODO: write your name
import java.util.Scanner;
public class Hypotenuse {
    public static double calculateHypotenuse(float sideA, float sideB) {
        // TODO: write your code here
        return 0;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print(
                "Enter the length of one of the shorter sides of a right triangle: ");
        float a = reader.nextFloat();
        System.out.print(
                "Enter the length of the other shorter side of a right triangle: ");
        float b = reader.nextFloat();
        System.out.println("The hypotenuse: " + calculateHypotenuse(a, b));
    }
}
