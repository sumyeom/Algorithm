import java.util.Arrays;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i=1;i<=N;i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        int[] dp = new int[N+2];
        int max = 0;
        for(int i=1;i<=N;i++){
            // 선택안했을 때
            dp[i] = Math.max(dp[i-1], dp[i]);

            if(i+T[i] < N+2){
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }
            max = Math.max(max, dp[i]);
        }

        max = Math.max(max, dp[N+1]);

        System.out.println(max);
    }
}