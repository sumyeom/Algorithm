import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 1;
        while(a<=n){
            if(a%3==0){
                System.out.print(a+" ");
                
            }
            a++;
        }
    }
}