import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=2;i<=Math.sqrt(N);i++){
            if(N%i==0){
                System.out.println("C");
                return;
            }
        }
        System.out.println("P");
    }
}