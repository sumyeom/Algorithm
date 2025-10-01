import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputA = br.readLine();
        String inputB = br.readLine();

        char[] arrA = new char[inputA.length()+1];
        char[] arrB = new char[inputB.length()+1];
        int[][] dp =  new int[inputA.length()+1][inputB.length()+1];

        for(int i =1;i<=inputA.length();i++){
            arrA[i] = inputA.charAt(i-1);
        }

        for(int i =1;i<=inputB.length();i++){
            arrB[i] = inputB.charAt(i-1);
        }

        for(int i=1;i<=inputA.length();i++){
            for(int j=1;j<=inputB.length();j++){
                if(arrA[i] == arrB[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[inputA.length()][inputB.length()]);
    }
}