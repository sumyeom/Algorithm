import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N+1][10];

        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=N;i++){
            for(int j=0;j<=9;j++){
                if(j-1<0){
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }else if(j+1>=10){
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        long answer = 0;
        for(int i=0;i<=9;i++){
            answer = (answer + dp[N][i]) % 1000000000;
        }

        System.out.println(answer);
    }

}