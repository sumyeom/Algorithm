import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        while(n<1000){
            if(n%2==0){
                n = n*3+1;
            }else{
                n = n*2+2;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}