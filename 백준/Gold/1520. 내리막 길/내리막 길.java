import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){

                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        System.out.println( dfs(0,0));

    }

    public static int dfs(int sx, int sy){
        if(sx == M-1 && sy == N-1){
            return 1;
        }

        if(dp[sx][sy] != -1) {
            return dp[sx][sy];
        }

        dp[sx][sy] = 0;

        for(int d=0;d<4;d++){
            int nx = sx + dx[d];
            int ny = sy + dy[d];
            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

            if(map[nx][ny] < map[sx][sy]){
                dp[sx][sy] += dfs(nx, ny);
            }
        }

        return dp[sx][sy];
    }
}
