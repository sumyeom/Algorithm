import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6,1);
        map.put(5,2);
        map.put(4,3);
        map.put(3,4);
        map.put(2,5);
        map.put(1,6);
        map.put(0,6);
        
        int zeroCnt = 0;
        int correctCnt = 0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                zeroCnt++;
            }
        }
        for(int i=0;i<win_nums.length;i++){
            for(int j=0;j<lottos.length;j++){
                if(win_nums[i]==lottos[j]){
                    correctCnt++;
                }
            }
        }
        answer[0] = map.get(correctCnt + zeroCnt);
        answer[1] = map.get(correctCnt);
        
        return answer;
    }
}