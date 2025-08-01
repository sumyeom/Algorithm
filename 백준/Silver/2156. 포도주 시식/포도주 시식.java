import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] wine = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            wine[i] = sc.nextInt();
        }

        dp[1] = wine[1];
        if(N==1) {
            System.out.println(dp[N]);
            return;
        }
        dp[2] = wine[1] + wine[2];
        if(N==2) {
            System.out.println(dp[N]);
            return;
        }
        dp[3] = Math.max(wine[1]+wine[2] , Math.max(wine[2]+wine[3], wine[1]+wine[3]));
        if(N==3) {
            System.out.println(dp[N]);
            return;
        }
        int max = 0;
        for(int i=4;i<=N;i++){
            dp[i] = Math.max(dp[i-1] , Math.max(dp[i-2]+wine[i], dp[i-3] + wine[i-1] + wine[i]));
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}