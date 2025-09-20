
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[]arr = new int[N];
        long S = sc.nextLong();
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }


        int left = 0;
        int right = 0;
        long sum = arr[0];
        int minLen = Integer.MAX_VALUE;

        while(right<N){
            if(sum >= S){
                if(minLen > (right-left+1)){
                    minLen = right-left+1;
                }
                if(left >= right){
                    break;
                }
                sum -= arr[left++];
            }else{
                right++;
                if(right<N)sum+=arr[right];
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? 0: minLen);
    }

}