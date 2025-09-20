import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) ->  a[1] - b[1]);

        int end = 0;
        for (int i = 0; i < targets.length; i++) {
            int s =  targets[i][0];
            int e = targets[i][1];

            if(s < end){
                continue;
            }else{
                end = e;
                answer++;
            }
        }
        return answer;
    }
}