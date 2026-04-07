import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 변수 선언
        int answer = 0;
        int[] dist = new int[N+1];
        List<int[]>[] graph = new ArrayList[N+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(
        (a, b) -> a[1] - b[1]);
        
        // 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 간선 노드 비용 넣기
        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            
            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }
        
        // 다익스트라(1번 노드에서 시작)
        dist[1] = 0;
        queue.offer(new int[]{1,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curTo = cur[0];
            int curCost = cur[1];
            // 이미 다녀왔다면, 다녀온게 더 적다면
            if(dist[curTo] < curCost) continue;
            
            // 그래프와 이어져 있는 곳 탐색
            for(int[] next : graph[curTo]){
                int nextTo = next[0];
                int nextCost = next[1] + curCost;
                
                // 가야될 목적지 비용이 갔다온 곳보다 적고, K 이하라면
                if(nextCost < dist[nextTo] && nextCost <= K){
                    queue.offer(new int[]{nextTo, nextCost});
                    // 이렇게하면 각 목적지에 가는데 걸린 최소 비용 구할수있음
                    dist[nextTo] = nextCost; 
                }
            }
        }
        
        // 걸린 비용에서 K 이하인 노드 구하기
        for(int i=1;i<=N;i++){
            if(dist[i] <=K) answer++;
        }
        

        return answer;
    }
}