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
    public void firstPersonOlderByExactlyAYear() {
        int result = Greeter.whoIsOlder(
                1985, 2, 10,
                1986, 2, 10);
        assertEquals(-1, result);
    }

    @Test
    public void secondPersonOlderByExactlyAYear() {
        int result = Greeter.whoIsOlder(
                1990, 1, 15,
                1989, 1, 15);
        assertEquals(1, result);
    }

    @Test
    public void firstPersonOlderByMonths() {
        int result = Greeter.whoIsOlder(
                1995, 5, 21,
                1995, 11, 21);
        assertEquals(-1, result);
    }

    @Test
    public void secondPersonOlderByMonths() {
        int result = Greeter.whoIsOlder(
                1995, 5, 21,
                1995, 2, 21);
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

    @Test
    public void twoPeopleEqualInAge() {
        int result = Greeter.whoIsOlder(
                1992, 9, 9,
                1992, 9, 9);
        assertEquals(0, result);
    }

    @Test
    public void twoPeopleEqualInAge2() {
        int result = Greeter.whoIsOlder(
                2077, 4, 13,
                2077, 4, 13);
        assertEquals(0, result);
    }
}
