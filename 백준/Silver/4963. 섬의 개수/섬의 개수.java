import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int answer=0;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int w;
    static int h;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        while(true){
            w = sc.nextInt();
            h = sc.nextInt();
            if(w==0 && h==0){
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j] && map[i][j]==1){
                        visited[i][j] = true;
                        dfs(i,j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            answer=0;


        }
    }

    public static void dfs(int curX, int curY){
        for(int d=0;d<8;d++){
            int nextX = curX + dx[d];
            int nextY = curY + dy[d];
            if(nextX < 0 || nextX>=h || nextY<0||nextY>=w){
                continue;
            }
            if(!visited[nextX][nextY] && map[nextX][nextY]==1){
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }



    }
}
