import jdk.jshell.Snippet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] >= 1 && !visited[i][j]){
                    bfs(i, j, map, visited);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int cx, int cy, int[][] map, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> tempQueue = new LinkedList<>();
        queue.offer(new int[]{cx,cy});
        tempQueue.offer(new int[]{cx,cy});
        visited[cx][cy] = true;

        // 먼저 같은 높이가 주위에 있는지 확인 - 큰게 있으면 return
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int d=0;d<8;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length){
                    continue;
                }

                if(map[cx][cy] == map[nx][ny] && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                    tempQueue.offer(new int[]{nx,ny});
                }
            }
        }


        if(increase(map, tempQueue)) answer++;

    }

    private static boolean increase(int[][] map, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] curP = queue.poll();

            for(int d=0;d<8;d++){
                int nx = curP[0] + dx[d];
                int ny = curP[1] + dy[d];

                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length){
                    continue;
                }

                if(map[curP[0]][curP[1]] < map[nx][ny]) return false;
            }
        }
        return true;
    }


}