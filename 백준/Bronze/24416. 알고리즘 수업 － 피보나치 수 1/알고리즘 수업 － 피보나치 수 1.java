import java.util.*;

/**
 * 백준 2580
 * DFS(백트래킹)
 */
public class Main {
    static int answer1 = 0;
    static int answer2 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo1(n);
        fibo2(n);
        System.out.println(answer1 + " " + answer2);
    }

    public static int fibo1(int n){
        if(n == 1 || n == 2){
            answer1++;
            return 1;
        }
        return fibo1(n-1) + fibo1(n-2);
    }

    public static int fibo2(int n){
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<=n;i++){
            dp[n] = dp[n-1] + dp[n-2];
            answer2++;
        }

        return dp[n];
    }


}



