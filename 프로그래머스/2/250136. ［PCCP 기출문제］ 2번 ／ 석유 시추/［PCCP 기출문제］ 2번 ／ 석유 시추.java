import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[][] landNum = new int[land.length][land[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        int landIndex = 1;

        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                if(!visited[i][j] && land[i][j] == 1){
                    Queue<Position> queue = new LinkedList<>();
                    queue.offer(new Position(i,j));
                    visited[i][j] = true;
                    landNum[i][j] = landIndex;
                    int cnt = 0 ;
                    while(!queue.isEmpty()){
                        Position cur = queue.poll();
                        cnt++;
                        for(int d=0;d<4;d++){
                            int nextX = cur.x + dx[d];
                            int nextY = cur.y + dy[d];
                            if(nextX < 0 || nextX >= land.length || nextY <0 || nextY>=land[0].length){
                                continue;
                            }
                            if(!visited[nextX][nextY] && land[nextX][nextY]==1){
                                visited[nextX][nextY] = true;
                                queue.offer(new Position(nextX, nextY));
                                landNum[nextX][nextY] = landIndex;
                            }
                        }
                    }
                    map.put(landIndex, cnt);
                    landIndex++;

                }
            }
        }

        for(int j=0;j<land[0].length;j++){
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for(int i=0;i<land.length;i++){
                int oilId = landNum[i][j];
                if(oilId!=0 && set.add(oilId)){
                    sum+=map.get(oilId);
                }
            }
            answer = Math.max(answer, sum);
        }


        return answer;
    }

    public class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}