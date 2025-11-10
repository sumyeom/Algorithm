import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[info.length+1][m+1];
        for(int i=0;i<=info.length;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for(int i=1;i<=info.length;i++){
            for(int j=0;j<=m;j++){
                if(dp[i-1][j] == Integer.MAX_VALUE) continue;
                
                int prevA = dp[i-1][j];
                
                int na = prevA + info[i-1][0];
                if(na < n && j < m){
                    dp[i][j] = Math.min(dp[i][j], na);
                }
                
                int nb = j + info[i-1][1];
                if(nb < m && prevA < n){
                    dp[i][nb] = Math.min(dp[i][nb], prevA);
                }
                
             }
        }
        
        for(int j=0;j<=m;j++){
            answer = Math.min(answer, dp[info.length][j]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer ;
    }
}