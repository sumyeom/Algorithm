import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[K+1];
        dp[0] = 1;
        for(int i=0;i<N;i++){
            int c = cost[i];
            for(int j=c;j<=K;j++){
                dp[j] += dp[j-c];
            }
        }

        System.out.println(dp[K]);
    }
}
