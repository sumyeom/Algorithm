import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int cnt = 0;
        while(true){
            int num = sc.nextInt();

            if(20 > num || num > 29){
                break;
            }
            sum+=num;
            cnt++;
        }

        System.out.printf("%.2f",(double)sum/cnt);
    }
}