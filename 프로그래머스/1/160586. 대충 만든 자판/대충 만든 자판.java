import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                char key = keymap[i].charAt(j);
                map.put(key, Math.min(map.getOrDefault(key, Integer.MAX_VALUE), j + 1));
            }
        }

        for(int i=0;i<targets.length;i++){
            int result = 0;
            String s = targets[i];

            for(char ch : s.toCharArray()){
                if(map.containsKey(ch)){
                    result += map.get(ch);
                }else{
                    result = -1;
                    break;
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}