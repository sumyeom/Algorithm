import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num%2==1 && num%3==0){
                sum+=num;
            }
        }

        System.out.println(sum);
    }
}