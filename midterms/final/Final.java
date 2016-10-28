
/**
 * YOUR FINAL
 * ----------
 *
 * Congratulations, you're done with CSCI 110! Almost.
 *
 * Your final will be to write a program to help choose the contestants of the
 * next American Idol. Thousands of people across the country have auditioned
 * for a spot on the show next season.
 *
 * This presents a few challenges:
 * - doing this all by hand would take forever!
 * - people who auditioned in some places might be at a disadvantage
 *   because judges at there were harder than others
 *
 *
 * Some parts are already written for you:
 * - the part that reads in the comma-separated spreadsheet file
 * - 
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Final {

    /**
     * Problem 1: 200 points
     *
     * Complete the Contestant class by writing:
     * - a constructor
     * - a getName method
     * - a getAuditionLocation method
     * - a getScore method
     * - a setScore method that alters the score of a Contestant
     */
    static class Contestant {
        private String name;
        private String auditionLocation;
        private double score;

        /**
         * Creates a new Contestant.
         */
        // TODO


        /**
         * Returns the name of this contestant.
         */
        // TODO


        /**
         * Returns the audition location of this contestant.
         */
        // TODO


        /**
         * Returns the score of this contestant.
         */
        // TODO


        /**
         * Changes the score of this contestant to a specific value.
         */
        // TODO
    }



    /**
     * Problem 2: 200 points
     *
     * Takes ArrayLists containing all contestant names, audition locations,
     * and scores and returns an ArrayList of Contestant objects with the same
     * information. The name, audition location, and score at index i are all
     * for the same contestant.
     *
     * Hint: think about how you would do this for one Contestant:
     *
     * String name = "LeBron James";
     * String auditionLocation = "Akron";
     * double score = -10.0;
     * Contestant c = new Contestant(name, auditionLocation, score);
     *
     */
    public static ArrayList<Contestant> getContestantList(
            ArrayList<String> names,
            ArrayList<String> auditionLocation,
            ArrayList<Double> scores) {
        // TODO
        return new ArrayList<Contestant>();
    }



    /**
     * Problem 3: 200 points
     *
     * Takes an ArrayList containing all contestants, and creates a HashMap
     */
    public static HashMap<String, ArrayList<Contestant>> getLocationLookup(
            ArrayList<Contestant> allContestants) {
        // TODO

        // Step 1:

        // Step 2:

        return new HashMap<String, ArrayList<Contestant>>();
    }



    /**
     * Problem 4: 200 points
     *
     * Adjust 
     *
     * NOTE: all of the contestants passed in the contestantsInALocation
     * are from the same location!
     */
    public static void normalizeScoresByLocation(
            ArrayList<Contestant> contestantsInALocation) {
        // TODO
    }



    /**
     * DO NOT TOUCH
     *
     * This function takes an ArrayList of all contestants and normalizes
     * their scores based on where they auditioned.
     */
    public static ArrayList<Contestant> normalizeContestantScores(
            HashMap<String, ArrayList<Contestant>> contestantsByLocation) {
        ArrayList<Contestant> normalizedContestants = new ArrayList<Contestant>();
        for (String location : contestantsByLocation.keySet()) {
            // Adjusts all of the contestant scores for a given location
            ArrayList<Contestant> contestantsHere = contestantsByLocation.get(location);
            normalizeScoresByLocation(contestantsHere);

            // Adds all of these contestants to our result
            normalizedContestants.addAll(contestantsHere);
        }
        return normalizedContestants;
    }



    /**
     * Problem 5: 200 points
     *
     * Prints the names of the top 10 contestants from best to worst. Higher
     * scores are better.
     */
    public static void printTop10(ArrayList<Contestant> normalizedContestants) {
        // TODO
    }



    /**
     * Extra credit: 200 points
     *
     * Goes through all of the locations, prints that location, and prints
     * the top 3 contestants at that location (from best to worst).
     *
     * Hint: use getLocationLookup()
     *
     * An example of what this function would print
     * --------------------------------------------
     *
     * NYC:
     * Sam Smith
     * Nicki Minaj
     * Taylor Swift
     *
     * Oakland:
     * Kevin Durant
     * Stephen Curry
     * Lil B
     */
    public static void printTop3ByLocation(ArrayList<Contestant> normalizedContestants) {
        // TODO
    }



    /**
     * The main function never gets run if you're only testing the code.
     *
     * If you've finished everything and want to test your program on test.csv, 
     * run "java Final test.csv".
     */
    public static void main(String[] args) {
        // DO NOT TOUCH: reads in the CSV-format spreadsheet specified by the
        // first command line argument
        if (args.length < 2) {
            System.out.println("Usage: java Final <SPREADSHEET_FILE_NAME>");
            return;
        }

        // TODO: read these in from a spreadsheet
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> auditionLocations = new ArrayList<String>();
        ArrayList<Double> scores = new ArrayList<Double>();


        ArrayList<Contestant> allContestants = getContestantList(
                names, auditionLocations, scores);

        HashMap<String, ArrayList<Contestant>> contestantsByLocation =
                getLocationLookup(allContestants);
                
        ArrayList<Contestant> normalizedContestants =
                normalizeContestantScores(contestantsByLocation);

        // See who the winners are:
        System.out.println("FINAL CONTESTANT LIST:");
        printTop10(normalizedContestants);

        System.out.println("\n\nCONTESTANTS BY LOCATION:");
        printTop3ByLocation(normalizedContestants);
    }
}
