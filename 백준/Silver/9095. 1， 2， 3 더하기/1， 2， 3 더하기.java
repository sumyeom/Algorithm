import java.util.*;

/**
 * 백준 9095
 * dp
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int answer = 0;
            int inputNum = sc.nextInt();
            int[] dp = new int[15];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i=4;i<=inputNum;i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(dp[inputNum]);
        }
    }
}



