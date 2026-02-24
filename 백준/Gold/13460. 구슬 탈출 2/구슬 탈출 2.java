import jdk.jshell.Snippet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int[] dx = {0,-1,1,0};
    static int[] dy = {-1,0,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];
        int rx=0,ry=0,bx=0,by=0;
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'R'){
                    rx = i;
                    ry = j;
                }
                if(map[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }
        System.out.println(bfs(rx,ry,bx,by,map,visited));

    }

    private static int bfs(int rx, int ry, int bx, int by, char[][] map, boolean[][][][] visited){
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(rx,ry,bx,by,0));
        visited[rx][ry][bx][by] = true;

        while(!queue.isEmpty()){
            State cur = queue.poll();
            if(cur.depth == 10) return -1;

            // 4방향으로 돌려보기
            for(int d=0;d<4;d++){
                Position nextR = move(d, cur.rx, cur.ry, map);
                Position nextB = move(d, cur.bx, cur.by, map);

                if(nextB.success) continue;
                if(nextR.success) return cur.depth + 1;

                if(nextR.x == nextB.x && nextR.y == nextB.y){
                    if(nextR.len > nextB.len){
                        nextR.x -= dx[d];
                        nextR.y -= dy[d];
                    }else{
                        nextB.x -= dx[d];
                        nextB.y -= dy[d];
                    }
                }

                if(!visited[nextR.x][nextR.y][nextB.x][nextB.y]){
                    visited[nextR.x][nextR.y][nextB.x][nextB.y] = true;
                    queue.offer(new State(nextR.x, nextR.y, nextB.x, nextB.y, cur.depth+1));
                }
            }
        }

        return -1;
    }

    private static Position move(int option, int cx, int cy, char[][] map){
        int len = 0;
        boolean success = false;

        while(true){
            int nx = cx + dx[option];
            int ny = cy + dy[option];

            if(map[nx][ny]=='#') break;

            cx = nx;
            cy = ny;
            len++;

            if(map[cx][cy] == 'O'){
                success = true;
                break;
            }
        }

        return new Position(cx,cy,len,success);
    }

    public static class Position{
        int x;
        int y;
        int len;
        boolean success;
        Position(int x, int y, int len, boolean success){
            this.x = x;
            this.y = y;
            this.len = len;
            this.success = success;
        }
    }

    public static class State{
        int rx;
        int ry;
        int bx;
        int by;
        int depth;
        State(int rx, int ry, int bx, int by, int depth){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }
}