public class Second {
    public static void main(String[] args) {
        int start = 0;
        int end = 100;
        boolean done = false;
        while (!done) {
            if (start > end) {
                done = true;
            }
            start += 1;
        }
        System.out.println("real quick");
    }
}
