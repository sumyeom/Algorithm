import jdk.jshell.Snippet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int[] dx = {0,0,0,0,-1,1};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dh = {-1,1,0,0,0,0};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][M][N];
        int[][][] tomato = new int[H][M][N];
        boolean[][][] visited = new boolean[H][M][N];

        for(int h=0;h<H;h++){
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int h=0;h<H;h++){
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    // 토마토 담기
                    if(map[h][i][j] == 1){
                        tomato[h][i][j] = -1;
                        queue.offer(new int[]{h,i,j,0});
                        visited[h][i][j] = true;
                    }else if(map[h][i][j] == -1){
                        tomato[h][i][j] = -1;
                    }
                }
            }
        }

        bfs(map, queue, visited, tomato);
        for(int h=0;h<H;h++){
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    // 토마토 담기
                    if(tomato[h][i][j] == 0){
                        System.out.println(-1);
                        System.exit(0);
                    }else{
                        answer = Math.max(answer, tomato[h][i][j]);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int[][][] map, Queue<int[]> queue, boolean[][][] visited, int[][][] tomato){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int d=0;d<6;d++){
                int nh = cur[0] + dh[d];
                int nx = cur[1] + dx[d];
                int ny = cur[2] + dy[d];

                if(nh < 0 || nh >= visited.length || nx < 0 || nx >= visited[0].length || ny < 0 || ny >= visited[0][0].length){
                    continue;
                }

                if(map[nh][nx][ny] == 0 && !visited[nh][nx][ny]){
                    queue.offer(new int[]{nh,nx,ny,cur[3]+1});
                    tomato[nh][nx][ny] = Math.max(tomato[nh][nx][ny], cur[3]+1);
                    visited[nh][nx][ny] = true;
                }
            }
        }
    }
}