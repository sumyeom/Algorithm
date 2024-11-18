import java.util.*;
class Solution {
    public int solution(int n) {
        long answer = 0;
        long temp = (long)n;
        ArrayList<Long> list = new ArrayList<Long>();
        while(true){
            if(temp == 0 ){
                break;
            }
            list.add((long)temp%3);
            temp = temp/3;
        }
        int mul = 1;
        for(int i=list.size()-1;i>=0;i--){
            answer += list.get(i)*mul;
            mul *=3;
        }
        System.out.println(list.toString());
        return (int)answer;
    }
}