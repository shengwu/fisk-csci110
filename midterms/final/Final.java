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
 * Having so many auditions presents a few challenges:
 * - selecting contestants by hand would take forever!
 * - people who auditioned in some places might be at a disadvantage
 *   because judges there graded more harshly than judges elsewhere
 *
 * In this exam, you'll write a series of functions to automatically process a
 * year's worth of audition data. A few hundred sample auditions been included
 * in a file named example.csv. The code you write should work for any other
 * similarly formatted file, including ones that have thousands of entries.
 *
 * Use the tests in FinalTest.java to test your code with JUnit.
 * (instructions at http://sheng.io/fisk)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Final {

    /**
     * Problem 1: 200 points
     *
     * Describes a contestant. Contestants have a name, audition location, and
     * score.
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
     * information. The name, audition location, and score at index i are for
     * the same contestant.
     *
     * Hint: think about how you would do this for one Contestant:
     *
     * String name = "LeBron James";
     * String auditionLocation = "Akron";
     * double score = -10.0;
     * Contestant c = new Contestant(name, auditionLocation, score);
     */
    public static ArrayList<Contestant> getContestantList(
            ArrayList<String> names,
            ArrayList<String> auditionLocations,
            ArrayList<Double> scores) {
        // TODO
        return new ArrayList<Contestant>();
    }



    /**
     * Problem 3: 200 points
     *
     * Takes an ArrayList containing all contestants, and creates a HashMap that
     * maps from LOCATION (key) to LIST OF CONTESTANTS WHO AUDITIONED THERE (value).
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
     * Hints:
     *
     * First create an empty HashMap with all location keys:
     *   NYC:
     *   Oakland:
     *   LA:
     *
     * Each value in the HashMap is an ArrayList of Contestants, which you'll
     * have to initialize.
     */
    public static HashMap<String, ArrayList<Contestant>> getLocationLookup(
            ArrayList<Contestant> contestants) {
        // TODO
        return new HashMap<String, ArrayList<Contestant>>();
    }



    /**
     * Problem 4: 200 points
     *
     * Normalizes the scores of a list of contestants.
     *
     * This corrects for a specific judge's tendency to be harsher or more
     * leinient on the contestants he or she evaluated.
     *
     * How do we do this?
     * 1) Compute the mean of the scores
     * 2) Compute the standard deviation of the scores
     * 3) Subtract the mean from each score (so that the mean score is now 0)
     * 4) Divide each score by the standard deviation
     *
     * After doing this calculation, update each contestant's score using the
     * setScore method to save the normalized score back to the Contestant
     * object.
     *
     * For example, given contestants with the following scores:
     *
     * 5.0, 10.0, 15.0
     *
     * The mean is 10.0
     * The standard deviation is 5
     * Subtracting the mean from each score, we get:
     *
     * -5.0, 0.0, 5.0
     *
     * Dividing by the standard deviation, the contestants would have
     * the updated scores:
     *
     * -1.0, 0.0, 1.0
     */
    public static void normalizeScores(ArrayList<Contestant> contestants) {
        // TODO
    }


    /**
     * Helper functions for you to use in the above method.
     *
     * Tip: don't modify these.
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
            normalizeScores(contestantsHere);

            // Adds all of these contestants to our result
            normalizedContestants.addAll(contestantsHere);
        }
        return normalizedContestants;
    }



    /**
     * Problem 5: 200 points
     *
     * Returns the names of the top 10 contestants in 'contestants' from
     * best to worst. Higher scores are better.
     *
     * It's fine to modify 'contestants'.
     */
    public static ArrayList<String> getTop10(ArrayList<Contestant> contestants) {
        // TODO
        return new ArrayList<String>();
    }



    /**
     * Extra credit: 200 points
     *
     * Goes through all of the contesstants and determines the top 3
     * contestants for each location (from best to worst).
     *
     * Hint: you can use getLocationLookup() and getTop10() to help
     * you write this function.
     *
     * An example of what this function would return:
     *
     * NYC: Sam Smith, Nicki Minaj, Taylor Swift
     * Oakland: Kevin Durant, Stephen Curry, Lil B
     */
    public static HashMap<String, ArrayList<String>> getTop3ByLocation(ArrayList<Contestant> contestants) {
        // TODO
        return new HashMap<String, ArrayList<String>>();
    }










    /**
     * DO NOT TOUCH
     *
     * THIS IS TERRIBLE CSV PARSING CODE. Does not handle numerous edge cases
     * that a real CSV reader would handle.
     *
     * However, it works enough for the purposes of your final.
     */
    static void badlyReadCsvFile(String fileName, ArrayList<String> names,
          ArrayList<String> auditionLocations, ArrayList<Double> scores) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter(Pattern.compile("[\n,]"));
            // Skip the first line
            scanner.next();
            scanner.next();
            scanner.next();
            while (scanner.hasNext()) {
                names.add(scanner.next().trim());
                auditionLocations.add(scanner.next().trim());
                scores.add(Double.parseDouble(scanner.next().trim()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found: " + fileName);
            System.exit(0);
        }
    }


    /**
     * The main function never gets run if you're only testing the code.
     *
     * If you've finished everything and want to test your program on
     * example.csv, run "java Final example.csv" and you should see some
     * familiar names among the winners of the audition.
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

        // Start processing the data from the spreadsheet using your functions
        ArrayList<Contestant> allContestants = getContestantList(
                names, auditionLocations, scores);
        HashMap<String, ArrayList<Contestant>> contestantsByLocation =
                getLocationLookup(allContestants);
        ArrayList<Contestant> normalizedContestants =
                normalizeContestantScores(contestantsByLocation);

        // See who the winners are
        System.out.println("Top Ten Contestants:");
        System.out.println("--------------------");
        ArrayList<String> topTen = getTop10(normalizedContestants);
        for (int i = 0; i < topTen.size(); i++) {
            System.out.println((i+1) + ". " + topTen.get(i));
        }

        // Top 3 by location
        System.out.println("\n\nTop Three Contestants By Location:");
        System.out.println("----------------------------------");
        HashMap<String, ArrayList<String>> byLocation =
            getTop3ByLocation(normalizedContestants);
        for (String location : byLocation.keySet()) {
            System.out.println(location + ":");
            for (int i = 0; i < 3; i++) {
                System.out.println((i+1) + ". " + byLocation.get(location).get(i));
            }
            System.out.println();
        }
    }
}
