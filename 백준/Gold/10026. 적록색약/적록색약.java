import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static char[][] map;
    static char[][] mapRG;
    static boolean[][] visited;
    static boolean[][] visitedRG;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        mapRG = new char[N][N];
        visited = new boolean[N][N];
        visitedRG = new boolean[N][N];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'G'){
                    mapRG[i][j] = 'R';
                }else{
                    mapRG[i][j] = map[i][j];
                }
            }
        }
        int cnt = 0;
        int cntRG = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs(i,j,1);
                    cnt++;
                }
                if(!visitedRG[i][j]){
                    dfs(i,j,2);
                    cntRG++;
                }
            }
        }

        System.out.println(cnt + " " + cntRG);
    }

    private static void dfs(int sx, int sy, int option){
        for(int d=0;d<4;d++){
            int nx = sx + dx[d];
            int ny = sy + dy[d];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if(option == 1){
                if(!visited[nx][ny] && map[nx][ny] == map[sx][sy]){
                    visited[nx][ny] = true;
                    dfs(nx,ny,1);
                }
            }else{
                if(!visitedRG[nx][ny] && mapRG[nx][ny] == mapRG[sx][sy]){
                    visitedRG[nx][ny] = true;
                    dfs(nx,ny,2);
                }
            }

        }
    }

}
