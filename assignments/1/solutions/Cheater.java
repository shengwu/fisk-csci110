import java.util.Scanner;

public class Cheater {
    /**
     * Returns:
     *   2 if the triangle is equilateral
     *   1 if the triangle is isosceles
     *   0 otherwise
     */
    public static int getTriangleType(int side1, int side2, int side3) {
        // Equilateral
        if (side1 == side2 && side2 == side3) {
            return 2;
        }

        // Isosceles: two sides equal, third side not
        //
        // You know that at least one side isn't equal because the triangle
        // isn't equilateral, but you could also write it out to be clear:
        //
        // if ((side1 == side2 && side2 != side3) ||
        //     (side2 == side3 && side1 != side2) ||
        //     (side1 == side3 && side2 != side3)) {
        //     ...
        if (side1 == side2 || side2 == side3 || side1 == side3) {
            return 1;
        }

        // Okay, it must be 'other'
        return 0;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // This part asks for the three sides of the triangle. Then it calls the
        // getTriangleType function to determine the type of the triangle.
        //
        // You don't need to change anything here.
        System.out.print("First side of the triangle: ");
        int side1 = reader.nextInt();
        System.out.print("Second side of the triangle: ");
        int side2 = reader.nextInt();
        System.out.print("Third side of the triangle: ");
        int side3 = reader.nextInt();

        int result = getTriangleType(side1, side2, side3);
        if (result == 2) {
            System.out.println("The triangle is equilateral");
        } else if (result == 1) {
            System.out.println("The triangle is isosceles");
        } else {
            System.out.println("The triangle is neither isosceles nor equilateral");
        }
    }
}
