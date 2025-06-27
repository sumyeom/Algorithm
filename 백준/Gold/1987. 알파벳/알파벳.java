import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int R,C;
    static List<Character> list = new ArrayList<>();
    static int answer=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];
        String str = sc.nextLine();
        for(int i=0;i<R;i++){
            ;
            str = sc.nextLine();

            for(int j=0;j<str.length();j++){
                char num = str.charAt(j);
                map[i][j] = num;
            }
        }

        visited[0][0] = true;
        list.add(map[0][0]);
        dfs(0,0);
        System.out.println(answer);
    }

    public static void dfs(int curX, int curY){
        for(int d=0;d<4;d++){
            int nextX = curX + dx[d];
            int nextY = curY + dy[d];
            if(nextX < 0 || nextX>=R || nextY<0||nextY>=C){
                continue;
            }
            if(!visited[nextX][nextY] && !list.contains(map[nextX][nextY])){
                visited[nextX][nextY] = true;
                list.add(map[nextX][nextY]);
                dfs(nextX, nextY);
                visited[nextX][nextY] = false;
                list.remove(list.size()-1);
            }
        }

        answer = Math.max(answer, list.size());
    }
}
