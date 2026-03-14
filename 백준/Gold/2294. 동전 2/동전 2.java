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
        int INF = 1_000_000_000;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=0;i<N;i++){
            int c = cost[i];
            for(int j=c;j<=K;j++){
                dp[j] = Math.min(dp[j-c]+1,dp[j]);
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}
