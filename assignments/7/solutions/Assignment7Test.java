import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
            ArrayList<Double> volumes, ArrayList<String> channels) {
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
    public void testGetMeanVolumeRandomLong() {
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
    public void testGetVolumeRangeRandomLong() {
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



    // Tests for bassBoost



    // Tests for organizeByChannel



    // Tests for getLoudByChannel


}
