import java.util.*;
class Solution {
    static boolean[][] visited = new boolean[100][100];
    static int[][] lenMap = new int[100][100];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length;j++){
                lenMap[i][j] = 0;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        bfs(maps, queue);

        if(lenMap[maps.length-1][maps[0].length-1] == 0){
            return -1;
        }
        answer = lenMap[maps.length-1][maps[0].length-1]+1;
        return answer;
    }

    public void bfs(int[][] maps,Queue<int[]> queue) {

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            if(curX == maps.length-1 && curY == maps[0].length-1) {

                return;
            }
            for(int i=0;i<4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) {
                    continue;
                }
                if(!visited[nextX][nextY] && maps[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    lenMap[nextX][nextY] = lenMap[curX][curY] + 1;
                }
            }
        }

        return;
    }
}