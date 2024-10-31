import java.util.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        String numStr = Integer.toString(x);
        int sum = 0;
        for(char ch : numStr.toCharArray()){
            sum += Character.getNumericValue(ch);
        }
        if(x % sum == 0){
            answer = true;
        }
        return answer;
    }
}