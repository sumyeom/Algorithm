import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int j=0;j<N;j++){
            if(j%2==0){
                for(int i=0,k=1;i<N;i++,k++){
                    arr[i][j] = k;
                }
            }else{
                for(int i=N-1,k=1;i>=0;i--,k++){
                    arr[i][j] = k;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}