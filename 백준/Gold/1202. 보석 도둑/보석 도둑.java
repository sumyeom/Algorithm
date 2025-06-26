import java.util.*;

public class Main {
    public static void main(String[] args){
       //System.out.println(solution(new int[][]{{3,2},{6,4},{4,7},{1,4}}, new int[][]{{4,2},{4,2},{2,4}}));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Target> targetList = new ArrayList<>();
        for(int i=0;i<N;i++){
            int m = sc.nextInt();
            int v = sc.nextInt();
            targetList.add(new Target(m,v));
        }
        List<Integer> bagList = new ArrayList<>();
        for(int i=0;i<K;i++){
            int bag = sc.nextInt();
            bagList.add(bag);
        }

        Collections.sort(targetList,(a, b) -> {
            if (a.m != b.m) return Integer.compare(a.m, b.m);
            return Integer.compare(a.v, b.v);
        });

        Collections.sort(bagList);

        PriorityQueue<Target> queue = new PriorityQueue<>((j1, j2) -> Integer.compare(j2.v, j1.v));

        long answer = 0;
        int index=0;
        for(int i=0;i<K;i++){
            while(index<N && bagList.get(i) >= targetList.get(index).m){
                queue.offer(targetList.get(index++));
            }

            if(!queue.isEmpty()){
                answer+=queue.poll().v;
            }

        }
        System.out.println(answer);
    }

    public static class Target{
        int m,v;
        public Target(int m,int v){
            this.m = m;
            this.v = v;
        }
    }



}