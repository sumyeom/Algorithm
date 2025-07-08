import java.util.*;
class Solution {
    int N;
    int M;
    char[][] map;
    boolean[][] visited;
    List<Integer> result = new ArrayList<>();
    int[] dx = {-1,0,0,1};
    int[] dy = {0,-1,1,0};
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = maps[i].charAt(j);
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] != 'X' && !visited[i][j]){
                    bfs(i,j,0);
                }
            }
        }
        if(!result.isEmpty()){
            Collections.sort(result);
            return result.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        return new int[]{-1};
    }
    
    public void bfs(int startX, int startY, int len){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        len+=map[startX][startY] - 48;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int d=0;d<4;d++){
                int nextX = cur[0] + dx[d];
                int nextY = cur[1] + dy[d];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(map[nextX][nextY] != 'X' && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                    len+=map[nextX][nextY] - 48;
                }
            }
        }
        if(len != 0){
            result.add(len);
        }

    }
}