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
 * Tests for Assignment7.
 *
 * Remember, extra test cases are 1 point extra each up to 20 points.
 */
public class Assignment7Test {
    private static final Random random = new Random();
    private static final double EPS = 0.000000000000001;


    // Helper functions for making speakers

    private ArrayList<Assignment7.Speaker> makeSpeakers(double... volumes) {
        ArrayList<Assignment7.Speaker> speakers = new ArrayList<Assignment7.Speaker>();
        for (int i = 0; i < volumes.length; i++) {
            speakers.add(new Assignment7.Speaker(volumes[i], "DEFAULT"));
        }
        return speakers;
    }

    private ArrayList<Assignment7.Speaker> makeSpeakers(
            List<Double> volumes, List<String> channels) {
        if (volumes.size() != channels.size()) {
            throw new RuntimeException(
                    "Tried to create a list of speakers with mismatched lists of attributes");
        }
        ArrayList<Assignment7.Speaker> speakers = new ArrayList<Assignment7.Speaker>();
        for (int i = 0; i < volumes.size(); i++) {
            speakers.add(new Assignment7.Speaker(volumes.get(i), channels.get(i)));
        }
        return speakers;
    }





    // Tests for the Assignment7.Speaker class

    @Test
    public void testSpeakerInitialization() {
        Assignment7.Speaker s = new Assignment7.Speaker(4.0, "LEFT");
        assertEquals(4.0, s.getVolume(), EPS);
        assertEquals("LEFT", s.getChannel());
    }

    @Test
    public void testSpeakerInitialization2() {
        Assignment7.Speaker s = new Assignment7.Speaker(9.0, "wait let me pick a channel");
        assertEquals(9.0, s.getVolume(), EPS);
        assertEquals("wait let me pick a channel", s.getChannel());
    }

    @Test
    public void testSpeakerInitialization3() {
        Assignment7.Speaker s = new Assignment7.Speaker(0.1234124, "okay i think i got one");
        assertEquals(0.1234124, s.getVolume(), EPS);
        assertEquals("okay i think i got one", s.getChannel());
    }

    @Test
    public void testSpeakerInitializationOverLimit() {
        Assignment7.Speaker s = new Assignment7.Speaker(14.0, "RIGHT");
        assertEquals(10.0, s.getVolume(), EPS);
        assertEquals("RIGHT", s.getChannel());
    }

    @Test
    public void testSpeakerInitializationUnderLimit() {
        Assignment7.Speaker s = new Assignment7.Speaker(-2345.0, "BASS");
        assertEquals(0.0, s.getVolume(), EPS);
        assertEquals("BASS", s.getChannel());
    }

    @Test
    public void testSpeakerSetVolume() {
        Assignment7.Speaker s = new Assignment7.Speaker(4.0, "LEFT");
        assertEquals(4.0, s.getVolume(), EPS);

        s.setVolume(6.0);
        assertEquals(6.0, s.getVolume(), EPS);

        s.setVolume(2.33);
        assertEquals(2.33, s.getVolume(), EPS);
    }

    @Test
    public void testSpeakerSetVolumeOverLimit() {
        Assignment7.Speaker s = new Assignment7.Speaker(4.0, "LEFT");
        assertEquals(4.0, s.getVolume(), EPS);

        s.setVolume(16.0);
        assertEquals(10.0, s.getVolume(), EPS);

        s.setVolume(4.0);
        assertEquals(4.0, s.getVolume(), EPS);

        s.setVolume(40000.0);
        assertEquals(10.0, s.getVolume(), EPS);
    }

    @Test
    public void testSpeakerSetVolumeUnderLimit() {
        Assignment7.Speaker s = new Assignment7.Speaker(4.0, "LEFT");
        assertEquals(4.0, s.getVolume(), EPS);

        s.setVolume(-45.0);
        assertEquals(0.0, s.getVolume(), EPS);

        s.setVolume(5.0);
        assertEquals(5.0, s.getVolume(), EPS);

        s.setVolume(-30450.0);
        assertEquals(0.0, s.getVolume(), EPS);
    }

    @Test
    public void testSpeakerSetVolumeWorksInRange() {
        Assignment7.Speaker s = new Assignment7.Speaker(4.0, "LEFT");
        assertEquals(4.0, s.getVolume(), EPS);

        for (double d = 0.0; d <= 10.0; d += 0.5) {
            s.setVolume(d);
            assertEquals(d, s.getVolume(), EPS);
        }
    }

    @Test
    public void testSpeakerSetVolumeOutOfRange() {
        Assignment7.Speaker s = new Assignment7.Speaker(4.0, "LEFT");
        assertEquals(4.0, s.getVolume(), EPS);

        for (double d = 10.0; d <= 20.0; d += 0.5) {
            s.setVolume(d);
            assertEquals(10.0, s.getVolume(), EPS);
        }

        for (double d = -5.0; d <= -20.0; d -= 0.5) {
            s.setVolume(d);
            assertEquals(0.0, s.getVolume(), EPS);
        }
    }





    // Tests for getMeanVolume

    @Test
    public void testGetMeanVolumeBasic() {
        assertEquals(5.0, Assignment7.getMeanVolume(makeSpeakers(0.0, 10.0)), EPS);
    }

    @Test
    public void testGetMeanVolumeAFew() {
        assertEquals(8.0,
                Assignment7.getMeanVolume(
                    makeSpeakers(4.0, 8.0, 8.0, 10.0, 10.0)),
                EPS);
    }

    @Test
    public void testGetMeanVolumeTen() {
        assertEquals(5.5,
                Assignment7.getMeanVolume(
                    makeSpeakers(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)),
                EPS);
    }


    @Test
    public void testGetMeanVolumeRandom() {
        int N = 100;
        double[] volumes = new double[N];
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            double volume = random.nextDouble();
            volumes[i] = volume;
            sum += volume;
        }
        double expectedMean = sum / N;
        assertEquals(expectedMean,
                Assignment7.getMeanVolume(makeSpeakers(volumes)),
                EPS);
    }

    @Test
    public void testGetMeanVolumeRandomLots() {
        int N = 10000;
        double[] volumes = new double[N];
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            double volume = random.nextDouble();
            volumes[i] = volume;
            sum += volume;
        }
        double expectedMean = sum / N;
        assertEquals(expectedMean,
                Assignment7.getMeanVolume(makeSpeakers(volumes)),
                EPS);
    }



    // Tests for getVolumeRange

    @Test
    public void testGetVolumeRangeBasic() {
        assertEquals(10.0, Assignment7.getVolumeRange(makeSpeakers(0.0, 10.0)), EPS);
    }

    @Test
    public void testGetVolumeRangeAFew() {
        assertEquals(6.0,
                Assignment7.getVolumeRange(
                    makeSpeakers(4.0, 8.0, 8.0, 10.0, 10.0)),
                EPS);
    }

    @Test
    public void testGetVolumeRangeTen() {
        assertEquals(9.0,
                Assignment7.getVolumeRange(
                    makeSpeakers(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)),
                EPS);
    }

    @Test
    public void testGetVolumeRangeRandom() {
        int N = 100;
        ArrayList<Double> volumes = new ArrayList<Double>(N);
        for (int i = 0; i < N; i++) {
            volumes.add(random.nextDouble());
        }
        double range = Collections.max(volumes) - Collections.min(volumes);
        double[] volumesArray = volumes.stream().mapToDouble(Double::doubleValue).toArray();
        assertEquals(range,
                Assignment7.getVolumeRange(makeSpeakers(volumesArray)),
                EPS);
    }

    @Test
    public void testGetVolumeRangeRandomLots() {
        int N = 10000;
        ArrayList<Double> volumes = new ArrayList<Double>(N);
        for (int i = 0; i < N; i++) {
            volumes.add(random.nextDouble());
        }
        double range = Collections.max(volumes) - Collections.min(volumes);
        double[] volumesArray = volumes.stream().mapToDouble(Double::doubleValue).toArray();
        assertEquals(range,
                Assignment7.getVolumeRange(makeSpeakers(volumesArray)),
                EPS);
    }




    // Tests for removeQuiet

    @Test
    public void testRemoveQuietBasic() {
        Assignment7.Speaker quiet = new Assignment7.Speaker(1.0, "quiet");
        Assignment7.Speaker loud = new Assignment7.Speaker(9.0, "loud");
        ArrayList<Assignment7.Speaker> orig = new ArrayList<Assignment7.Speaker>();
        orig.add(quiet);
        orig.add(loud);
        ArrayList<Assignment7.Speaker> expected = new ArrayList<Assignment7.Speaker>();
        expected.add(loud);

        Assignment7.removeQuiet(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testRemoveQuietFive() {
        Assignment7.Speaker quiet = new Assignment7.Speaker(1.0, "quiet");
        Assignment7.Speaker quiet2 = new Assignment7.Speaker(0.01, "quiet");
        Assignment7.Speaker loud = new Assignment7.Speaker(4.0, "loud");
        Assignment7.Speaker loud2 = new Assignment7.Speaker(9.0, "loud");
        Assignment7.Speaker loud3 = new Assignment7.Speaker(5.0, "loud");
        ArrayList<Assignment7.Speaker> orig = new ArrayList<Assignment7.Speaker>();
        orig.add(quiet);
        orig.add(quiet2);
        orig.add(loud);
        orig.add(loud2);
        orig.add(loud3);
        ArrayList<Assignment7.Speaker> expected = new ArrayList<Assignment7.Speaker>();
        expected.add(loud);
        expected.add(loud2);
        expected.add(loud3);

        Assignment7.removeQuiet(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testRemoveQuietTen() {
        ArrayList<Assignment7.Speaker> orig =
            makeSpeakers(0.2, 0.4, 0.6, 0.8, 1.0, 1.2, 1.4, 1.6, 1.8, 2.0);
        ArrayList<Assignment7.Speaker> expected = makeSpeakers(1.2, 1.4, 1.6, 1.8, 2.0);
        Assignment7.removeQuiet(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testRemoveQuietRandom() {
        int N = 100;
        ArrayList<Assignment7.Speaker> orig = new ArrayList<Assignment7.Speaker>();
        ArrayList<Assignment7.Speaker> expected = new ArrayList<Assignment7.Speaker>();
        for (int i = 0; i < N; i++) {
            double volume = random.nextDouble() * 10;
            orig.add(new Assignment7.Speaker(volume, "default"));
            if (volume > 1.0) {
                expected.add(new Assignment7.Speaker(volume, "default"));
            }
        }
        Assignment7.removeQuiet(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testRemoveQuietRandomLots() {
        int N = 10000;
        ArrayList<Assignment7.Speaker> orig = new ArrayList<Assignment7.Speaker>();
        ArrayList<Assignment7.Speaker> expected = new ArrayList<Assignment7.Speaker>();
        for (int i = 0; i < N; i++) {
            double volume = random.nextDouble() * 10;
            orig.add(new Assignment7.Speaker(volume, "default"));
            if (volume > 1.0) {
                expected.add(new Assignment7.Speaker(volume, "default"));
            }
        }
        Assignment7.removeQuiet(orig);
        assertEquals(expected, orig);
    }



    // Tests for bassBoost

    @Test
    public void testBassBoostBasic() {
        Assignment7.Speaker bass = new Assignment7.Speaker(2.0, "SUB");
        Assignment7.Speaker bassBoosted = new Assignment7.Speaker(4.0, "SUB");
        Assignment7.Speaker nonBass = new Assignment7.Speaker(2.0, "L");

        ArrayList<Assignment7.Speaker> orig = new ArrayList<Assignment7.Speaker>();
        orig.add(bass);
        orig.add(nonBass);
        ArrayList<Assignment7.Speaker> expected = new ArrayList<Assignment7.Speaker>();
        expected.add(bassBoosted);
        expected.add(nonBass);

        Assignment7.bassBoost(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testBassBoostFive() {
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
                Arrays.asList(0.2, 0.4, 0.6, 0.8, 1.0),
                Arrays.asList("SUB", "SUB", "SUB", "L", "R"));
        ArrayList<Assignment7.Speaker> expected = makeSpeakers(
                Arrays.asList(0.4, 0.8, 1.2, 0.8, 1.0),
                Arrays.asList("SUB", "SUB", "SUB", "L", "R"));
        Assignment7.bassBoost(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testBassBoostTen() {
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
                Arrays.asList(0.2, 0.4, 0.6, 0.8, 1.0, 5.0, 4.0, 3.0, 2.0, 1.0),
                Arrays.asList("SUB", "SUB", "SUB", "L", "R", "SUB", "SUB", "SUB", "L", "R"));
        ArrayList<Assignment7.Speaker> expected = makeSpeakers(
                Arrays.asList(0.4, 0.8, 1.2, 0.8, 1.0, 10.0, 8.0, 6.0, 2.0, 1.0),
                Arrays.asList("SUB", "SUB", "SUB", "L", "R", "SUB", "SUB", "SUB", "L", "R"));
        Assignment7.bassBoost(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testBassBoostRandom() {
        int N = 100;
        ArrayList<Assignment7.Speaker> orig = new ArrayList<Assignment7.Speaker>();
        ArrayList<Assignment7.Speaker> expected = new ArrayList<Assignment7.Speaker>();
        for (int i = 0; i < N/2; i++) {
            double volume = random.nextDouble() * 10;
            orig.add(new Assignment7.Speaker(volume, "L"));
            expected.add(new Assignment7.Speaker(volume, "L"));
        }
        for (int i = N/2; i < N; i++) {
            double volume = random.nextDouble() * 10;
            orig.add(new Assignment7.Speaker(volume, "SUB"));
            // notice the volume is multiplied by 2
            expected.add(new Assignment7.Speaker(volume * 2, "SUB"));
        }
        Assignment7.bassBoost(orig);
        assertEquals(expected, orig);
    }

    @Test
    public void testBassBoostRandomLots() {
        int N = 10000;
        ArrayList<Assignment7.Speaker> orig = new ArrayList<Assignment7.Speaker>();
        ArrayList<Assignment7.Speaker> expected = new ArrayList<Assignment7.Speaker>();
        for (int i = 0; i < N/2; i++) {
            double volume = random.nextDouble() * 10;
            orig.add(new Assignment7.Speaker(volume, "SUB"));
            // notice the volume is multiplied by 2
            expected.add(new Assignment7.Speaker(volume * 2, "SUB"));
        }
        for (int i = N/2; i < N; i++) {
            double volume = random.nextDouble() * 10;
            orig.add(new Assignment7.Speaker(volume, "R"));
            expected.add(new Assignment7.Speaker(volume, "R"));
        }
        Assignment7.bassBoost(orig);
        assertEquals(expected, orig);
    }






    // Tests for organizeByChannel

    @Test
    public void testOrganizeByChannelBasic() {
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
                Arrays.asList(0.6, 0.8, 1.0),
                Arrays.asList("SUB", "L", "R"));
        HashMap<String, ArrayList<Assignment7.Speaker>> expected =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        expected.put("SUB", makeSpeakers(
                Arrays.asList(0.6),
                Arrays.asList("SUB")));
        expected.put("L", makeSpeakers(
                Arrays.asList(0.8),
                Arrays.asList("L")));
        expected.put("R", makeSpeakers(
                Arrays.asList(1.0),
                Arrays.asList("R")));
        assertEquals(expected, Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelMore() {
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
                Arrays.asList(0.2, 8.8, 0.4, 0.6, 0.8, 1.0),
                Arrays.asList("SUB", "L", "SUB", "SUB", "L", "R"));
        HashMap<String, ArrayList<Assignment7.Speaker>> expected =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        expected.put("SUB", makeSpeakers(
                Arrays.asList(0.2, 0.4, 0.6),
                Arrays.asList("SUB", "SUB", "SUB")));
        expected.put("L", makeSpeakers(
                Arrays.asList(8.8, 0.8),
                Arrays.asList("L", "L")));
        expected.put("R", makeSpeakers(
                Arrays.asList(1.0),
                Arrays.asList("R")));
        assertEquals(expected, Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelTen() {
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
                Arrays.asList(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0),
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        HashMap<String, ArrayList<Assignment7.Speaker>> expected =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        expected.put("J", makeSpeakers(Arrays.asList(1.0), Arrays.asList("J")));
        expected.put("B", makeSpeakers(Arrays.asList(0.2), Arrays.asList("B")));
        expected.put("A", makeSpeakers(Arrays.asList(0.1), Arrays.asList("A")));
        expected.put("D", makeSpeakers(Arrays.asList(0.4), Arrays.asList("D")));
        expected.put("C", makeSpeakers(Arrays.asList(0.3), Arrays.asList("C")));
        expected.put("E", makeSpeakers(Arrays.asList(0.5), Arrays.asList("E")));
        expected.put("G", makeSpeakers(Arrays.asList(0.7), Arrays.asList("G")));
        expected.put("F", makeSpeakers(Arrays.asList(0.6), Arrays.asList("F")));
        expected.put("I", makeSpeakers(Arrays.asList(0.9), Arrays.asList("I")));
        expected.put("H", makeSpeakers(Arrays.asList(0.8), Arrays.asList("H")));
        assertEquals(expected, Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelRandom1() {
        int N = 100;
        Double[] randvols = new Double[100];
        String[] randchs = new String[100];
        for (int i = 0; i < N; i++) {
            randvols[i] = Math.random() * 10;
            randchs[i] = Character.toString((char) (Math.random() * 26 + 97)); 
        }
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
            Arrays.asList(randvols), Arrays.asList(randchs));
        assertEquals(correctOrganizeByChannel(orig), Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelRandom2() {
        int N = 100;
        Double[] randvols = new Double[100];
        String[] randchs = new String[100];
        for (int i = 0; i < N; i++) {
            randvols[i] = Math.random() * 10;
            randchs[i] = Character.toString((char) (Math.random() * 26 + 97)); 
        }
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
            Arrays.asList(randvols), Arrays.asList(randchs));
        assertEquals(correctOrganizeByChannel(orig), Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelRandom3() {
        int N = 100;
        Double[] randvols = new Double[100];
        String[] randchs = new String[100];
        for (int i = 0; i < N; i++) {
            randvols[i] = Math.random() * 10;
            randchs[i] = Character.toString((char) (Math.random() * 26 + 97)); 
        }
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
            Arrays.asList(randvols), Arrays.asList(randchs));
        assertEquals(correctOrganizeByChannel(orig), Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelRandom4() {
        int N = 100;
        Double[] randvols = new Double[100];
        String[] randchs = new String[100];
        for (int i = 0; i < N; i++) {
            randvols[i] = Math.random() * 10;
            randchs[i] = Character.toString((char) (Math.random() * 26 + 97)); 
        }
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
            Arrays.asList(randvols), Arrays.asList(randchs));
        assertEquals(correctOrganizeByChannel(orig), Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelRandom5() {
        int N = 100;
        Double[] randvols = new Double[100];
        String[] randchs = new String[100];
        for (int i = 0; i < N; i++) {
            randvols[i] = Math.random() * 10;
            randchs[i] = Character.toString((char) (Math.random() * 26 + 97)); 
        }
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
            Arrays.asList(randvols), Arrays.asList(randchs));
        assertEquals(correctOrganizeByChannel(orig), Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelRandom6() {
        int N = 100;
        Double[] randvols = new Double[100];
        String[] randchs = new String[100];
        for (int i = 0; i < N; i++) {
            randvols[i] = Math.random() * 10;
            randchs[i] = Character.toString((char) (Math.random() * 26 + 97)); 
        }
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
            Arrays.asList(randvols), Arrays.asList(randchs));
        assertEquals(correctOrganizeByChannel(orig), Assignment7.organizeByChannel(orig));
    }

    @Test
    public void testOrganizeByChannelRandom7() {
        int N = 100;
        Double[] randvols = new Double[100];
        String[] randchs = new String[100];
        for (int i = 0; i < N; i++) {
            randvols[i] = Math.random() * 10;
            randchs[i] = Character.toString((char) (Math.random() * 26 + 97)); 
        }
        ArrayList<Assignment7.Speaker> orig = makeSpeakers(
            Arrays.asList(randvols), Arrays.asList(randchs));
        assertEquals(correctOrganizeByChannel(orig), Assignment7.organizeByChannel(orig));
    }


    private static HashMap<String, ArrayList<Assignment7.Speaker>> correctOrganizeByChannel(
            ArrayList<Assignment7.Speaker> speakers) {
        HashMap<String, ArrayList<Assignment7.Speaker>> result =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (Assignment7.Speaker s : speakers) {
            // We'll need to create a new key-value pair
            // if one doesn't exist for this speaker's channel
            if (!result.containsKey(s.getChannel())) {
                result.put(s.getChannel(), new ArrayList<Assignment7.Speaker>());
            }
            // Add the speaker to the list of speakers where the
            // key == this speaker's channel
            result.get(s.getChannel()).add(s);
        }
        return result;
    }




    // Tests for getLoudByChannel

    @Test
    public void testGetLoudByChannelNoneLoud() {
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        orig.put("SUB", makeSpeakers(
                Arrays.asList(0.6),
                Arrays.asList("SUB")));
        orig.put("L", makeSpeakers(
                Arrays.asList(0.8),
                Arrays.asList("L")));
        orig.put("R", makeSpeakers(
                Arrays.asList(1.0),
                Arrays.asList("R")));
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("SUB", 0);
        expected.put("L", 0);
        expected.put("R", 0);
        assertEquals(expected, Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelTwoLoud() {
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        orig.put("SUB", makeSpeakers(
                Arrays.asList(9.6),
                Arrays.asList("SUB")));
        orig.put("L", makeSpeakers(
                Arrays.asList(0.8),
                Arrays.asList("L")));
        orig.put("R", makeSpeakers(
                Arrays.asList(8.234),
                Arrays.asList("R")));
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("SUB", 1);
        expected.put("L", 0);
        expected.put("R", 1);
        assertEquals(expected, Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelMore() {
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        orig.put("SUB", makeSpeakers(
                Arrays.asList(0.2, 0.4, 0.6),
                Arrays.asList("SUB", "SUB", "SUB")));
        orig.put("L", makeSpeakers(
                Arrays.asList(8.8, 0.8),
                Arrays.asList("L", "L")));
        orig.put("R", makeSpeakers(
                Arrays.asList(1.0),
                Arrays.asList("R")));
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("SUB", 0);
        expected.put("L", 1);
        expected.put("R", 0);
        assertEquals(expected, Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelRandom1() {
        int N = 100;
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (int i = 0; i < N; i++) {
            double randvol = Math.random() * 10;
            String randch = Character.toString((char) (Math.random() * 26 + 97)); 
            Assignment7.Speaker s = new Assignment7.Speaker(randvol, randch);
            if (!orig.containsKey(randch)) {
                orig.put(randch, new ArrayList<Assignment7.Speaker>());
            }
            orig.get(randch).add(s);
        }
        assertEquals(correctGetLoudByChannel(orig), Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelRandom2() {
        int N = 100;
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (int i = 0; i < N; i++) {
            double randvol = Math.random() * 10;
            String randch = Character.toString((char) (Math.random() * 26 + 97)); 
            Assignment7.Speaker s = new Assignment7.Speaker(randvol, randch);
            if (!orig.containsKey(randch)) {
                orig.put(randch, new ArrayList<Assignment7.Speaker>());
            }
            orig.get(randch).add(s);
        }
        assertEquals(correctGetLoudByChannel(orig), Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelRandom3() {
        int N = 100;
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (int i = 0; i < N; i++) {
            double randvol = Math.random() * 10;
            String randch = Character.toString((char) (Math.random() * 26 + 97)); 
            Assignment7.Speaker s = new Assignment7.Speaker(randvol, randch);
            if (!orig.containsKey(randch)) {
                orig.put(randch, new ArrayList<Assignment7.Speaker>());
            }
            orig.get(randch).add(s);
        }
        assertEquals(correctGetLoudByChannel(orig), Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelRandom4() {
        int N = 100;
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (int i = 0; i < N; i++) {
            double randvol = Math.random() * 10;
            String randch = Character.toString((char) (Math.random() * 26 + 97)); 
            Assignment7.Speaker s = new Assignment7.Speaker(randvol, randch);
            if (!orig.containsKey(randch)) {
                orig.put(randch, new ArrayList<Assignment7.Speaker>());
            }
            orig.get(randch).add(s);
        }
        assertEquals(correctGetLoudByChannel(orig), Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelRandom5() {
        int N = 100;
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (int i = 0; i < N; i++) {
            double randvol = Math.random() * 10;
            String randch = Character.toString((char) (Math.random() * 26 + 97)); 
            Assignment7.Speaker s = new Assignment7.Speaker(randvol, randch);
            if (!orig.containsKey(randch)) {
                orig.put(randch, new ArrayList<Assignment7.Speaker>());
            }
            orig.get(randch).add(s);
        }
        assertEquals(correctGetLoudByChannel(orig), Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelRandom6() {
        int N = 100;
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (int i = 0; i < N; i++) {
            double randvol = Math.random() * 10;
            String randch = Character.toString((char) (Math.random() * 26 + 97)); 
            Assignment7.Speaker s = new Assignment7.Speaker(randvol, randch);
            if (!orig.containsKey(randch)) {
                orig.put(randch, new ArrayList<Assignment7.Speaker>());
            }
            orig.get(randch).add(s);
        }
        assertEquals(correctGetLoudByChannel(orig), Assignment7.getLoudByChannel(orig));
    }

    @Test
    public void testGetLoudByChannelRandom7() {
        int N = 100;
        HashMap<String, ArrayList<Assignment7.Speaker>> orig =
            new HashMap<String, ArrayList<Assignment7.Speaker>>();
        for (int i = 0; i < N; i++) {
            double randvol = Math.random() * 10;
            String randch = Character.toString((char) (Math.random() * 26 + 97)); 
            Assignment7.Speaker s = new Assignment7.Speaker(randvol, randch);
            if (!orig.containsKey(randch)) {
                orig.put(randch, new ArrayList<Assignment7.Speaker>());
            }
            orig.get(randch).add(s);
        }
        assertEquals(correctGetLoudByChannel(orig), Assignment7.getLoudByChannel(orig));
    }




    private static HashMap<String, Integer> correctGetLoudByChannel(
            HashMap<String, ArrayList<Assignment7.Speaker>> speakerLookup) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (String channel : speakerLookup.keySet()) {
            int count = 0;
            for (Assignment7.Speaker speaker : speakerLookup.get(channel)) {
                if (speaker.getVolume() >= 8.0) {
                    count += 1;
                }
            }
            result.put(channel, count);
        }
        return result;
    }
}
