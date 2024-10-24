import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int[] intArr = new int[str.length];
        for(int i=0;i<str.length;i++){
            intArr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(intArr);
        answer += intArr[0] +" ";
        answer += intArr[intArr.length-1];
        return answer;
    }
}