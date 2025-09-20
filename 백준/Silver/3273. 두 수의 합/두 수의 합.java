
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[]arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int X = sc.nextInt();
        int answer = 0;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            if(arr[left] + arr[right] == X){
                answer++;
                right--;
            }else if(arr[left] + arr[right] < X){
                left++;
            }else {
                right--;
            }
        }
        System.out.println(answer);
    }

}