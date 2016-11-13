/**
 * Assignment 7: HashMaps and objects
 * Due: 11:59 pm on Sunday, Nov 20
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Assignment7 {
    /**
     * Problem 1: 20 points
     *
     * Defines an object type that models a piece of audio equipment.
     *
     * Please write:
     * - a constructor
     * - a getVolume method
     * - a setVolume method
     * - a getChannel method
     */
    static class Speaker {
        private double volume;
        private String channel;

        /**
         * Constructs a new Speaker with a given volume and channel.
         */
        Speaker(double volume, String channel) {
            this.volume = volume;
            this.channel = channel;
        }

        /**
         * Returns the volume of this Speaker.
         */
        double getVolume() {
            return volume;
        }

        /**
         * Sets the volume of this Speaker.
         *
         * The maximum volume is 10.0. If the caller tries to set the volume
         * to a value greater than 10.0, the volume should be set to 10.0.
         *
         * If the caller tries to set the volume to a value smaller than 0.0,
         * the volume should be set to 0.0.
         */
        void setVolume(double newVolume) {
            if (newVolume > 10.0) {
                volume = 10.0;
            } else if (newVolume < 0) {
                volume = 0.0;
            } else {
                volume = newVolume;
            }
        }

        /**
         * Returns the channel of this Speaker.
         */
        String getChannel() {
            return channel;
        }
    }





    /**
     * Problem 2: 10 points
     *
     * Returns the mean volume of a group of speakers.
     */
    static double getMeanVolume(ArrayList<Speaker> speakers) {
        double total = 0.0;
        for (Speaker s : speakers) {
            total += s.getVolume();
        }
        return total / speakers.size();
    }




    /**
     * Problem 3: 10 points
     *
     * Returns the range (max - min) of volumes of a group of speakers.
     *
     * There will always be at least one speaker in 'speakers'.
     */
    static double getVolumeRange(ArrayList<Speaker> speakers) {
        double min = speakers.get(0).getVolume();
        double max = speakers.get(0).getVolume();
        for (Speaker s : speakers) {
            if (s.getVolume() > max) {
                max = s.getVolume();
            } else if (s.getVolume() < min) {
                min = s.getVolume();
            }
        }
        return max - min;
    }




    /**
     * Problem 4: 10 points
     *
     * Halves the volume of each speaker in 'speaker'.
     *
     * For example, if 'speakers' is the list:
     *
     *   [ SPEAKER 4.0 L, SPEAKER 7.0 L, SPEAKER 3.0 R ]
     *
     * then this function modify 'speakers' so that it contains:
     *
     *   [ SPEAKER 2.0 L, SPEAKER 3.5 L, SPEAKER 1.5 R ]
     *
     * NOTE: the objects should be unchanged (i.e. this function
     * should not create new objects).
     */
    static void halveVolumes(ArrayList<Speaker> speakers) {
        for (Speaker s : speakers) {
            s.setVolume(s.getVolume() / 2);
        }
    }




    /**
     * Problem 5: 10 points
     *
     * Doubles the volume of each speaker in 'speakers' whose channel is 'SUB'.
     * Of course, volumes can't go over 10.0, a limitation that should be
     * enforced by the Speaker class.
     *
     * For example, if 'speakers' is the list:
     *
     *   [ SPEAKER 4.0 L, SPEAKER 7.0 SUB, SPEAKER 3.0 SUB ]
     *
     * then this function modify 'speakers' so that it contains:
     *
     *   [ SPEAKER 4.0 L, SPEAKER 10.0 SUB, SPEAKER 6.0 SUB ]
     */
    static void bassBoost(ArrayList<Speaker> speakers) {
        for (Speaker s : speakers) {
            if (s.getChannel().equals("SUB")) {
                s.setVolume(s.getVolume() * 2);
            }
        }
    }






    /**
     * Problem 6: 20 points
     * 
     * Organizes a list of speaker objects by channel.
     *
     * For example, if 'speakers' is the list:
     *
     *   [ SPEAKER 4.0 L, SPEAKER 7.0 L, SPEAKER 3.0 R ]
     *
     * then this function should return a HashMap with keys and values:
     *
     *   L: SPEAKER 4.0 L, SPEAKER 7.0 L
     *   R: SPEAKER 3.0 R
     *
     * This means you'll have to create a new ArrayList for each
     * value you'll want to add to the HashMap.
     */
    static HashMap<String, ArrayList<Speaker>> organizeByChannel(
            ArrayList<Speaker> speakers) {
        HashMap<String, ArrayList<Speaker>> result =
            new HashMap<String, ArrayList<Speaker>>();
        for (Speaker s : speakers) {
            // We'll need to create a new key-value pair
            // if one doesn't exist for this speaker's channel
            if (!result.containsKey(s.getChannel())) {
                result.put(s.getChannel(), new ArrayList<Speaker>());
            }
            // Add the speaker to the list of speakers where the
            // key == this speaker's channel
            result.get(s.getChannel()).add(s);
        }
        return result;
    }



    /**
     * Problem 7: 20 points
     *
     * Takes a HashMap of speakers organized by channel and returns a HashMap
     * that says how many speakers in that channel are loud (i.e. volume
     * is greater than or equal to 8.0).
     *
     * For example, if 'speakerLookup' contains the following keys and values:
     *
     *   L: SPEAKER 5.0 L, SPEAKER 9.0 L, SPEAKER 2.0 L
     *   R: SPEAKER 8.5 R, SPEAKER 9.5 R
     * 
     * then this function should return a new HashMap containing the following
     * keys and values:
     *
     *   L: 1
     *   R: 2
     */
    static HashMap<String, Integer> getLoudByChannel(
            HashMap<String, ArrayList<Speaker>> speakerLookup) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        // We're going through each of the key-value pairs in 'speakerLookup'
        // and counting the number of loud speakers for that channel.
        //
        // With the example above, this for-each loop puts 'L', 'R' in the
        // String 'channel'.
        for (String channel : speakerLookup.keySet()) {
            int count = 0;
            // With the example above, this for-each loop puts:
            //
            //   L: SPEAKER 5.0 L, SPEAKER 9.0 L, SPEAKER 2.0 L
            //
            // in 'speaker' if channel == 'L' and puts:
            //
            //   R: SPEAKER 8.5 R, SPEAKER 9.5 R
            //
            // if channel == 'R'.
            for (Speaker speaker : speakerLookup.get(channel)) {
                if (speaker.getVolume() >= 8.0) {
                    count += 1;
                }
            }
            result.put(channel, count);
        }
        return result;
    }
}
