import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inDegree = new int[n+1];
        List<List<Integer>> student = new ArrayList<>();
        for(int i=0;i<=n;i++){
            student.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            student.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int cur = queue.poll();

            result.add(cur);
            for(int next : student.get(cur)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.offer(next);
                }
            }
        }

        if(result.size() == n){
            for(int re : result){
                System.out.print(re+" ");
            }
        }

    }
}