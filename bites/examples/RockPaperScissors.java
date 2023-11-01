package bites.examples;

import java.util.HashMap;

public class RockPaperScissors {

//    defining the hashmap rules variable
    static HashMap<String, HashMap<String, String>> rules = new HashMap<String, HashMap<String, String>>();

//    main method
    public static void main(String[] args) {

        rules.put("rock", new HashMap<String, String>());
        rules.get("rock").put("paper", "player 2 wins");
        rules.get("rock").put("scissors", "player 1 wins");
        rules.get("rock").put("rock", "it's a draw");

        rules.put("paper", new HashMap<String, String>());
        rules.get("paper").put("paper", "it's a draw");
        rules.get("paper").put("scissors", "player 2 wins");
        rules.get("paper").put("rock", "player 1 wins");

        rules.put("scissors", new HashMap<String, String>());
        rules.get("scissors").put("paper", "player 1 wins");
        rules.get("scissors").put("scissors", "it's a draw");
        rules.get("scissors").put("rock", "player 2 wins");

        System.out.println(rules.get("rock").get("paper"));
        System.out.println(rules.get("rock").get("scissors"));
        System.out.println(rules.get("paper").get("scissors"));
        System.out.println(rules.get("scissors").get("scissors"));
    }
}
