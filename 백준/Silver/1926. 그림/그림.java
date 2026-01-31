import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }

        answer = cnt == 0 ? 0 : answer;
        System.out.println(cnt);
        System.out.println(answer);
    }

    public static void bfs(int sx, int sy){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        int len = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int d = 0;d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    len++;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }

        answer = Math.max(answer, len);
        cnt++;
    }
}