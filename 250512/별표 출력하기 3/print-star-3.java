import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=N,k=0;i>0;i--,k++){
            for(int j=0;j<k;j++){
                System.out.print("  ");
            }
            for(int j=0;j<2*i-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}