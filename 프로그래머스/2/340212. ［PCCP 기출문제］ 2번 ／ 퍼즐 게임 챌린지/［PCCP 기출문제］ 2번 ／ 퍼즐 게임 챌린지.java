import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;

        int left = 1;
        int right = 100000;
        while(left < right){
            int level = (left + right) / 2;
            long sumTimes =0;
            sumTimes += times[0];
            for(int i=1;i<diffs.length;i++){
                if(diffs[i] <= level){
                    sumTimes += times[i];
                }else {
                    sumTimes += (long)(diffs[i] - level) * (times[i] + times[i - 1]) + times[i];

                }
            }
            if(sumTimes<=limit){
                right = level;
            }else{
                left = level + 1;
            }
        }
        answer = left;
        return answer;
    }
}