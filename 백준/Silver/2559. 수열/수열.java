import java.util.Arrays;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i=0;i<K;i++){
            sum += arr[i];
        }

        int max = sum;
        for(int oldN=0, newN=K; newN <N;oldN++, newN++){
            sum = sum + arr[newN] - arr[oldN];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}