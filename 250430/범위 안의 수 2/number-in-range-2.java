import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int cnt = 0;
        for(int i=0;i<10;i++){
            int num = sc.nextInt();
            if(0<= num && num<=200){
                cnt++;
                sum+=num;
            }
        }

        System.out.printf(sum+ " %.1f", (double)sum/cnt);
    }
}