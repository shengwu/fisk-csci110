import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import org.junit.Test;

/**
 * Tests for Assignment6.
 *
 * Remember, extra test cases are 1 point extra each up to 20 points.
 */
public class Assignment6Test {
    private static final Random random = new Random();


    // enumerateDivisibleBy3()

    @Test
    public void testEnumerateDivisibleBy3First3() {
        HashMap<Integer, Boolean> result = Assignment6.enumerateDivisibleBy3();
        assertTrue(result.containsKey(1));
        assertEquals(false, result.get(1));
        assertTrue(result.containsKey(2));
        assertEquals(false, result.get(2));
        assertTrue(result.containsKey(3));
        assertEquals(true, result.get(3));
    }

    @Test
    public void testEnumerateDivisibleBy3Other3() {
        HashMap<Integer, Boolean> result = Assignment6.enumerateDivisibleBy3();
        assertTrue(result.containsKey(15));
        assertEquals(true, result.get(15));
        assertTrue(result.containsKey(17));
        assertEquals(false, result.get(17));
        assertTrue(result.containsKey(18));
        assertEquals(true, result.get(18));
    }

    @Test
    public void testEnumerateDivisibleBy3DoesntIncludeOthers() {
        HashMap<Integer, Boolean> result = Assignment6.enumerateDivisibleBy3();
        assertFalse(result.containsKey(0));
        assertFalse(result.containsKey(101));
    }

    @Test
    public void testEnumerateDivisibleBy3Thru50() {
        HashMap<Integer, Boolean> result = Assignment6.enumerateDivisibleBy3();
        for (int i = 1; i <= 50; i++) {
            assertTrue(result.containsKey(i));
            assertEquals(i % 3 == 0, result.get(i));
        }
    }

    @Test
    public void testEnumerateDivisibleBy3Over50() {
        HashMap<Integer, Boolean> result = Assignment6.enumerateDivisibleBy3();
        for (int i = 51; i <= 100; i++) {
            assertTrue(result.containsKey(i));
            assertEquals(i % 3 == 0, result.get(i));
        }
    }





    // hasAtLeast10Distinct()

    @Test
    public void testHasAtLeast10DistinctBasicFalse() {
        String s = "assignments";
        assertFalse(Assignment6.hasAtLeast10Distinct(s));
    }

    @Test
    public void testHasAtLeast10DistinctBasicTrue() {
        String s = "thequickbrownfoxjumpedoverthelazydog";
        assertTrue(Assignment6.hasAtLeast10Distinct(s));
    }

    @Test
    public void testHasAtLeast10DistinctEmpty() {
        String s = "";
        assertFalse(Assignment6.hasAtLeast10Distinct(s));
    }

    @Test
    public void testHasAtLeast10DistinctAround10() {
        assertFalse(Assignment6.hasAtLeast10Distinct("abcdefgh"));
        assertFalse(Assignment6.hasAtLeast10Distinct("abcdefghi"));
        assertTrue(Assignment6.hasAtLeast10Distinct("abcdefghij"));
        assertTrue(Assignment6.hasAtLeast10Distinct("abcdefghijk"));
    }

    @Test
    public void testHasAtLeast10DistinctPunctuation() {
        assertFalse(Assignment6.hasAtLeast10Distinct("helloworld"));
        assertTrue(Assignment6.hasAtLeast10Distinct("hello worlds!"));
        assertTrue(Assignment6.hasAtLeast10Distinct("h4l10wor)d"));
        assertFalse(Assignment6.hasAtLeast10Distinct("          "));
        assertFalse(Assignment6.hasAtLeast10Distinct("!@#$%^&*("));
        assertTrue(Assignment6.hasAtLeast10Distinct("!@#$%^&*()"));
        assertTrue(Assignment6.hasAtLeast10Distinct("[]{};':)'<>,.?"));
    }





    // countAsBsandCs()

    @Test
    public void testCountAsBsandCsBasic() {
        HashMap<Character, Integer> counts =
            Assignment6.countAsBsandCs("AC AC C");
        assertTrue(counts.containsKey('A'));
        assertFalse(counts.containsKey('B'));
        assertTrue(counts.containsKey('C'));
        assertEquals(new Integer(2), counts.get('A'));
        assertEquals(new Integer(3), counts.get('C'));
    }

    @Test
    public void testCountAsBsandCsWord() {
        HashMap<Character, Integer> counts =
            Assignment6.countAsBsandCs("AlphaBet");
        assertTrue(counts.containsKey('A'));
        assertTrue(counts.containsKey('B'));
        assertFalse(counts.containsKey('C'));
        assertEquals(new Integer(1), counts.get('A'));
        assertEquals(new Integer(1), counts.get('B'));
    }

    @Test
    public void testCountAsBsandCsOtherCharsExcluded() {
        HashMap<Character, Integer> counts =
            Assignment6.countAsBsandCs("AllBetCha");
        assertTrue(counts.containsKey('A'));
        assertTrue(counts.containsKey('B'));
        assertTrue(counts.containsKey('C'));
        assertFalse(counts.containsKey('l'));
        assertFalse(counts.containsKey('e'));
        assertFalse(counts.containsKey('t'));
        assertFalse(counts.containsKey('h'));
        assertFalse(counts.containsKey('a'));
        assertEquals(new Integer(1), counts.get('A'));
        assertEquals(new Integer(1), counts.get('B'));
        assertEquals(new Integer(1), counts.get('C'));
    }

    @Test
    public void testCountAsBsandCsPunctuationExcluded() {
        HashMap<Character, Integer> counts =
            Assignment6.countAsBsandCs("hello !world&AARON");
        assertTrue(counts.containsKey('A'));
        assertFalse(counts.containsKey('B'));
        assertFalse(counts.containsKey('C'));
        assertFalse(counts.containsKey('h'));
        assertFalse(counts.containsKey('e'));
        assertFalse(counts.containsKey('l'));
        assertFalse(counts.containsKey('o'));
        assertFalse(counts.containsKey('w'));
        assertFalse(counts.containsKey('l'));
        assertFalse(counts.containsKey('d'));
        assertFalse(counts.containsKey(' '));
        assertFalse(counts.containsKey('!'));
        assertFalse(counts.containsKey('&'));
        assertEquals(new Integer(2), counts.get('A'));
    }

    @Test
    public void testCountAsBsandCsNumbersExcluded() {
        HashMap<Character, Integer> counts =
            Assignment6.countAsBsandCs("A1B0C3B2A9B4C");
        assertTrue(counts.containsKey('A'));
        assertTrue(counts.containsKey('B'));
        assertTrue(counts.containsKey('C'));
        assertFalse(counts.containsKey('1'));
        assertFalse(counts.containsKey('0'));
        assertFalse(counts.containsKey('3'));
        assertFalse(counts.containsKey('4'));
        assertFalse(counts.containsKey('9'));
        assertEquals(new Integer(2), counts.get('A'));
        assertEquals(new Integer(3), counts.get('B'));
        assertEquals(new Integer(2), counts.get('C'));
    }






    // compressCoinTosses()

    @Test
    public void testCompressCoinTossesBasic() {
        assertEquals("H3T5", Assignment6.compressCoinTosses("HHHTTTTT"));
    }

    @Test
    public void testCompressCoinTossesLonger() {
        assertEquals("H3T5H2T1H1T6",
                Assignment6.compressCoinTosses("HHHTTTTTHHTHTTTTTT"));
    }

    @Test
    public void testCompressCoinTossesSingleBoth() {
        assertEquals("T1H1", Assignment6.compressCoinTosses("TH"));
    }

    @Test
    public void testCompressCoinTossesAlternating() {
        assertEquals("H1T1H1T1H1T1H1",
                Assignment6.compressCoinTosses("HTHTHTH"));
    }

    @Test
    public void testCompressCoinTossesManyTails() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 800; i++) {
            builder.append('T');
        }
        assertEquals("T800", Assignment6.compressCoinTosses(builder.toString()));
    }

    @Test
    public void testCompressCoinTossesManyBoth() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 123; i++) {
            builder.append('H');
        }
        for (int i = 0; i < 456; i++) {
            builder.append('T');
        }
        for (int i = 0; i < 789; i++) {
            builder.append('H');
        }
        for (int i = 0; i < 1234; i++) {
            builder.append('T');
        }
        assertEquals("H123T456H789T1234",
                Assignment6.compressCoinTosses(builder.toString()));
    }

    @Test
    public void testCompressCoinTossesEmpty() {
        assertEquals("", Assignment6.compressCoinTosses(""));
    }

    @Test
    public void testCompressCoinTossesIncreasing() {
        assertEquals("H1T1H2T2H3T3H4T4",
                Assignment6.compressCoinTosses("HTHHTTHHHTTTHHHHTTTT"));
    }





    // createZipLookup()

    @Test
    public void testCreateZipLookupBasic() {
        ArrayList<String> zipCodes = new ArrayList<String>();
        ArrayList<String> cities = new ArrayList<String>();
        zipCodes.add("12345");
        zipCodes.add("67890");
        cities.add("Springfield, MN");
        cities.add("Gary, IN");

        HashMap<String, String> result =
            Assignment6.createZipLookup(zipCodes, cities);
        assertEquals(2, result.size());
        assertTrue(result.containsKey("12345"));
        assertTrue(result.containsKey("67890"));
        assertEquals("Springfield, MN", result.get("12345"));
        assertEquals("Gary, IN", result.get("67890"));
    }

    @Test
    public void testCreateZipLookupFive() {
        ArrayList<String> zipCodes = new ArrayList<String>();
        ArrayList<String> cities = new ArrayList<String>();
        zipCodes.add("12345");
        zipCodes.add("67890");
        zipCodes.add("44444");
        zipCodes.add("99999");
        zipCodes.add("83234-5823");
        cities.add("Springfield, MN");
        cities.add("Gary, IN");
        cities.add("Maui, HI");
        cities.add("Test, FAKE");
        cities.add("Foo, BAR");

        HashMap<String, String> result =
            Assignment6.createZipLookup(zipCodes, cities);
        assertEquals(5, result.size());
        assertTrue(result.containsKey("12345"));
        assertTrue(result.containsKey("67890"));
        assertTrue(result.containsKey("44444"));
        assertTrue(result.containsKey("99999"));
        assertTrue(result.containsKey("83234-5823"));
        assertEquals("Springfield, MN", result.get("12345"));
        assertEquals("Gary, IN", result.get("67890"));
        assertEquals("Maui, HI", result.get("44444"));
        assertEquals("Test, FAKE", result.get("99999"));
        assertEquals("Foo, BAR", result.get("83234-5823"));
    }

    private static String getRandomString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            b.append((char) (random.nextInt(26) + 92));
        }
        return b.toString();
    }

    @Test
    public void testCreateZipLookupRandom() {
        ArrayList<String> zipCodes = new ArrayList<String>();
        ArrayList<String> cities = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            zipCodes.add(getRandomString());
            cities.add(getRandomString());
        }

        HashMap<String, String> result =
            Assignment6.createZipLookup(zipCodes, cities);
        assertEquals(zipCodes.size(), result.size());
        for (int i = 0; i < 12; i++) {
            assertTrue(result.containsKey(zipCodes.get(i)));
            assertEquals(cities.get(i), result.get(zipCodes.get(i)));
        }
    }

    @Test
    public void testCreateZipLookupRandomLong() {
        ArrayList<String> zipCodes = new ArrayList<String>();
        ArrayList<String> cities = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            zipCodes.add(getRandomString());
            cities.add(getRandomString());
        }

        HashMap<String, String> result =
            Assignment6.createZipLookup(zipCodes, cities);
        assertEquals(zipCodes.size(), result.size());
        for (int i = 0; i < 100; i++) {
            assertTrue(result.containsKey(zipCodes.get(i)));
            assertEquals(cities.get(i), result.get(zipCodes.get(i)));
        }
    }

    @Test
    public void testCreateZipLookupRandomSuperLong() {
        ArrayList<String> zipCodes = new ArrayList<String>();
        ArrayList<String> cities = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            zipCodes.add(getRandomString());
            cities.add(getRandomString());
        }

        HashMap<String, String> result =
            Assignment6.createZipLookup(zipCodes, cities);
        assertEquals(zipCodes.size(), result.size());
        for (int i = 0; i < 10000; i++) {
            assertTrue(result.containsKey(zipCodes.get(i)));
            assertEquals(cities.get(i), result.get(zipCodes.get(i)));
        }
    }






    // allValidWords()

    @Test
    public void testAllValidWordsBasic() {
        HashSet<String> dict = new HashSet<String>();
        dict.add("hello");
        dict.add("world");
        assertTrue(Assignment6.allValidWords("hello world", dict));
        assertTrue(Assignment6.allValidWords("world hello", dict));
        assertTrue(Assignment6.allValidWords("world hello world world", dict));
        assertTrue(Assignment6.allValidWords("hello", dict));
        assertTrue(Assignment6.allValidWords("world", dict));
        assertFalse(Assignment6.allValidWords("hello world fisk", dict));
        assertFalse(Assignment6.allValidWords("test hello world", dict));
        assertFalse(Assignment6.allValidWords("foo hello world bar", dict));
    }

    @Test
    public void testAllValidWordsRandom() {
        HashSet<String> dict = new HashSet<String>();
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String rand = getRandomString();
            dict.add(rand);
            words.add(rand);
        }

        for (int i = 0; i < 100; i++) {
            Collections.shuffle(words);
            String sentence = String.join(" ", words);
            assertTrue(Assignment6.allValidWords(sentence, dict));
        }

        // Add some invalid words to 'words'
        // (f you're reading this, this is bad, lazy code)
        words.add("whatarethechances");

        for (int i = 0; i < 100; i++) {
            Collections.shuffle(words);
            String sentence = String.join(" ", words);
            assertFalse(Assignment6.allValidWords(sentence, dict));
        }
    }


    @Test
    public void testAllValidWordsRandomLong() {
        HashSet<String> dict = new HashSet<String>();
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            String rand = getRandomString();
            dict.add(rand);
            words.add(rand);
        }

        for (int i = 0; i < 100; i++) {
            Collections.shuffle(words);
            String sentence = String.join(" ", words);
            assertTrue(Assignment6.allValidWords(sentence, dict));
        }

        // Add some invalid words to 'words'
        // (f you're reading this, this is bad, lazy code)
        words.add("whatarethechances");

        for (int i = 0; i < 100; i++) {
            Collections.shuffle(words);
            String sentence = String.join(" ", words);
            assertFalse(Assignment6.allValidWords(sentence, dict));
        }
    }

    @Test
    public void testAllValidWordsRandomLonger() {
        HashSet<String> dict = new HashSet<String>();
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 300; i++) {
            String rand = getRandomString();
            dict.add(rand);
            words.add(rand);
        }

        for (int i = 0; i < 100; i++) {
            Collections.shuffle(words);
            String sentence = String.join(" ", words);
            assertTrue(Assignment6.allValidWords(sentence, dict));
        }

        // Add some invalid words to 'words'
        // (f you're reading this, this is bad, lazy code)
        words.add("whatarethechances");

        for (int i = 0; i < 100; i++) {
            Collections.shuffle(words);
            String sentence = String.join(" ", words);
            assertFalse(Assignment6.allValidWords(sentence, dict));
        }
    }





    // countCities()





    // sort()

    @Test
    public void testSortSingle() {
        Assignment6.Dog d = new Assignment6.Dog(10.0);
        Assignment6.Dog[] orig = {d};
        Assignment6.Dog[] expected = {d};
        Assignment6.sort(orig);
        assertArrayEquals(expected, orig);
    }

    @Test
    public void testSortTwo() {
        Assignment6.Dog d = new Assignment6.Dog(10.0);
        Assignment6.Dog d2 = new Assignment6.Dog(20.0);
        Assignment6.Dog[] orig = {d, d2};
        Assignment6.Dog[] expected = {d2, d};
        Assignment6.sort(orig);
        assertArrayEquals(expected, orig);
    }


    // dumbHash()
    // uncomment to test extra credit

    @Test
    public void testDumbHashBasic() {
        assertEquals(116, Assignment6.dumbHash("hello"));
    }

}
