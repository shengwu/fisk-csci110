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

    static final String[] american = {"gotten", "color", "honor", "center", /*"dialog",*/ "defense",
        "recognize", "hood", "trunk", "truck", "apartment", "worst", "first", "girl"};
    static final String[] british = {"got", "colour", "honour", "centre", "dialogue", "defence",
        "recognise", "bonnet", "boot", "lorry", "flat", "wust", "fust", "gul"};

    // Given sentences, converts all contained words in from to the equivalent in to.
    static boolean translate(ArrayList<String> sentences, String[] from, String[] to) {
        for (int i = 1; i < sentences.size(); ++i) {
            StringBuilder newSentence = new StringBuilder();
            String[] words = sentences.get(i).split(" ");
            for (int j = 1; j < words.length - 1; ++j) {
                // translate words
                for (int k = 0; k < american.length; ++k) {
                    if (from[k].equals(words[j])) {
                        words[j + 1] = to[k];
                    }
                    if ((from[k] + ",").equals(words[j])) {
                        words[j + 1] = to[k] + ",";
                    }
                    if ((from[k] + ".").equals(words[j])) {
                        words[j + 1] = to[k] + ".";
                    }
                }
            }

            // Add back the space between words and the word.
            if (newSentence.length() > 0) {
                newSentence.append("");
            }
            newSentence.append(words[j]);
        }
        sentences.set(i - 1, newSentence.toString());
    }
}

    // reverses the input word, removes the middle letter and vowels, and returns it.
    static String flipWordMinusMiddleAndVowels(String input) {
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = characters.length - 1; i > 0; --i) {
            if (i == characters.length / 2) {
                continue;
            }
            char letter = characters[i - 1];
            if (letter == 'a' || letter == 'e' || input.charAt(i) == 'i'
                    || letter == 'o' || input.charAt(i) == 'u') {
                continue;
            }
            result.append(letter);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> paragraph = new ArrayList<String>();
        paragraph.add("I raised my hood, poured in oil and dropped the can in my trunk.");
        paragraph.add("I then drove my truck to the first apartment tired.");
        paragraph.add("I recognize the red color but have gotten used to it.");
        paragraph.add("We had the worst dialog in defense of my honor at that center.");
        translate(paragraph, american, british);
        System.out.println(paragraph);
        translate(paragraph, british, american);
        System.out.println(paragraph);


        System.out.println(flipWordMinusMiddleAndVowels("muddled"));  // should print dldm
    }
}
