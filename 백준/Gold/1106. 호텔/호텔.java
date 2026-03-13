import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] people = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int max = C + 100;
        int INF = 1_000_000_000;

        int[] dp = new int[max+1];

        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=0;i<N;i++){
            int c = cost[i];
            int p = people[i];
            for(int j=p;j<=max;j++){
                dp[j] = Math.min(dp[j], dp[j-p]+c);
            }
        }

        int ans = INF;
        for(int i=C;i<=max;i++){
            ans = Math.min(ans,dp[i]);
        }

        System.out.println(ans);
    }
}
