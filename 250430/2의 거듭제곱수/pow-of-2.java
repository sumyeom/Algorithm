import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        while(n>1){
            n /= 2;
            cnt++;
        }
        System.out.println(cnt);
    }
}