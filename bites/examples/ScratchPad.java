package bites.examples;

import java.util.Arrays;
import java.util.HashMap;

public class ScratchPad {

    static HashMap<String, Integer[]> scores ; // K=TeamName, V=Score

    public static void main(String[] args) {
        scores = new HashMap<String, Integer[]>(3);

        // You need to explicitly tell Java the type of data, even in a method call
        scores.put("TheBestTeam", new Integer[] {100, 90, 20});

        scores.put("SuperBrains", new Integer[] {98, 72, 48});

        scores.put("OriginalTeamName", new Integer[] {61, 89, 56});

        System.out.println(Arrays.toString(scores.get("TheBestTeam")));
        System.out.println(Arrays.toString(scores.get("SuperBrains")));
        System.out.println(Arrays.toString(scores.get("OriginalTeamName")));

    }
}
