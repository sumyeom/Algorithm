import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[1] = 0;
        queue.offer(1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: graph[cur]){
                if(!visited[next] && dist[cur] + 1< dist[next]){
                    visited[next] = true;
                    queue.offer(next);
                    dist[next] = dist[cur]+1;
                }
            }
        }
        
        int max = 0;
        for(int i=1;i<=n;i++){
            max = Math.max(max, dist[i]);
        }
        
        for(int i=1;i<=n;i++){
            if(dist[i] == max){
                answer++;
            }
        }
        return answer;
    }
}