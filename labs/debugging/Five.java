public class Five {
    public static void main(String[] args) {
        // The following program prints a 10x10 ADDITION table. So
        // it shows you how to add any two numbers from 1 through 10; the
        // horizontal axis and the vertical axis both go from 1 to 10.
        //
        // It's like a multiplication table, but instead it's addition,
        // for people who are REALLY bad at math.
        //
        // But something's funny about this table.

        int MAX_DIM = 9;
        int j = 1;
        for (int i = 1; i < MAX_DIM; i++) {
            while (j < MAX_DIM) {
                System.out.print((i * j) + "\t");
                j += 2;
            }
            System.out.println();
            j = 0;
        }
    }
}
