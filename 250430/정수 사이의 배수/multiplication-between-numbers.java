import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        int sum = 0;
        for(int i = a;i<=b;i++){
            if(i%5==0 || i%7==0){
                cnt++;
                sum+=i;
            }
        }

        System.out.printf(sum +" " + "%.1f",(double)sum/cnt);
    }
}