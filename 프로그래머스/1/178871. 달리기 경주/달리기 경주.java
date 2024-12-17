import java.util.*;
import java.util.Map.Entry;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        
        for(int i=0;i<callings.length;i++){
            String runner = callings[i];
            
            int num = map.get(runner);
            if(num == 0 ){
                continue;
            }
            
            String frontplayer = players[num-1];
            
            players[num-1] = runner;
            players[num] = frontplayer;
            
            map.put(runner, num-1);
            map.put(frontplayer, num);
        }

        
        return players;
    }
}