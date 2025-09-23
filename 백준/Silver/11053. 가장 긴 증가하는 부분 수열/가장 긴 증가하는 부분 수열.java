import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();

       int[] arr =  new int[N];
       int[] dp = new int[N];

       for(int i=0;i<N;i++){
           arr[i] = sc.nextInt();
       }

       int len = 0;
       for(int i=0;i<N;i++){
           dp[i] = 1;
           for(int j=0;j<i;j++){
               if(arr[j] < arr[i]) {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
               }
           }
           len = Math.max(len,dp[i]);
       }

       System.out.println(len);

    }
}