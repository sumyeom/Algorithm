import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int[][] map;
    static int[][] cnt;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cnt = new int[N][M];
        visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    queue.offer(new Node(i,j,0));
                    cnt[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int d=0;d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx<0||nx>=N||ny<0||ny>=M) continue;;
                if(visited[nx][ny] || map[nx][ny] != 0) continue;

                visited[nx][ny] = true;
                cnt[nx][ny] = cur.len + 1;
                queue.offer(new Node(nx,ny, cur.len+1));
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, cnt[i][j]);
            }
        }

        System.out.println(answer);

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