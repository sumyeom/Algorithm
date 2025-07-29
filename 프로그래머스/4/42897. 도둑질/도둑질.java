import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length+1];
        dp[1] = money[0];
        dp[2] = Math.max(money[0], money[1]);
        //첫번째 집 털때
        for(int i=3;i<money.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i-1]);
            answer = Math.max(dp[i], answer);
        }
        Arrays.fill(dp,0);
        dp[2] = money[1];
        for(int i=3;i<=money.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i-1]);
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}