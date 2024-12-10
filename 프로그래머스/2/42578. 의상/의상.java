import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        int comb = 1;
        for(int count : map.values()){
            comb *= (count+1);
        }
        
        
        
        
        return comb-1;
    }
}