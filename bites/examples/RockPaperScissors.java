package bites.examples;

import java.util.HashMap;

public class RockPaperScissors {

    static HashMap<String, HashMap<String, String>> rules = new HashMap<String, HashMap<String, String>>();

    public static void main(String[] args) {

        HashMap<String, String> rockOutcomes = new HashMap<String, String>();
        rockOutcomes.put("rock", "draw");
        rockOutcomes.put("paper", "player two wins");
        rockOutcomes.put("scissors", "player one wins");

        HashMap<String, String> paperOutcomes = new HashMap<String, String>();
        paperOutcomes.put("rock", "player one wins");
        paperOutcomes.put("paper", "draw");
        paperOutcomes.put("scissors", "player two wins");

        HashMap<String, String> scissorsOutcomes = new HashMap<String, String>();
        scissorsOutcomes.put("rock", "player two wins");
        scissorsOutcomes.put("paper", "player one wins");
        scissorsOutcomes.put("scissors", "draw");

        rules.put("rock", rockOutcomes);
        rules.put("papper", paperOutcomes);
        rules.put("scissors", scissorsOutcomes);

        String outcome = rules.get("rock").get("paper");
        System.out.println(outcome);
    }
}
