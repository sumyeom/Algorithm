import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a<b){
            System.out.print("1 ");
        }else if(a>=b){
            System.out.print("0 ");
        }
        if(a==b){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}