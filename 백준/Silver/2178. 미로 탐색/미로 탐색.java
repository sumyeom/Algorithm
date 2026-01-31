import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            char[] row = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                map[i][j] = row[j] - '0';
            }
        }

        bfs(0,0);
    }

    public static void bfs(int sx, int sy){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sx,sy,1));
        visited[sx][sy] = true;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if(curNode.x == N-1 && curNode.y == M-1){
                System.out.println(curNode.len);
                return;
            }
            for(int d=0;d<4;d++){
                int nx = curNode.x + dx[d];
                int ny = curNode.y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(!visited[nx][ny] && map[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx,ny,curNode.len+1));
                }
            }

        }

    }
    public static class Node{
        int x;
        int y;
        int len;
        public Node(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }


}