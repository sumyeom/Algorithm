import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            for(int j=N-1;j>i;j--){
                System.out.print("  ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("@ ");
            }
            System.out.println();
        }

        for(int i=N-1,k=0;i>0;i--,k++){
            for(int j=0;j<i;j++){
                System.out.print("@ ");
            }
            System.out.println();
        }
    }
}