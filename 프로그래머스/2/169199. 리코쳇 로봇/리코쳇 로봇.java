import java.util.*;
class Solution {
    int N ;
    int M ;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        char[][] map = new char[N][M];
        int sX=0,sY=0;
        int gX=0,gY=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    sX = i;
                    sY = j;
                }
                if(map[i][j] == 'G'){
                    gX = i;
                    gY = j;
                }
            }
        }
        answer = BFS(sX,sY,gX,gY,map);
        return answer;
    }
    
    public int BFS(int sX, int sY, int gX, int gY, char[][] map){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sX,sY,0));
        
        boolean[][] visited = new boolean[N][M];
        visited[sX][sY] = true;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            if(cur.x == gX && cur.y == gY) return cur.dist;
            for(int d=0;d<4;d++){
                int nx = cur.x;
                int ny = cur.y;
                int move = 0;
                while(isRange(nx+dx[d],ny+dy[d]) 
                      && map[nx+dx[d]][ny+dy[d]] != 'D' ){
                    nx += dx[d];
                    ny += dy[d];
                    move++;
            
                }
                
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx,ny,cur.dist+1));
                }
            }
        }
        return -1;
    }
    
    public boolean isRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    
    public class Node{
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}