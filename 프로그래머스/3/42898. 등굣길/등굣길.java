class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][]map = new int[n+1][m+1];
        int[][]dp = new int[n+1][m+1];
        for(int i=0;i<puddles.length;i++){
            int[] pos = puddles[i];
            map[pos[1]][pos[0]] = 1;
        }

        dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(map[i][j]==1 || (i==1&&j==1)) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1] )%1000000007;
            }
        }

        return dp[n][m] ;
    }
}