import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j] = sc.nextInt();
                sum[i][j] += sum[i][j-1] + arr[i][j];
            }
        }

        for(int m=0;m<M;m++){
            int x1,x2,y1,y2;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            int result = 0;
            for(int i=x1;i<=x2;i++){
                //int j=y2-y1-1 < 0 ? y2-1 : y2-y1-1;
                result += sum[i][y2] - sum[i][y1-1];
            }

            System.out.println(result);
        }

    }
}