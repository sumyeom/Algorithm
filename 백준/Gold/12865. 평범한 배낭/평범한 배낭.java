import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] W = new int[N];
        int[] V = new int[N];

        for(int i=0;i<N;i++){
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        int[] dp = new int[K+1];
        int max = 0;

        for (int n = 0; n < N; n++) {
            for (int i = K; i >= W[n]; i--) {
                dp[i] = Math.max(dp[i], dp[i - W[n]] + V[n]);
            }
        }
        System.out.println(dp[K]);
    }
}