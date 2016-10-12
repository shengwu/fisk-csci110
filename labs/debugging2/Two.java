
/**
 * The following class contains runtime errors. Please fix them and describe
 * the errors in comments near where you found the errors.
 */
public class Two {

    static int mystery(int[] arr) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % i != 0) {
                    return i-1;
                }
            }
        }
        return -1;
    }

    static double mystery2(double[] arr) {
        double m = arr[0];
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8, 9};
        System.out.println(mystery(a));

        int[] b = {4, 12, 16, 20, 24, 32};
        System.out.println(mystery(b));

        double[] c = {5.6, 8.9, 3534.34, 56e12, 34.533};
        System.out.println(mystery2(c));

        double[] d = {1e9, 2e10, 5e67, 8e23, 5.0, 23.5, 1.0, 2.0, 3.0};
        System.out.println(mystery2(d));
    }
}
