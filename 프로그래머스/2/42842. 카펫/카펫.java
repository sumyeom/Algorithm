import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int height=1;height<=Math.sqrt(total);height++){
            if(total % height ==0){
                int width = total / height;
                
                if((height - 2) * (width - 2) == yellow){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }        
        }
        

        
        return answer;
    }
}