import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }

        dp[0] = Integer.MIN_VALUE;
        dp[1] = arr[1];
        if(N <= 1){
            System.out.println(dp[N]);
            return;
        }

        for(int i=2;i<=N;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], dp[i]+arr[i]);
        }

        Arrays.sort(dp);
        System.out.println(dp[N]);
    }

}