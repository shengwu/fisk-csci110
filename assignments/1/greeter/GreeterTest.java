import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GreeterTest {
    @Test
    public void firstPersonOlderByOverAYear() {
        int result = Greeter.whoIsOlder(
                1985, 5, 23,
                1990, 3, 21);
        assertEquals(-1, result);
    }

    @Test
    public void secondPersonOlderByOverAYear() {
        int result = Greeter.whoIsOlder(
                1990, 5, 23,
                1985, 3, 21);
        assertEquals(1, result);
    }

    @Test
    public void firstPersonOlderByDays() {
        int result = Greeter.whoIsOlder(
                1995, 5, 7,
                1995, 5, 21);
        assertEquals(-1, result);
    }

    @Test
    public void secondPersonOlderByDays() {
        int result = Greeter.whoIsOlder(
                1995, 5, 23,
                1995, 5, 21);
        assertEquals(1, result);
    }

    // Add any additional test cases here!
}
