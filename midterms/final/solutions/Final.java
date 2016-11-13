/**
 * FINAL EXAM
 * ----------
 * 1000 points
 *
 * WRITE YOUR NAME HERE: 
 *
 * Congratulations, you're done with CSCI 110! Almost.
 *
 * Your final will be to write a program to help choose the contestants of the
 * next American Idol. Thousands of people across the country have auditioned
 * for a spot on the show next season.
 *
 * This presents a few challenges:
 * - selecting contestants by hand would take forever!
 * - people who auditioned in some places might be at a disadvantage
 *   because judges there were harder than judges elsewhere
 *
 * In this exam, you'll write a series of functions to automatically process a
 * year's worth of audition data. One such year has been included in a file
 * named test.csv. The code you write should work for any other similarly
 * formatted file, including ones that have thousands of entries.
 *
 * Use the tests in FinalTest.java to test your code with JUnit:
 *   javac Final.java FinalTest.java
 *   java org.junit.runner.JUnitCore FinalTest
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
        public Contestant(String name, String auditionLocation, double score) {
            this.name = name;
            this.auditionLocation = auditionLocation;
            this.score = score;
        }

        /**
         * Returns the name of this contestant.
         */
        public String getName() {
            return name;
        }


        /**
         * Returns the audition location of this contestant.
         */
        public String getAuditionLocation() {
            return auditionLocation;
        }


        /**
         * Returns the score of this contestant.
         */
        public double getScore() {
            return score;
        }


        /**
         * Changes the score of this contestant to a specific value.
         */
        public void setScore(double newScore) {
            score = newScore;
        }
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
            ArrayList<String> auditionLocations,
            ArrayList<Double> scores) {
        ArrayList<Contestant> contestants = new ArrayList<Contestant>();
        for (int i = 0; i < names.size(); i++) {
            contestants.add(
                    new Contestant(names.get(i),
                                   auditionLocations.get(i),
                                   scores.get(i)));
        }
        return contestants;
    }



    /**
     * Problem 3: 200 points
     *
     * Takes an ArrayList containing all contestants, and creates a HashMap that
     * maps FROM location TO all contestants who auditioned there.
     *
     * For example, if allContestaints contained the following data:
     *   Taylor Swift, NYC, 5.0
     *   Nicki Minaj, NYC, 6.0
     *   Lil B, Oakland, 2.0
     *   Kendrick Lamar, LA, 7.0
     *
     * Then this function should return a HashMap with the following keys and values:
     *   NYC: [Taylor Swift, Nicki Minaj]
     *   Oakland: [Lil B]
     *   LA: [Kendrick Lamar]
     *
     * Such a HashMap lets us quickly look up all of the contestants that
     * auditioned at a particular location.
     *
     * Each value is an ArrayList of Contestants.
     *
     * Hint: first create an empty HashMap with all location keys:
     *   NYC:
     *   Oakland:
     *   LA:
     */
    public static HashMap<String, ArrayList<Contestant>> getLocationLookup(
            ArrayList<Contestant> allContestants) {
        // Step 1: create a new HashMap that's going to be your result
        HashMap<String, ArrayList<Contestant>> result =
                new HashMap<String, ArrayList<Contestant>>();

        // Step 2: add empty ArrayList<Contestant> entries for each possible location
        for (Contestant c : allContestants) {
            if (!result.containsKey(c.getAuditionLocation())) {
                ArrayList<Contestant> newEmpty = new ArrayList<Contestant>();
                result.put(c.getAuditionLocation(), newEmpty);
            }
        }

        // Step 3: go through allContestants and add each contestant to his/her
        // audition location ArrayList in your result
        for (Contestant c : allContestants) {
            result.get(c.getAuditionLocation()).add(c);
        }

        return result;
    }



    /**
     * Problem 4: 200 points
     *
     * Normalizes the scores of all contestants who auditioned in a location.
     *
     * This is a process of correcting for a specific judge's tendency to be
     * harsher or more leinient on the contestants he or she evaluated.
     *
     * How do we do this?
     * 1) Compute the mean of all scores (from a given location)
     * 2) Compute the standard deviation of all scores
     * 3) Subtract the mean from all scores, so that the mean score is now 0
     * 4) Divide all of the scores from (3) by the standard deviation
     *
     * After doing this calculation, update each contestant's score using the
     * setScore method to save the normalized score back to the Contestant
     * object.
     *
     * NOTE: all of the contestants passed in the contestantsInALocation
     * are from the same location!
     */
    public static void normalizeScoresByLocation(
            ArrayList<Contestant> contestantsInALocation) {
        // Copy the scores into an ArrayList<Double>
        ArrayList<Double> scores = new ArrayList<Double>();
        for (Contestant c : contestantsInALocation) {
            scores.add(c.getScore());
        }

        // Compute the mean of all scores
        double mean = getMean(scores);

        // Compute the standard deviation
        double stdDev = getStandardDeviation(scores);

        // Subtract the mean from all scores
        for (int i = 0; i < scores.size(); i++) {
            scores.set(i, scores.get(i) - mean);
        }

        // Divide all of the scores by the standard deviation
        for (int i = 0; i < scores.size(); i++) {
            scores.set(i, scores.get(i) / stdDev);
        }

        // Update each contestant's score
        for (int i = 0; i < contestantsInALocation.size(); i++) {
            contestantsInALocation.get(i).setScore(
                    scores.get(i));
        }
    }


    /**
     * DO NOT TOUCH
     * but feel free to use
     *
     * Helper functions to use in the above method.
     */
    private static double getMean(
            ArrayList<Double> numbers) {
        double total = 0.0;
        for (double d : numbers) {
            total += d;
        }
        return total / numbers.size();
    }

    private static double getStandardDeviation(
            ArrayList<Double> numbers) {
        double mean = getMean(numbers);
        double temp = 0;
        for (double d : numbers) {
            temp += Math.pow(d - mean, 2);
        }
        return Math.sqrt(temp / numbers.size());
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
     * DO NOT TOUCH
     *
     * Badly reads in a CSV file. Does not handle numerous edge cases
     * that a real CSV reader would handle.
     */
    static void badlyReadCsvFile(String fileName, ArrayList<String> names,
            ArrayList<String> auditionLocations, ArrayList<Double> scores) {
    }


    /**
     * DO NOT TOUCH
     *
     * The main function never gets run if you're only testing the code.
     *
     * If you've finished everything and want to test your program on test.csv, 
     * run "java Final test.csv".
     */
    public static void main(String[] args) {
        // DO NOT TOUCH: reads in the CSV-format spreadsheet specified by the
        // first command line argument
        if (args.length < 1) {
            System.out.println("Usage: java Final <SPREADSHEET_FILE_NAME>");
            return;
        }

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> auditionLocations = new ArrayList<String>();
        ArrayList<Double> scores = new ArrayList<Double>();
        badlyReadCsvFile(args[0], names, auditionLocations, scores);

        // Start processing the data from the spreadsheet
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
