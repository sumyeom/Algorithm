import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>(
        (a,b) -> a[1] - b[1]);
        
        dist[1]=0;
        queue.offer(new int[]{1,0});
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            if(dist[now[0]] < now[1]) continue;
            
            for(int[] g : graph[now[0]]){
                int nextTo = g[0];
                int nextCost = g[1] + now[1];
                
                if(nextCost < dist[nextTo] && nextCost<=K){
                    queue.offer(new int[]{nextTo, nextCost});
                    dist[nextTo] = nextCost;
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}