import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char start_s ;
        int cntS= 0;
        int cntA = 0;
        int index = 0;
        start_s = s.charAt(index);
        cntS++;
        while(true){
            index++;
            if(index>=s.length()-1 && s.length()>=1){
                answer++;
                break;
            }
            if(start_s == s.charAt(index)){
                cntS++;
            }else{
                cntA++;
            }
            if(cntS == cntA){
                answer++;
                s = s.substring(index+1,s.length());
                cntA=0;
                index=0;
                
                start_s = s.charAt(index);
                cntS=1;
            }
            else{
                if(index>=s.length() && s.length()>=1){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}