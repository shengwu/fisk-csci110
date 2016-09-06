public class First {
    public static void main(String[] args) {
        double a = 4.0;
        double b = 5.01;

        if (a < b) {
            System.out.println("strike one!");
        }

        double c = 6.0;
        if (b < c) {
            System.out.println("strike two!");
        }

        boolean d = false;
        if (a > c && d) {
            System.out.println("strike three!");
        }
    }
}
