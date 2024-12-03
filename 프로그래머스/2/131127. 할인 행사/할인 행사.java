import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sum=0;
        for(int num:number){
            sum+= num;
        }
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<sum;i++){
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
        }
        
        if(isValid(map,want,number)){
            answer++;
        }
        
        for(int i=sum;i<discount.length;i++){
            String prev = discount[i-sum];
            map.put(prev,map.get(prev)-1);
            if(map.get(prev)==0){
                map.remove(prev);
            }
            
            String curr = discount[i];
            map.put(curr,map.getOrDefault(curr,0)+1);
            
            if(isValid(map,want,number)){
                answer++;
            }
        }
        return answer;
    }
    public boolean isValid(Map<String,Integer> map, String[] want, int[] number){
        for(int i=0;i<want.length;i++){
            if(map.getOrDefault(want[i],0)<number[i]){
                return false;
            }
        }
        return true;
    }
}