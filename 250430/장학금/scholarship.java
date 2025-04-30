import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a>=90){
            if(b>=95){
                System.out.println(100000);
            }else if(b>=90){
                System.out.println(50000);
            }else{
                System.out.println(0);
            }
        }else{
            System.out.println(0);
        }
    }
}