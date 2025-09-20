import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) ->  a[1] - b[1]);
        double first = targets[0][1] - 0.3;
        answer++;
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] < first && first < targets[i][1]) {
                continue;
            }else{
                first = targets[i][1] - 0.3;
                answer++;
            }
        }
        return answer;
    }
}