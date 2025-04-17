import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        while( A <= B){
            System.out.print(A + " ");
            if(A%2==1){
                A*=2;
            }else{
                A+=3;
            }
        }
    }
}