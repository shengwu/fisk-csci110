/**
 * Assignment 6: HashMaps
 * Due: Monday, Nov 14 at 11:59 pm
 *
 * This assignment lets you practice HashMaps and sorting.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Assignment6 {

    /**
     * Problem 1: 10 points
     *
     * Fills a HashMap with the numbers 1 through 100 as keys, and whether
     * a given number is divisible by 3 as values.
     *
     * The first several elements should be:
     *     1: false
     *     2: false
     *     3: true
     *     4: false
     *     5: false
     *     6: true
     */
    public HashMap<Integer, Boolean> enumerateDivisibleBy3() {
        HashMap<Integer, Boolean> result = new HashMap<Integer, Boolean>();
        for (int i = 1; i <= 100; i++) {
            result.put(i, i % 3 == 0);
        }
        return result;
    }




    /**
     * Problem 2: 10 points
     *
     * Counts the occurrences of uppercase As, Bs, and Cs in 's'. The HashMap
     * should not contain entries for any other letters.
     *
     * Example: if given the string "BALLOON", this function should return a
     * HashMap containing:
     *     A: 1
     *     B: 1
     */
    public HashMap<Character, Integer> countAsBsandCs(String s) {
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A' || c == 'B' || c == 'C') {
                if (result.containsKey(c)) {
                    result.put(c, result.get(c) + 1);
                } else {
                    // it wasn't already in there
                    result.put(c, 1);
                }
            }
        }
        return result;
    }



    /**
     * Problem 3: 10 points
     *
     * Returns true if 's' contains at least 10 distinct letters. This method
     * should be case-sensitive (i.e. uppercase letters are distinct from
     * lowercase letters).
     *
     * For example, 'hellohello' would result in false because
     * it only has 4 distinct letters: h, e, l, and o
     *
     * Hint: what are methods that you can use to count how many entries
     * are in a HashMap?
     */
    public boolean hasAtLeast10Distinct(String s) {
        HashMap<Character, Boolean> result = new HashMap<Character, Boolean>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result.put(c, true);
        }
        return result.keySet().size() >= 10;
    }



    /**
     * Problem 4: 10 points
     *
     * Compresses a sequence of coin tosses. Each run of heads (H) or tails (T)
     * should be replaced by the letter and then the number of occurrences right
     * after.
     *
     * For example, the sequence of coin tosses "HHHTTTTTH" would be compressed
     * as "H3T5H1".
     *
     * Hint: this is an example of a problem where it's not helpful to use a
     * HashMap.
     */
    public String compressCoinTosses(String coinTosses) {
        if (coinTosses.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char curr = coinTosses.charAt(0);
        int currCount = 1;
        for (int i = 1; i < coinTosses.length(); i++) {
            char c = coinTosses.charAt(i);
            if (c == curr) {
                currCount++;
            } else {
                // we have a new letter!
                // save the previous letter and its count to the result
                result.append(curr);
                result.append(currCount);
                // reset curr and currCount since we have a new letter
                curr = c;
                currCount = 1;
            }
        }
        // save whatever we were doing last
        result.append(curr);
        result.append(currCount);
        return result.toString();
    }



    /**
     * Problem 5: 10 points
     *
     * Creates a lookup table from zip codes to cities. The ith zip code in
     * 'zipCodes' matches the ith city in 'cities'.
     *
     * For example, if given zipCodes = ["74074", "37219"] and cities =
     * ["Stillwater, OK", "Nashville, TN"], this function should return
     * HashMap with the following key-value pairs:
     *   74074: Stillwater, OK
     *   37219: Nashville, TN
     */
    public HashMap<String, String> createZipLookup(ArrayList<String> zipCodes,
            ArrayList<String> cities) {
        HashMap<String, String> zipToCity = new HashMap<String, String>();
        for (int i = 0; i < zipCodes.size(); i++) {
            zipToCity.put(zipCodes.get(i), cities.get(i));
        }
        return zipToCity;
    }



    /**
     * Problem 6: 20 points
     *
     * Returns true if all of the words in 'sentence' are valid words.
     * 'dictionary' is a provided HashSet that contains all of the valid
     * words for a particular dictionary.
     *
     * You can think of HashSets like HashMaps that don't have any values.
     * They're useful because you can check for the presence of keys. See the
     * HashSet documentation here:
     * https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html
     *
     * Example: if 'sentence' is 'happy dog cat' and 'dictionary' is ['dog', 'cat'],
     * the function should return false because happy is not in the dictionary.
     *
     * Hint: use the split() method in the String class to break up 'sentence'
     * into individual words.
     * http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String)
     */
    public boolean allValidWords(String sentence, HashSet<String> dictionary) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!dictionary.contains(words[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Problem 7: 10 points
     *
     * 'stateToCities' is a HashMap where the keys are state abbreviations
     * and the values are lists of cities in that state. This function takes
     * that HashMap and creates a new, simpler version where the keys are
     * state abbreviations and the values are how many cities were in the list.
     *
     * For example, if 'stateToCities' was:
     *   'AK': ['Anchorage', 'Juneau']
     *   'NY': ['Albany', 'NYC', 'Syracuse']
     *
     * then the function should return:
     *   'AK': 2
     *   'NY': 3
     */
    public HashMap<String, Integer> countCities(
            HashMap<String, ArrayList<String>> stateToCities) {
        HashMap<String, Integer> cityCounts = new HashMap<String, Integer>();
        for (String city : stateToCities.keySet()) {
            cityCounts.put(city, stateToCities.get(city).size());
        }
        return cityCounts;
    }




    /**
     * Used for problem 8. Do not change.
     */
    public class Dog {
        private double tailWag;

        public Dog(double tailWag) {
            this.tailWag = tailWag;
        }

        public double getTailWag() {
            return tailWag;
        }
    }

    /**
     * Problem 8: 20 points
     *
     * Sorts an array of Dogs in descending order by tailWag. Uses selection sort
     * sort (no use of built-in or other prewritten sorting libraries allowed).
     */

    void swap(Dog[] dogs, int a, int b) {
        Dog tmp = dogs[a];
        dogs[a] = dogs[b];
        dogs[b] = tmp;
    }

    public void sort(Dog[] dogs) {
        for (int i = 1; i < dogs.length; i++) {
            Dog curr = dogs[i];
            // Insert it in the appropriate place in the sorted portion
            for (int j = i-1; j >= 0; j--) {
                if (curr.getTailWag() > dogs[j].getTailWag()) {
                    // If the one we're looking at 
                    dogs[j+1] = dogs[j];
                } else {
                    // put the dog in the j+1st spot (where we just made room)
                    dogs[j+1] = curr;
                    break;
                }
            }
        }
    }




    /**
     * EXTRA CREDIT: 12 points
     *
     * Badly hashes a String by returning the product of its ASCII character values
     * mod 'mod'.
     *
     * Example: given "hello" and 566, this function would return 156 which is
     * (104 * 101 * 108 * 108 * 111) % 566
     *
     * Hint: you'll quickly run into overflow problems (the numbers you're
     * multiplying will quickly become too large to fit into an int, which
     * turns the int negative). To solve this, use this property:
     *   (a mod n)(b mod n) == ab mod n
     * https://en.wikipedia.org/wiki/Modular_arithmetic#Remainders
     *
     * Why is this hash bad? Because by using the product of the char values,
     * a String like "abc" will hash to the same value as "cba".
     */
    public int badHash(String s, int mod) {
        int acc = 1;
        for (int i = 0; i < s.length(); i++) {
            acc = (acc * s.charAt(i)) % mod;
        }
        return acc;
    }

}
