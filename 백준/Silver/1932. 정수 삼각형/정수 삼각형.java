import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] triangles = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                triangles[i][j] = sc.nextInt();
            }
        }

        dp[1][1] = triangles[1][1];
        for(int i=2;i<=N;i++){
            for(int j=1;j<=i;j++){
                if(j==1) {
                    dp[i][j] = triangles[i][j] + dp[i-1][j];
                }else if(j==i){
                    dp[i][j] = triangles[i][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = triangles[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int max = 0;
        for(int j=1;j<=N;j++){
            max = Math.max(max, dp[N][j]);
        }
        System.out.println(max);
    }

}