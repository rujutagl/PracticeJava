import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        String currBest = "";
        HashMap<String, Integer> map = new HashMap<>();
        map.put(currBest, 0);
        for(int i = 0; i< competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            int result = results.get(i);
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winner = (result == 1) ? homeTeam:awayTeam;
            updateScore(winner, 3, map);
            if(map.get(winner) > map.get(currBest)){
                currBest= winner;
            }
        }
        return currBest;
    }

    public void updateScore(String winner, int points, HashMap<String, Integer> map){
        if(!map.containsKey(winner)){
            map.put(winner,0);
        }
        map.put(winner, map.get(winner) + points);
    }
}
