import java.util.*;
class Solution {
    public int solution(int n) {
        String answer = "";
        while(n>0){
            answer = answer + n%3;
            n /=3;
            System.out.println(answer);
        }
        return Integer.parseInt(answer,3);
    }
}