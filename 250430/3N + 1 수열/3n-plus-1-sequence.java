import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while(n>1){
            if(n%2==0){
                n%=2;
            }else{
                n = n*3+1;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}