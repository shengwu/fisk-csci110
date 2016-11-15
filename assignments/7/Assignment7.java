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
         *
         * The maximum volume is 10.0. If the caller tries to set the volume
         * to a value greater than 10.0, the volume should be set to 10.0.
         *
         * If the caller tries to set the volume to a value smaller than 0.0,
         * the volume should be set to 0.0.
         */

        /**
         * Returns the volume of this Speaker.
         */

        /**
         * Sets the volume of this Speaker.
         *
         * The maximum volume is 10.0. If the caller tries to set the volume
         * to a value greater than 10.0, the volume should be set to 10.0.
         *
         * If the caller tries to set the volume to a value smaller than 0.0,
         * the volume should be set to 0.0.
         */

        /**
         * Returns the channel of this Speaker.
         */

        /**
         * Do not touch
         */
        public boolean equals(Object o) {
            if (o == null || o.getClass() != Speaker.class) {
                return false;
            }
            Speaker other = (Speaker) o;
            return this.volume == other.volume && this.channel.equals(other.channel);
        }
    }





    /**
     * Problem 2: 10 points
     *
     * Returns the mean volume of a group of speakers.
     */
    static double getMeanVolume(ArrayList<Speaker> speakers) {
        // TODO
        return 0.0;
    }




    /**
     * Problem 3: 10 points
     *
     * Returns the range (max - min) of volumes of a group of speakers.
     *
     * There will always be at least one speaker in 'speakers'.
     */
    static double getVolumeRange(ArrayList<Speaker> speakers) {
        // TODO
        return 0.0;
    }




    /**
     * Problem 4: 10 points
     *
     * Removes all quiet (volume less than or equal to 1.0) speakers from 'speakers'.
     *
     * For example, if 'speakers' is the list:
     *
     *   [ SPEAKER 1.0 L, SPEAKER 7.0 L, SPEAKER 0.3 R ]
     *
     * then this function modify 'speakers' so that it contains:
     *
     *   [ SPEAKER 7.0 L ]
     *
     * NOTE: the objects should be unchanged (i.e. this function
     * should not create new objects).
     */
    static void removeQuiet(ArrayList<Speaker> speakers) {
        // TODO
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
        // TODO
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
        // TODO
        return new HashMap<String, ArrayList<Speaker>>();
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
        // TODO
        return new HashMap<String, Integer>();
    }
}
