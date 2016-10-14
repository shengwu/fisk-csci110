import java.util.*;

// Fix all the bugs in this program.
//
// There are none in main.
// translate has 11.
// flipWordMinusMiddleAndVowels has 3.

// This program translates from American english spelling and pronunciation to
// British spelling to be pronounced by Americans.  It also performs the
// reverse conversion.  Additionally, this contains a silly method named
// flipWordMinusMiddleAndVowels.

class EnglishTranslator {

    // The string "dialog" was incorrectly commented out, causing many of the translated
    // words to be off since it made the american and british arrays misaligned.
    static final String[] american = {"gotten", "color", "honor", "center", "dialog", "defense",
        "recognize", "hood", "trunk", "truck", "apartment", "worst", "first", "girl"};
    static final String[] british = {"got", "colour", "honour", "centre", "dialogue", "defence",
        "recognise", "bonnet", "boot", "lorry", "flat", "wust", "fust", "gul"};

    // Given sentences, converts all contained words in from to the equivalent in to.
    //
    // BUG: return type should be void instead of boolean since we don't need
    // to return anything
    static void translate(ArrayList<String> sentences, String[] from, String[] to) {
        // BUG: i should start at 0
        for (int i = 0; i < sentences.size(); ++i) {
            StringBuilder newSentence = new StringBuilder();
            String[] words = sentences.get(i).split(" ");
            // BUG: j should start at 0
            // BUG: the condition should be j < words.length, not j < words.length - 1
            for (int j = 0; j < words.length; ++j) {
                // translate words
                // BUG: should use from.length in condition instead of american.length
                // since the "from" parameter doesn't necessarily refer to "american"
                for (int k = 0; k < from.length; ++k) {
                    if (from[k].equals(words[j])) {
                        // BUG: the index should be j, not j + 1
                        words[j] = to[k];
                    }
                    if ((from[k] + ",").equals(words[j])) {
                        // BUG: the index should be j, not j + 1
                        words[j] = to[k] + ",";
                    }
                    if ((from[k] + ".").equals(words[j])) {
                        // BUG: the index should be j, not j + 1
                        words[j] = to[k] + ".";
                    }
                }

                // BUG: There was an extra closing brace here, causing
                // the for loop with j to be prematurely terminated

                // Add back the space between words and the word.
                if (newSentence.length() > 0) {
                    // BUG: append a space instead of an empty String
                    newSentence.append(" ");
                }
                newSentence.append(words[j]);
            }
            // BUG: we should set the ith sentence, not the i-1 th
            sentences.set(i, newSentence.toString());
        }
    }

    // reverses the input word, removes the middle letter and vowels, and returns it.
    static String flipWordMinusMiddleAndVowels(String input) {
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        // BUG: condition should be i >= 0
        //
        // Alternatively, you could start i at characters.length instead, and continue
        // to reference charcaters[i-1] below. That would cause this to have
        // three total bugs instead of four.
        for (int i = characters.length - 1; i >= 0; --i) {
            if (i == characters.length / 2) {
                continue;
            }
            // BUG: should be characters[i] instead of characters[i-1]
            char letter = characters[i];
            // BUG: use letter instead of input.charAt(i)
            if (letter == 'a' || letter == 'e' || letter == 'i'
                    || letter == 'o' || letter == 'u') {
                continue;
            }
            result.append(letter);
        }
        // BUG: must call result.toString() to return a String because result is a StringBuilder
        return result.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> paragraph = new ArrayList<String>();
        paragraph.add("I raised my hood, poured in oil and dropped the can in my trunk.");
        paragraph.add("I then drove my truck to the first apartment tired.");
        paragraph.add("I recognize the red color but have gotten used to it.");
        paragraph.add("We had the worst dialog in defense of my honor at that center.");
        translate(paragraph, american, british);
        System.out.println(paragraph);
        // SHould print an ArrayList containing the original sentences.
        translate(paragraph, british, american);
        System.out.println(paragraph);


        System.out.println(flipWordMinusMiddleAndVowels("muddled"));  // should print dldm
    }
}
