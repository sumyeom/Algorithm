import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        // ArrayDeque로 goal 큐가 다 빠질때까지확인
        ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));
        
        while(!goalQueue.isEmpty()){
            if(!queue1.isEmpty() && queue1.peekFirst().equals(goalQueue.peekFirst())){
                queue1.pollFirst();
                goalQueue.pollFirst();
            }else if(!queue2.isEmpty() && queue2.peekFirst().equals(goalQueue.peekFirst())){
                queue2.pollFirst();
                goalQueue.pollFirst();
            }else{
                break;
            }
        }
        if(goalQueue.isEmpty()){
            
            answer = "Yes";
        }
        
        return answer;
    }
}