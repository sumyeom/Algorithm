import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for(int i=0;i<N;i++){
            numbers[i] = sc.nextInt();
        }
        for(int i=0;i<4;i++){
            operator[i] = sc.nextInt();
        }

        dfs(1,numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int n, int result){
        if(n>=N){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i=0; i<4;i++) {
            if(operator[i] > 0){
                operator[i]--;
                dfs(n+1, calculate(result, numbers[n], i));
                operator[i]++;
            }

        }
    }

    public static int calculate(int a, int b, int op){
        switch(op){
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a < 0 ? -(-a / b) : a / b;
        }
        return 0;
    }

}



