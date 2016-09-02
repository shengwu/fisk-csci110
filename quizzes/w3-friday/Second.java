public class Second {
    public static void main(String[] args) {
        int start = 0;
        int end = 100;
        boolean done = false;
        while (!done) {
            if (start > end) {
                done = false;
            }
            start /= start;
        System.out.println("real quick");
    }
}
