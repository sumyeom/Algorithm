import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            int input = sc.nextInt();
            int left = 0;
            int right = N-1;
            boolean check = false;
            while(left <= right){
                int mid = (left + right) / 2;
                if(input == A[mid]) {
                    check = true;
                    break;
                }else if(input > A[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(check){
                System.out.println(1);
            }else{
                System.out.println(0);
            }

        }
    }
}