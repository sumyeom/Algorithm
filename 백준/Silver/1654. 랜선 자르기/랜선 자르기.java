import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        StringTokenizer st = new StringTokenizer(inputLine);
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lines = new long[K];
        long left = 1;
        long right = 1;
        long answer = 0;
        for(int i=0;i<K;i++){
            lines[i] = Long.parseLong(br.readLine());
            right = Math.max(right, lines[i]);
        }

        while(left<=right){
            long mid =  (left+right)/2;
            long count = 0;
            for(long l : lines){
                count+= l/mid;
            }

            if(count >= N){
                answer = mid;
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }
}