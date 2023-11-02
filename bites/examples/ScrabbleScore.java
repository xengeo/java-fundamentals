package bites.examples;

import java.util.ArrayList;
import java.util.HashMap;

public class ScrabbleScore {

    static HashMap<String, Integer> letterValues = new HashMap<>();

    public static void main(String[] args) {
        letterValues.put("A", 1);
        letterValues.put("B", 3);
        letterValues.put("C", 3);
        letterValues.put("D", 2);
        letterValues.put("E", 1);
        letterValues.put("F", 4);
        letterValues.put("G", 2);
        letterValues.put("H", 4);
        letterValues.put("I", 1);
        letterValues.put("J", 8);
        letterValues.put("K", 5);
        letterValues.put("L", 1);
        letterValues.put("M", 3);
        letterValues.put("N", 1);
        letterValues.put("O", 1);
        letterValues.put("P", 3);
        letterValues.put("Q", 10);
        letterValues.put("R", 1);
        letterValues.put("S", 1);
        letterValues.put("T", 1);
        letterValues.put("U", 1);
        letterValues.put("V", 4);
        letterValues.put("W", 4);
        letterValues.put("X", 8);
        letterValues.put("Y", 4);
        letterValues.put("Z", 10);

        System.out.println(ScrabbleScore.calculate("EXQUISITELY"));

    }

    private static Integer calculate(String word) {
//        Takes a string and returns the scrabble score for the word as an integer
        Integer score = 0;
        char[] wordCharArray = word.toCharArray();
        String letter;

        for (int i = 0; i < wordCharArray.length; i++) {
            letter = String.valueOf(wordCharArray[i]);
            score += letterValues.get(letter);
        }
        return score;
    }


}
