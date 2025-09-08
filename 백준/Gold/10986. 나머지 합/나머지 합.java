import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int M = sc.nextInt();



        long[] sum = new long[N+1];

        long prefixSum = 0;

        for(int i=1;i<=N;i++){

            prefixSum+=sc.nextInt();

            sum[i] = prefixSum;

        }



        long[] count = new long[M];

        for(int i=0;i<=N;i++){

            int remainder = (int) (sum[i] % M);

            count[remainder]++;

        }



        long result = 0;

        for(int i=0;i<M;i++){

            if(count[i]>1){

                result += (count[i] * (count[i]-1))/2;

            }

        }

        System.out.println(result);

    }

}