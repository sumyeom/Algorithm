import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int min = a;
        min = Math.min(min,b);
        min = Math.min(min,c);

        if(a == min){
            System.out.print(1+" ");
        }else{
            System.out.print(0+" ");
        }

        if(a==b && b==c && a==c){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}