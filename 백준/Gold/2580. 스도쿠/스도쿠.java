import java.util.*;

/**
 * 백준 2580
 * DFS(백트래킹)
 */
public class Main {
    static int[][] map = new int[9][9];
    static List<Position> zeroList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0){
                    zeroList.add(new Position(i,j));
                }
            }
        }
        visited = new boolean[zeroList.size()];

        dfs(0);

    }

    public static void dfs(int index){
        if(index == zeroList.size()){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        Position pos = zeroList.get(index);
        for(int num=1;num<=9;num++){
            if(isValid(pos,num)){
                map[pos.x][pos.y] = num;
                dfs(index+1);
                map[pos.x][pos.y] = 0;
            }
        }
    }

    public static boolean isValid(Position cur,int num){
        // 가로 검사
        for (int i = 0; i < 9; i++) {
            if (map[cur.x][i] == num) return false;
        }

        // 세로 검사
        for (int i = 0; i < 9; i++) {
            if (map[i][cur.y] == num) return false;
        }
        int startX = (cur.x / 3) * 3;
        int startY = (cur.y / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }
    public static class Position{
        int x,y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}



