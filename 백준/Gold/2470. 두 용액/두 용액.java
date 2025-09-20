
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[]arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        long[] answer = new long[2];
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        long min = Long.MAX_VALUE;

        while(left<right){
            long sum = arr[left] + arr[right];
            if(min > Math.abs(sum)){
                answer[0] = arr[left];
                answer[1] = arr[right];
                min = Math.min(min,Math.abs(arr[left] + arr[right]));
            }

            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(answer[0]+ " "+answer[1]);
    }

}