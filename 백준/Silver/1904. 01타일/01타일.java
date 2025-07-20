import java.util.*;

/**
 * 백준 2580
 * DFS(백트래킹)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }


    public static int fibo(int n){
        int[] dp = new int[n+1];
        if(n==1 || n==2 ) return n;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]%15746 + dp[i-2]%15746;
        }
        return dp[n]%15746;
    }


}



