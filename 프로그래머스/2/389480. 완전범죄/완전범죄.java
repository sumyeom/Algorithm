import java.util.*;
class Solution {
    static int[][][] dp;
    static int answer = Integer.MAX_VALUE;
    public static int solution(int[][] info, int n, int m) {
        // 누가 방문했는지 확인
        dp = new int[info.length][n+1][m+1];
        for(int [][] d1:dp){
            for(int[] d2:d1){
                Arrays.fill(d2, -1);
            }
        }
        answer = dfs(info, n, m,0,0,0);
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;
    }

    public static int dfs(int[][] info, int n, int m, int index, int aClue, int bClue){

        if (aClue >= n || bClue >= m) {
            return Integer.MAX_VALUE;
        }

        if (index == info.length) {
            return aClue;
        }
        
        if(dp[index][aClue][bClue] != -1) {
            return dp[index][aClue][bClue];
        }

        int takeA = dfs(info, n, m, index + 1, aClue + info[index][0], bClue);

        int takeB = dfs(info, n, m, index + 1, aClue, bClue + info[index][1]);
        
        return dp[index][aClue][bClue] = Math.min(takeA, takeB);
    }
}