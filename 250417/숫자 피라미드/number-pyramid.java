import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1;i<=N;i++){
            for(int j = 0;j<i;j++){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
}