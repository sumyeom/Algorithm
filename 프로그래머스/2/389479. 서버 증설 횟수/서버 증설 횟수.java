import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int currentServer = 0;
        
        
        for(int time = 0;time<players.length;time++){
            int playerCount = players[time];
            
            // 현재 시점에 만료된 서버 제거
            while(!queue.isEmpty() && queue.peek() <= time){
                currentServer--;
                queue.poll();
            }
            
            int needServer = 0;
            int requiredServer = 0;
            if(playerCount >= m){
                needServer = playerCount / m;
            }
            requiredServer = needServer - currentServer;
            if(requiredServer > 0){
                for(int i=0;i<requiredServer;i++){
                    queue.offer(time+k);
                }
                currentServer += requiredServer;
                answer += requiredServer;
            }
            
            
        }
        return answer;
    }
}