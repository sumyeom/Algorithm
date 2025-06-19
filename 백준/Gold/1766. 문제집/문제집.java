
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n+1];

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph.get(start).add(end);
            inDegree[end]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();

            result.add(cur);
            for(int next : graph.get(cur)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.offer(next);
                }
            }
        }

        if(result.size()==n){
            for (Integer integer : result) {
                System.out.print(integer + " ");
            }
        }
    }
}