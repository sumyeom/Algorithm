import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            int num = sc.nextInt();
            if(num % 3 != 0){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}