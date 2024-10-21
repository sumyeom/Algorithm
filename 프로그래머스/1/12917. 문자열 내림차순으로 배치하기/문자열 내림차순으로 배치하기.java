import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list = String.valueOf(s).split("");
        Arrays.sort(list);
        for(int i=list.length-1;i>=0;i--){
            
            System.out.println(list[i]);
            answer += list[i];
        }
        return answer;
    }
}