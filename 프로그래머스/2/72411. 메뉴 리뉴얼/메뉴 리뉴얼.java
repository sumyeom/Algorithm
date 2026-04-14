import java.util.*;
class Solution {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int c : course){
            map = new HashMap<>();
            for(String order : orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                comb(arr,"",0,0,c);
            }
            
            int max = 0;
            for(int count : map.values()){
                if(count >= 2){
                    max = Math.max(max, count);
                }
            }

            for(String str : map.keySet()){
                if(map.get(str) >= max && max >= 2){
                    answer.add(str);
                }
            }
            
            
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void comb(char[] arr, String str, int idx, int depth, int target){
        // 종료 조건
        if(depth == target){
            map.put(str, map.getOrDefault(str, 0)+1);
            return;
        }
        
        // 재귀로 조합 찾기
        for(int i=idx; i<arr.length;i++){
            comb(arr, str+arr[i], i+1, depth+1, target);
        }
    }
}