import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        while(TC-- > 0){
            // 팀 수
            int N = sc.nextInt();
            int[] lastYear = new int[N+1];
            List<List<Integer>> ranking = new ArrayList<>();
            int[] inDegree = new int[N+1];
            for(int i=1;i<=N;i++){
                lastYear[i] = sc.nextInt();
            }
            for(int i=0;i<=N;i++){
                ranking.add(new ArrayList<>());
            }

            for(int i=1;i<=N;i++){
                for(int j=i+1;j<=N;j++){
                    int front = lastYear[i];
                    int back = lastYear[j];

                    ranking.get(front).add(back);
                    inDegree[back]++;
                }
            }

            int M = sc.nextInt();
            for(int i=0;i<M;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (ranking.get(a).contains(b)) {
                    ranking.get(a).remove(Integer.valueOf(b));
                    inDegree[b]--;
                    ranking.get(b).add(a);
                    inDegree[a]++;
                } else {
                    ranking.get(b).remove(Integer.valueOf(a));
                    inDegree[a]--;
                    ranking.get(a).add(b);
                    inDegree[b]++;
                }

            }


            Queue<Integer> queue = new LinkedList<>();
            for(int i=1;i<=N;i++){
                if(inDegree[i] == 0){
                    queue.offer(i);
                }
            }

            List<Integer> result = new ArrayList<>();
            boolean notClean = false;
            boolean impossible = false;
            for(int i=0;i<N;i++){
                if(queue.isEmpty()){
                    impossible = true;
                    break;
                }

                if (queue.size() > 1) {
                    notClean = true;
                    break;
                }


                int cur = queue.poll();
                result.add(cur);
                for(int next:ranking.get(cur)){
                    inDegree[next]--;
                    if(inDegree[next]==0){
                        queue.offer(next);
                    }
                }
            }

            if(notClean){
                System.out.println("?");
            }
            else if(impossible){
                System.out.println("IMPOSSIBLE");
            }else{
                for(int num : result){
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }


    }
}