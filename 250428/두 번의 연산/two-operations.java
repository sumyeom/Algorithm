import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if(a%2==1){
            a = a+3;
        }

        if(a%3==0){
            a = a/3;
        }

        System.out.println(a);
    }
}