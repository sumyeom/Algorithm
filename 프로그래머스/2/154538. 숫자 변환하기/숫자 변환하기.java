import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = BFS(x,y,n);
        return answer;
    }
    
    public int BFS(int x, int y, int n){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        q.offer(new int[]{x,0});
        visited[x] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == y) return cur[1];
            for(int d=0;d<3;d++){
                int next = changeNumber(cur[0],d,n);
                if(next <= 0 || next > 1000000) continue;
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, cur[1]+1});
                }
            }
        }
        return -1;
    }
    
    public int changeNumber(int cur, int mode, int n){
        if(mode == 0) return cur+n;
        else if(mode==1) return cur*2;
        else return cur * 3;
    }
}