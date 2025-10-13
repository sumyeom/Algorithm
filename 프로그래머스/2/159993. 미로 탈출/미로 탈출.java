// 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로 빠져나감
// 출구를 레버가 당겨지지 않아도 지나갈 수 있긴함
// 모든 통로, 출구, 레버, 시작점은 여러번 지나갈 수 있음 -> 출구가 나왔다고 바로 끝이 아님
// 시작점 -> 레버, 레버 -> 출구 까지의 최단거리?
import java.util.*;
class Solution {
    int N,M;
    char[][] charMap;
    int[] dx = {-1,0,0,1};
    int[] dy = {0,-1,1,0};
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        int sX=0,sY=0,eX=0,eY=0,lX=0,lY=0;
        charMap = new char[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                charMap[i][j] = maps[i].charAt(j);
                if(charMap[i][j] == 'S'){
                    sX = i;
                    sY = j;
                }
                if(charMap[i][j] == 'L'){
                    lX = i;
                    lY = j;
                }
                if(charMap[i][j] == 'E'){
                    eX = i;
                    eY = j;
                }
            }
        }
        int temp=0;
        // 시작에서 레버까지 최단
        boolean[][] visitedL = new boolean[N][M];
        temp = BFS(sX, sY, lX, lY, visitedL);
        if(temp == -1) return -1 ;
        answer += temp;
        // 레버에서 출구까지 최단
        boolean[][] visitedE = new boolean[N][M];
        temp = BFS(lX, lY, eX, eY, visitedE);
        if(temp == -1) return -1 ;
        answer+= temp;
        return answer;
    }
    
    public int BFS(int sX, int sY, int gX, int gY, boolean[][] visited){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sX,sY,0));
        visited[sX][sY] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x==gX && cur.y == gY) {
                return cur.dist;
            }
            for(int d=0;d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                

                if(!isRange(nx,ny)) continue;
                
                if(!visited[nx][ny] && charMap[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx,ny,cur.dist+1));
                }
                
            }
        }
        return -1;
    }
    
    public boolean isRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    
    public class Node{
        int x,y,dist;
        public Node(int x,int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}