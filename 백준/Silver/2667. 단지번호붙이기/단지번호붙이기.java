import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int cnt=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        String str = sc.nextLine();
        for(int i=0;i<N;i++){
            ;
            str = sc.nextLine();

            for(int j=0;j<str.length();j++){
                int num = Integer.parseInt(String.valueOf(str.charAt(j)));
                map[i][j] = num;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j]==1){
                    cnt++;
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(cnt);
                    cnt=0;
                }

            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    public static void dfs(int curX, int curY){
        for(int d=0;d<4;d++){
            int nextX = curX + dx[d];
            int nextY = curY + dy[d];
            if(nextX < 0 || nextX>=N || nextY<0||nextY>=N){
                continue;
            }
            if(!visited[nextX][nextY] && map[nextX][nextY]==1){
                cnt++;
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }
}
