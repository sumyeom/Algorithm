import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<fares.length;i++){
            graph[fares[i][0]].add(new int[]{fares[i][1], fares[i][2]});
            graph[fares[i][1]].add(new int[]{fares[i][0], fares[i][2]});
        }
        
        // 다익스트라 S, A, B 출발점으로해서 3번 돌림
        int[] distS = dijkstra(n, s, graph);
        int[] distA = dijkstra(n, a, graph);
        int[] distB = dijkstra(n, b, graph);
        
        for(int i=1;i<=n;i++){
            if(distS[i] == Integer.MAX_VALUE ||
              distA[i] == Integer.MAX_VALUE ||
              distB[i] == Integer.MAX_VALUE) continue;
            
            int total = distS[i] + distA[i] + distB[i];
            
            answer = Math.min(total, answer);
            
        }
        return answer;
    }
    
    private int[] dijkstra(int n, int start, List<int[]>[] graph){
        int[] dist = new int[n+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(
        (a, b) -> a[1] - b[1]);
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 시작
        dist[start]=0;
        queue.offer(new int[]{start, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
        
            // 먼저 갔다왔을때 더 짧을 경우
            if(dist[cur[0]] < cur[1]) continue;
            
            for(int[] next : graph[cur[0]]){
                int nextTo = next[0];
                int nextCost = next[1] + cur[1];
                
                if(dist[nextTo] > nextCost){
                    dist[nextTo] = nextCost;
                    queue.offer(new int[]{nextTo, nextCost});
                }
            }
        }
        
        return dist;
    }
}