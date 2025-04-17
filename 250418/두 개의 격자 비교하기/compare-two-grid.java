import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr1[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr2[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr1[i][j] == arr2[i][j]){
                    System.out.print(0 + " ");
                }else{
                    System.out.print(1 + " ");
                }

            }
            System.out.println();
        }
    }
}