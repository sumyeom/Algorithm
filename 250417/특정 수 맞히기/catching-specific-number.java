import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        while(true){
            int num = sc.nextInt();
            if(num < 25){
                System.out.println("Higher");
            }else if(num > 25){
                System.out.println("Lower");
            }else if(num == 25){
                System.out.println("Good");
                break;
            }
        }
    }
}