import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.junit.Test;

import java.util.Random;
import org.junit.Test;

/**
 * Tests for Final.java.
 */
public class FinalTest {
    private static final Random random = new Random();
    private static final double EPS = 0.000000000000001;


    // Tests for Contestant

    @Test
    public void testContestantInitialization() {
        Final.Contestant c = new Final.Contestant("Bob", "Chicago", 4.0);
        assertEquals("Bob", c.getName());
        assertEquals("Chicago", c.getAuditionLocation());
        assertEquals(4.0, c.getScore(), EPS);
    }

    @Test
    public void testContestantInitializationAgain() {
        Final.Contestant c = new Final.Contestant("Chris", "LA", 100.23);
        assertEquals("Chris", c.getName());
        assertEquals("LA", c.getAuditionLocation());
        assertEquals(100.23, c.getScore(), EPS);
    }

    @Test
    public void testContestantSetScore() {
        Final.Contestant c = new Final.Contestant("Anne", "NYC", 2.0);
        assertEquals(2.0, c.getScore(), EPS);

        c.setScore(10.0);
        assertEquals(10.0, c.getScore(), EPS);
    }

    @Test
    public void testContestantSetScoreMulti() {
        Final.Contestant c = new Final.Contestant("Bryan", "NYC", 2.0);
        assertEquals(2.0, c.getScore(), EPS);

        c.setScore(10.0);
        assertEquals(10.0, c.getScore(), EPS);

        c.setScore(0.0);
        assertEquals(0.0, c.getScore(), EPS);

        c.setScore(15.0);
        assertEquals(15.0, c.getScore(), EPS);
    }




    // tests for getContestantList

    @Test
    public void testGetContestantListBasic() {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> locations = new ArrayList<String>();
        ArrayList<Double> scores = new ArrayList<Double>();
        names.add("Abby");
        names.add("Barack");
        locations.add("Portland");
        locations.add("DC");
        scores.add(5.0);
        scores.add(10.5);

        ArrayList<Final.Contestant> expected = new ArrayList<Final.Contestant>();
        expected.add(new Final.Contestant("Abby", "Portland", 5.0));
        expected.add(new Final.Contestant("Barack", "DC", 10.5));

        assertEquals(expected, Final.getContestantList(names, locations, scores));
    }

    @Test
    public void testGetContestantListMore() {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> locations = new ArrayList<String>();
        ArrayList<Double> scores = new ArrayList<Double>();
        names.add("Abby");
        names.add("Barack");
        names.add("Carol");
        names.add("Dave");
        locations.add("Portland");
        locations.add("DC");
        locations.add("LA");
        locations.add("SF");
        scores.add(5.0);
        scores.add(10.5);
        scores.add(2.0);
        scores.add(25.0343);

        ArrayList<Final.Contestant> expected = new ArrayList<Final.Contestant>();
        expected.add(new Final.Contestant("Abby", "Portland", 5.0));
        expected.add(new Final.Contestant("Barack", "DC", 10.5));
        expected.add(new Final.Contestant("Carol", "LA", 2.0));
        expected.add(new Final.Contestant("Dave", "SF", 25.0343));

        assertEquals(expected, Final.getContestantList(names, locations, scores));
    }



    // tests for getLocationLookup

    @Test
    public void testGetLocationLookupBasic() {
        ArrayList<Final.Contestant> orig = new ArrayList<Final.Contestant>();
        orig.add(new Final.Contestant("Abby", "Portland", 5.0));
        orig.add(new Final.Contestant("Barack", "DC", 10.5));
        orig.add(new Final.Contestant("Carol", "Portland", 2.0));
        orig.add(new Final.Contestant("Dave", "SF", 25.0343));

        ArrayList<Final.Contestant> portland = new ArrayList<Final.Contestant>();
        portland.add(new Final.Contestant("Abby", "Portland", 5.0));
        portland.add(new Final.Contestant("Carol", "Portland", 2.0));
        ArrayList<Final.Contestant> dc = new ArrayList<Final.Contestant>();
        dc.add(new Final.Contestant("Barack", "DC", 10.5));
        ArrayList<Final.Contestant> sf = new ArrayList<Final.Contestant>();
        sf.add(new Final.Contestant("Dave", "SF", 25.0343));

        HashMap<String, ArrayList<Final.Contestant>> expected =
            new HashMap<String, ArrayList<Final.Contestant>>();
        expected.put("Portland", portland);
        expected.put("DC", dc);
        expected.put("SF", sf);

        assertEquals(expected, Final.getLocationLookup(orig));
    }

    @Test
    public void testGetLocationLookupMore() {
        ArrayList<Final.Contestant> orig = new ArrayList<Final.Contestant>();
        orig.add(new Final.Contestant("Abby", "Portland", 5.0));
        orig.add(new Final.Contestant("Barack", "DC", 10.5));
        orig.add(new Final.Contestant("Carol", "Portland", 2.0));
        orig.add(new Final.Contestant("Dave", "SF", 25.0343));
        orig.add(new Final.Contestant("Edith", "DC", 15.5));
        orig.add(new Final.Contestant("Fergus", "Portland", 12.21));
        orig.add(new Final.Contestant("Greg", "SF", 9.9));

        ArrayList<Final.Contestant> portland = new ArrayList<Final.Contestant>();
        portland.add(new Final.Contestant("Abby", "Portland", 5.0));
        portland.add(new Final.Contestant("Carol", "Portland", 2.0));
        portland.add(new Final.Contestant("Fergus", "Portland", 12.21));
        ArrayList<Final.Contestant> dc = new ArrayList<Final.Contestant>();
        dc.add(new Final.Contestant("Barack", "DC", 10.5));
        dc.add(new Final.Contestant("Edith", "DC", 15.5));
        ArrayList<Final.Contestant> sf = new ArrayList<Final.Contestant>();
        sf.add(new Final.Contestant("Dave", "SF", 25.0343));
        sf.add(new Final.Contestant("Greg", "SF", 9.9));

        HashMap<String, ArrayList<Final.Contestant>> expected =
            new HashMap<String, ArrayList<Final.Contestant>>();
        expected.put("Portland", portland);
        expected.put("DC", dc);
        expected.put("SF", sf);

        assertEquals(expected, Final.getLocationLookup(orig));
    }




    // tests for normalizeScores

    @Test
    public void testNormalizeScoresBasic() {
        ArrayList<Final.Contestant> orig = new ArrayList<Final.Contestant>();
        orig.add(new Final.Contestant("First", "Foo", 5.0));
        orig.add(new Final.Contestant("Second", "Foo", 10.0));
        orig.add(new Final.Contestant("Third", "Foo", 15.0));

        ArrayList<Final.Contestant> expected = new ArrayList<Final.Contestant>();
        expected.add(new Final.Contestant("First", "Foo", -1.224744871391589));
        expected.add(new Final.Contestant("Second", "Foo", 0.0));
        expected.add(new Final.Contestant("Third", "Foo", 1.224744871391589));

        Final.normalizeScores(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testNormalizeScoresMore() {
        ArrayList<Final.Contestant> orig = new ArrayList<Final.Contestant>();
        orig.add(new Final.Contestant("First", "Bar", 2.0));
        orig.add(new Final.Contestant("Second", "Bar", 3.0));
        orig.add(new Final.Contestant("Third", "Bar", 4.0));
        orig.add(new Final.Contestant("Fourth", "Bar", 6.0));
        orig.add(new Final.Contestant("Fifth", "Bar", 8.0));

        ArrayList<Final.Contestant> expected = new ArrayList<Final.Contestant>();
        expected.add(new Final.Contestant("First", "Bar", -1.207019698150837));
        expected.add(new Final.Contestant("Second", "Bar", -0.7427813527082073));
        expected.add(new Final.Contestant("Third", "Bar", -0.2785430072655776));
        expected.add(new Final.Contestant("Fourth", "Bar", 0.6499336836196817));
        expected.add(new Final.Contestant("Fifth", "Bar", 1.5784103745049411));

        Final.normalizeScores(orig);
        assertEquals(expected, orig);
    }






    // tests for getTop10

    @Test
    public void testGetTop10Basic() {
        ArrayList<Final.Contestant> orig = new ArrayList<Final.Contestant>();
        orig.add(new Final.Contestant("One", "Foo", 1.0));
        orig.add(new Final.Contestant("Two", "Foo", 2.0));
        orig.add(new Final.Contestant("Three", "Foo", 3.0));
        orig.add(new Final.Contestant("Four", "Foo", 4.0));
        orig.add(new Final.Contestant("Five", "Foo", 5.0));
        orig.add(new Final.Contestant("Six", "Foo", 6.0));
        orig.add(new Final.Contestant("Seven", "Foo", 7.0));
        orig.add(new Final.Contestant("Eight", "Foo", 8.0));
        orig.add(new Final.Contestant("Nine", "Foo", 9.0));
        orig.add(new Final.Contestant("Ten", "Foo", 10.0));
        orig.add(new Final.Contestant("Eleven", "Foo", 11.0));
        orig.add(new Final.Contestant("Twelve", "Foo", 12.0));

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Twelve");
        expected.add("Eleven");
        expected.add("Ten");
        expected.add("Nine");
        expected.add("Eight");
        expected.add("Seven");
        expected.add("Six");
        expected.add("Five");
        expected.add("Four");
        expected.add("Three");

        assertEquals(expected, Final.getTop10(orig));
    }

    @Test
    public void testGetTop10Jumbled() {
        ArrayList<Final.Contestant> orig = new ArrayList<Final.Contestant>();
        orig.add(new Final.Contestant("Eight", "Foo", 8.0));
        orig.add(new Final.Contestant("One", "Foo", 1.0));
        orig.add(new Final.Contestant("Fourteen", "Foo", 14.0));
        orig.add(new Final.Contestant("Seven", "Foo", 7.0));
        orig.add(new Final.Contestant("Six", "Foo", 6.0));
        orig.add(new Final.Contestant("Nine", "Foo", 9.0));
        orig.add(new Final.Contestant("Eleven", "Foo", 11.0));
        orig.add(new Final.Contestant("Thirteen", "Foo", 13.0));
        orig.add(new Final.Contestant("Twelve", "Foo", 12.0));
        orig.add(new Final.Contestant("Two", "Foo", 2.0));
        orig.add(new Final.Contestant("Three", "Foo", 3.0));
        orig.add(new Final.Contestant("Sixteen", "Foo", 16.0));
        orig.add(new Final.Contestant("Four", "Foo", 4.0));
        orig.add(new Final.Contestant("Fifteen", "Foo", 15.0));
        orig.add(new Final.Contestant("Ten", "Foo", 10.0));
        orig.add(new Final.Contestant("Five", "Foo", 5.0));

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Sixteen");
        expected.add("Fifteen");
        expected.add("Fourteen");
        expected.add("Thirteen");
        expected.add("Twelve");
        expected.add("Eleven");
        expected.add("Ten");
        expected.add("Nine");
        expected.add("Eight");
        expected.add("Seven");

        assertEquals(expected, Final.getTop10(orig));
    }



    // write your own tests for getTop3ByLocation

}
