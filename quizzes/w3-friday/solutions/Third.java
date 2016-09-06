public class Third {
    public static void main(String[] args) {
        // Prints a multiplication table from 1 to 6
        int h = 1;
        int v = 1;
        while (h <= 6) {
            while (v <= 6) {
                // Multiplies and prints a spacer
                System.out.print((h * v) + "\t");
                v += 1;
            }
            System.out.print('\n');
            h += 1;
            v = 1;
        }
    }
}
